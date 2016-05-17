package com.yang.thelab.biz.manager.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.biz.dto.ReserveDTO;
import com.yang.thelab.biz.manager.PersonManager;
import com.yang.thelab.biz.manager.ReserveManager;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.ReserveDAO;
import com.yang.thelab.common.dataobj.ReserveDO;
import com.yang.thelab.common.enums.DateFormatEnum;
import com.yang.thelab.common.enums.LabReserveExecStatus;
import com.yang.thelab.common.enums.LabReserveStatus;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.requ.ReserveQueryRequ;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.LaboratoryModel;
import com.yang.thelab.core.model.ReserveExecModel;
import com.yang.thelab.core.model.ReserveModel;
import com.yang.thelab.core.service.LaboratoryService;
import com.yang.thelab.core.service.ReserveExecService;
import com.yang.thelab.core.service.ReserveService;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveManagerImpl.java, v 0.1 2016年5月3日 下午7:18:44 dev Exp $
 */
public class ReserveManagerImpl implements ReserveManager, InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(ReserveManagerImpl.class);

    @Autowired
    private ReserveDAO          reserveDAO;
    @Autowired
    private ReserveService      reserveService;
    @Autowired
    private ReserveExecService  reserveExecService;
    @Autowired
    private PersonManager       personManager;
    @Autowired
    private LaboratoryService   laboratoryService;
    /**轮询*/
    private boolean             startSchduler;

    public Paginator<ReserveDTO> query(ReserveQueryRequ requ) {
        Paginator<ReserveDO> data = reserveDAO.compQuery(requ);
        Paginator<ReserveDTO> result = new Paginator<ReserveDTO>(data.getItemsPerPage(),
            data.getItems());
        result.setPage(data.getPage());
        List<ReserveDTO> listDTO = new ArrayList<ReserveDTO>();
        for (ReserveDO reserveDO : data.getPdate()) {
            ReserveDTO DTO = new ReserveDTO(reserveDO.get());
            DTO.setRoleLevel(requ.getRoleLevel());
            DTO.setApplyPer(personManager.get(reserveDO.get().getApplyPersNO()));
            DTO.setDealPer(personManager.get(reserveDO.get().getDealPersNO()));
            DTO.setLab(laboratoryService.get(reserveDO.get().getLabNO()));
            listDTO.add(DTO);
        }
        result.setPdate(listDTO);
        return result;
    }

    public void save(ReserveDTO DTO) {
        ReserveModel model = new ReserveModel(DTO.get());
        boolean insert = CommUtil.isInsert(model);
        if (insert) {
            if (StringUtils.isBlank(DTO.getStartDateStr())) {
                throw new BizException(BizCode.PARAM_CHECK);
            }
            if (StringUtils.isBlank(DTO.getEndDateStr())) {
                throw new BizException(BizCode.PARAM_CHECK);
            }
            DateFormat format = new SimpleDateFormat(DateFormatEnum.SIMPLE.code());
            try {
                Date date = format.parse(DTO.getStartDateStr());
                model.get().setBeginDate(date);
                date = format.parse(DTO.getEndDateStr());
                model.get().setFinishDate(date);
            } catch (ParseException e) {
                throw new BizException(BizCode.RESERVE_DATE_FAULT);
            }
            if (model.get().getBeginDate().equals(model.get().getFinishDate())) {
                throw new BizException(BizCode.RESERVE_DATE_IS_SHORT);
            }
            if (model.get().getBeginDate().before(new Date())) {
                throw new BizException(BizCode.DATE_HAD_PASS);
            }
            if (model.get().getBeginDate().after(model.get().getFinishDate())) {
                throw new BizException(BizCode.DATE_SEQ_WRONG);
            }
            //model.get().setStatus(LabReseveStatus.INIT);
            //逻辑这里要加一个通知流程，所以暂时先将设为下一个状态
            model.get().setStatus(LabReserveStatus.WAIT_ADUIT);
            model.get().setBookDate(new Date());
            model.get().setDealReson("-");
            checkTheReserve(model);
        }
        reserveService.save(model);
        if (StringUtils.isNoneBlank(model.getBizNO())) {
            DTO.set(reserveService.get(model.getBizNO()).get());
        }
        if (insert) {
            ReserveExecModel execModel = new ReserveExecModel();
            //execModel.get().setStatus(LabReserveExecStatus.INIT);
            //逻辑这里要加一个通知流程，所以暂时先将设为下一个状态
            execModel.get().setStatus(LabReserveExecStatus.WAIT_EXEC);
            execModel.get().setReserveNO(model.getBizNO());
            execModel.get().setDealPersNO(model.get().getDealPersNO());
            reserveExecService.save(execModel);
        }
    }

    private void checkTheReserve(ReserveModel model) {
        DateFormat dFormat = new SimpleDateFormat(DateFormatEnum.SIMPLE.code());
        Date date1 = new Date();
        Date date2 = new Date();
        boolean doEx = false;
        //判断一个实验室的容量
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("labNO", model.get().getLabNO());
        params.put("statusList", LabReserveStatus.ING_STATUS);
        Long labResCount = reserveService.getLabResCount(params);
        LaboratoryModel laboratoryModel = laboratoryService.get(model.get().getLabNO());
        if ((labResCount + "").equals(laboratoryModel.get().getContent())) {
            throw new BizException(BizCode.PARAM_CHECK, "实验室容量已经满额了");
        }
        //判断同一个人预约单的实验室时间冲突
        ReserveQueryRequ requ = new ReserveQueryRequ();
        requ.setApplyPersNO(model.get().getApplyPersNO());
        requ.setStatusList(LabReserveStatus.ING_STATUS);
        Paginator<ReserveDO> compQuery = reserveDAO.compQuery(requ);
        List<ReserveDO> pdate = compQuery.getPdate();
        String labName = "";
        for (ReserveDO DO : pdate) {
            LaboratoryModel labModel = laboratoryService.get(DO.get().getLabNO());
            Date beginDate = model.get().getBeginDate();
            Date finishDate = model.get().getFinishDate();
            labName = labModel.get().getName();
            if (beginDate.equals(DO.get().getBeginDate())) {
                date1 = beginDate;
                date2 = finishDate;
                doEx = true;
                if (finishDate.after(DO.get().getFinishDate())) {
                    date2 = DO.get().getFinishDate();
                }
                break;
            }
            if (beginDate.after(DO.get().getBeginDate())
                && beginDate.before(DO.get().getFinishDate())) {
                date1 = beginDate;
                date2 = finishDate;
                doEx = true;
                if (finishDate.after(DO.get().getFinishDate())) {
                    date2 = DO.get().getFinishDate();
                }
                break;
            }
            if (finishDate.after(DO.get().getBeginDate())
                && finishDate.before(DO.get().getFinishDate())) {
                date1 = DO.get().getBeginDate();
                date2 = finishDate;
                doEx = true;
                if (beginDate.after(DO.get().getBeginDate())) {
                    date1 = beginDate;
                }
                break;
            }
        }
        if (doEx) {
            throw new BizException(BizCode.RESERVE_DATE_FAULT,
                "[" + dFormat.format(date1) + "]-[" + dFormat.format(date2) + "]内你已预约了<" + labName
                                                               + ">");
        }
    }

    public void setStartSchduler(boolean startSchduler) {
        this.startSchduler = startSchduler;
    }

    public void schduler() {
        if (!startSchduler) {
            return;
        }
        Thread autoFinishReserve = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        autoFinishReserve();
                    } catch (Exception e) {
                        LOG.error("AutoFinishReserve error.", e);
                    } finally {
                        try {
                            Thread.sleep(60 * 1000);
                        } catch (InterruptedException e) {
                            LOG.error(e.getMessage());
                        }
                    }
                }
            }

        });
        autoFinishReserve.setDaemon(true);
        autoFinishReserve.setName("Thread-Auto-01");
        autoFinishReserve.start();
    }

    private void autoFinishReserve() {
        List<ReserveModel> inUseLabResList = reserveService.getInUseLabResList();
        if (CollectionUtils.isEmpty(inUseLabResList)) {
            return;
        }
        for (ReserveModel reserveModel : inUseLabResList) {
            if (reserveModel.get().getFinishDate().after(new Date())) {
                continue;
            }
            reserveModel.get().setStatus(LabReserveStatus.FINISH);
            reserveService.save(reserveModel);
        }
    }

    public void afterPropertiesSet() throws Exception {
        schduler();
    }
}
