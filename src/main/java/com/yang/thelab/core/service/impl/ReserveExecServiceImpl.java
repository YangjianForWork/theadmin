/**
 * Yixiu.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 */
package com.yang.thelab.core.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.common.dal.ReserveExecDAO;
import com.yang.thelab.common.dataobj.ReserveExecDO;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.ReserveExecModel;
import com.yang.thelab.core.service.ReserveExecService;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveExecServiceImpl.java, v 0.1 2016年5月3日 下午7:32:48 dev Exp $
 */
public class ReserveExecServiceImpl implements ReserveExecService {

    @Autowired
    private ReserveExecDAO reserveExecDAO;
    
    public void save(ReserveExecModel model) {
        ReserveExecDO DO = new ReserveExecDO(model.get());
        if (CommUtil.isInsert(model)) {
            reserveExecDAO.insert(DO);
            model.setBizNO(DO.getBizNO());
        }else {
            reserveExecDAO.update(DO);
        }
        
    }
    public ReserveExecModel get(String bizNO) {
        if (StringUtils.isBlank(bizNO)) {
            throw new BizException(BizCode.PARAM_CHECK);
        }
        return new ReserveExecModel(reserveExecDAO.getByKey(bizNO).get());
    }
    public List<ReserveExecModel> getByCond(String reserveNO, String personNO) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("reserveNO", reserveNO);
        params.put("dealPersNO", personNO);
        List<ReserveExecDO> doList = reserveExecDAO.getByCond(params);
        return CommUtil.covDOList2ModelList(ReserveExecModel.class, doList);
    }

}
