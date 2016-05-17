package com.yang.thelab.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.common.dal.ReserveDAO;
import com.yang.thelab.common.dataobj.ReserveDO;
import com.yang.thelab.common.enums.LabReserveStatus;
import com.yang.thelab.common.requ.ReserveQueryRequ;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.ReserveModel;
import com.yang.thelab.core.service.ReserveService;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveServiceImpl.java, v 0.1 2016年5月3日 下午7:25:07 dev Exp $
 */
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveDAO reserveDAO;

    public void save(ReserveModel model) {
        ReserveDO DO = new ReserveDO(model.get());
        if (CommUtil.isInsert(model)) {
            reserveDAO.insert(DO);
            model.setBizNO(DO.getBizNO());
        } else {
            reserveDAO.update(DO);
        }
    }

    public ReserveModel get(String bizNO) {
        return new ReserveModel(reserveDAO.getByKey(bizNO).get());
    }

    public ReserveModel getApplyIngReserve(String applyPersNO) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("applyPersNO", applyPersNO);
        params.put("statusList", LabReserveStatus.ING_STATUS);
        List<ReserveDO> list = reserveDAO.getByCondtion(params);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return new ReserveModel(list.get(0).get());
    }

    public List<ReserveModel> getInUseLabResList() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        List<String> statusList = new ArrayList<String>();
        statusList.add(LabReserveStatus.AGREE.code());
        params.put("statusList", statusList);
        return CommUtil.covDOList2ModelList(ReserveModel.class, reserveDAO.getByCondtion(params));
    }

    public Long getCount(ReserveQueryRequ requ) {
        return reserveDAO.getCount(requ);
    }

    public Long getLabResCount(HashMap<String, Object> params) {
        return reserveDAO.getLabResCount(params);
    }
    

}
