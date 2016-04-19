package com.yang.thelab.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.biz.dto.LaboratoryDTO;
import com.yang.thelab.biz.manager.LaboratoryManager;
import com.yang.thelab.biz.manager.PersonManager;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.EnumItemDAO;
import com.yang.thelab.common.dal.LaboratoryDAO;
import com.yang.thelab.common.dataobj.LaboratoryDO;
import com.yang.thelab.common.requ.LaboratoryQueryRequ;
import com.yang.thelab.common.utils.CommUtil;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryManagerImpl.java, v 0.1 2016年3月16日 下午12:52:29 dev Exp $
 */
public class LaboratoryManagerImpl implements LaboratoryManager {

    @Autowired
    private LaboratoryDAO laboratoryDAO;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private EnumItemDAO   enumItemDAO;

    public Paginator<LaboratoryDTO> query(LaboratoryQueryRequ requ) {
        Paginator<LaboratoryDO> data = laboratoryDAO.compQuery(requ);
        Paginator<LaboratoryDTO> result = new Paginator<LaboratoryDTO>(data.getItemsPerPage(),
            data.getItems());
        result.setPage(data.getPage());
        List<LaboratoryDTO> listDTO = new ArrayList<LaboratoryDTO>();
        for (LaboratoryDO DO : data.getPdate()) {
            LaboratoryDTO DTO = new LaboratoryDTO(CommUtil.hideBaseFeild(DO.get()));
            if (StringUtils.isNotBlank(DO.get().getMasterNO())) {
                DTO.setMaster(personManager.get(DO.get().getMasterNO()));
            }
            DTO.setStatuDesc(DO.get().getStatus().desc());
            DTO.setCategory(CommUtil.hideBaseFeild(enumItemDAO.getByKey(DO.get().getCategoryNO()).get()));
            DTO.setAttribute(CommUtil.hideBaseFeild(enumItemDAO.getByKey(DO.get().getAttributeNO()).get()));
            listDTO.add(DTO);
        }
        result.setPdate(listDTO);
        return result;
    }
}
