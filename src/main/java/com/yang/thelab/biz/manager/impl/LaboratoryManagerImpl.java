package com.yang.thelab.biz.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.biz.dto.LabSiteDTO;
import com.yang.thelab.biz.dto.LaboratoryDTO;
import com.yang.thelab.biz.manager.LaboratoryManager;
import com.yang.thelab.biz.manager.PersonManager;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.EnumItemDAO;
import com.yang.thelab.common.dal.LabSiteDAO;
import com.yang.thelab.common.dal.LaboratoryDAO;
import com.yang.thelab.common.dataobj.LabSiteDO;
import com.yang.thelab.common.dataobj.LaboratoryDO;
import com.yang.thelab.common.enums.LabReserveStatus;
import com.yang.thelab.common.enums.LabStatus;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.requ.LabSiteQueryRequ;
import com.yang.thelab.common.requ.LaboratoryQueryRequ;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.LaboratoryModel;
import com.yang.thelab.core.service.LaboratoryService;
import com.yang.thelab.core.service.ReserveService;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryManagerImpl.java, v 0.1 2016年3月16日 下午12:52:29 dev Exp $
 */
public class LaboratoryManagerImpl implements LaboratoryManager {

    @Autowired
    private LaboratoryDAO                          laboratoryDAO;
    @Autowired
    private LabSiteDAO                             labSiteDAO;
    @Autowired
    private PersonManager                          personManager;
    @Autowired
    private EnumItemDAO                            enumItemDAO;
    @Autowired
    private LaboratoryService                      laboratoryService;
    @Autowired
    private ReserveService                         reserveService;

    private static Map<LabStatus, List<LabStatus>> REF_STATUS_CHANGE = new HashMap<LabStatus, List<LabStatus>>();

    static {
        //--
        List<LabStatus> myChange = new ArrayList<LabStatus>();
        REF_STATUS_CHANGE.put(LabStatus.NORMAL, myChange);
        myChange.add(LabStatus.RESERVE);
        //--
        myChange = new ArrayList<LabStatus>();
        REF_STATUS_CHANGE.put(LabStatus.RESERVE, myChange);
        myChange.add(LabStatus.NORMAL);
        myChange.add(LabStatus.IN_USE);
        //--
        myChange = new ArrayList<LabStatus>();
        REF_STATUS_CHANGE.put(LabStatus.IN_USE, myChange);
        myChange.add(LabStatus.NORMAL);
    }

    public Paginator<LaboratoryDTO> query(LaboratoryQueryRequ requ) {
        Paginator<LaboratoryDO> data = laboratoryDAO.compQuery(requ);
        Paginator<LaboratoryDTO> result = new Paginator<LaboratoryDTO>(data.getItemsPerPage(),
            data.getItems());
        result.setPage(data.getPage());
        List<LaboratoryDTO> listDTO = new ArrayList<LaboratoryDTO>();
        for (LaboratoryDO DO : data.getPdate()) {
            LaboratoryDTO DTO = new LaboratoryDTO(DO.get());
            DTO.setCurrResCount(getLabReserveCount(DO.getBizNO()));
            setDTO(DTO);
            listDTO.add(DTO);
        }
        result.setPdate(listDTO);
        return result;
    }

    private Long getLabReserveCount(String labNO) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("labNO", labNO);
        List<String> statusList = new ArrayList<String>();
        statusList.add(LabReserveStatus.AGREE.code());
        params.put("statusList", statusList);
        params.put("currTime", System.currentTimeMillis());
        return reserveService.getLabResCount(params);
    }

    public void save(LaboratoryDTO DTO) {
        LaboratoryModel model = new LaboratoryModel(DTO.get());
        //boolean isInsert = CommUtil.isInsert(model);
        laboratoryService.save(model);
    }

    public void updateStatus(String status, String bizNO) {
        if (StringUtils.isNotBlank(status) && StringUtils.isNotBlank(bizNO)) {
            LabStatus currStatus = CommUtil.getEnumByCode(LabStatus.class, status);
            LaboratoryModel model = laboratoryService.get(bizNO);
            if (null == model) {
                throw new BizException(BizCode.PARAM_CHECK);
            }
            LabStatus oldStatus = model.get().getStatus();
            if (validStatus(currStatus, oldStatus)) {
                model.get().setStatus(currStatus);
                laboratoryService.save(model);
            }
        }
    }

    /**
     * 校验参数
     * 
     * @param currStatus
     * @param oldStatus
     * @return
     */
    private boolean validStatus(LabStatus currStatus, LabStatus oldStatus) {
        List<LabStatus> checkList = REF_STATUS_CHANGE.get(oldStatus);
        if (!checkList.contains(currStatus)) {
            throw new BizException(BizCode.STATUS_CHECK);
        }
        return true;
    }

    public LaboratoryDTO get(String bizNO) {
        if (StringUtils.isBlank(bizNO)) {
            throw new BizException(BizCode.PARAM_CHECK);
        }
        LaboratoryDO DO = laboratoryDAO.getByKey(bizNO);
        if (null == DO || StringUtils.isBlank(DO.getBizNO())) {
            throw new BizException();
        }
        LaboratoryDTO DTO = new LaboratoryDTO(DO.get());
        DTO.setCurrResCount(getLabReserveCount(DO.getBizNO()));
        setDTO(DTO);
        return DTO;
    }

    private void setDTO(LaboratoryDTO DTO) {
        if (StringUtils.isNotBlank(DTO.get().getMasterNO())) {
            DTO.setMaster(personManager.get(DTO.get().getMasterNO()));
        }
        DTO.setStatuDesc(DTO.get().getStatus().desc());
        DTO.setCategory(
            CommUtil.hideBaseFeild(enumItemDAO.getByKey(DTO.get().getCategoryNO()).get()));
        DTO.setAttribute(
            CommUtil.hideBaseFeild(enumItemDAO.getByKey(DTO.get().getAttributeNO()).get()));

    }

    public Paginator<LabSiteDTO> query(LabSiteQueryRequ requ) {
        Paginator<LabSiteDO> data = labSiteDAO.compQuery(requ);
        Paginator<LabSiteDTO> result = new Paginator<LabSiteDTO>(data.getItemsPerPage(),
            data.getItems());
        result.setPage(data.getPage());
        List<LabSiteDTO> listDTO = new ArrayList<LabSiteDTO>();
        for (LabSiteDO DO : data.getPdate()) {
            LabSiteDTO DTO = new LabSiteDTO(CommUtil.hideBaseFeild(DO.get()));
            listDTO.add(DTO);
        }
        result.setPdate(listDTO);
        return result;
    }
}
