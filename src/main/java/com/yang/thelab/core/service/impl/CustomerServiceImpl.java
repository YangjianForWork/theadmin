package com.yang.thelab.core.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.yang.thelab.common.dal.CustomerDAO;
import com.yang.thelab.common.dataobj.CustomerDO;
import com.yang.thelab.common.enums.UniqueEnum;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.utils.SecurityUtil;
import com.yang.thelab.core.service.CustomerService;
import com.yang.thelab.core.service.model.CustomerModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: CustomerServiceImpl.java, v 0.1 2016年3月10日 下午5:37:07 dev Exp $
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public void save(CustomerModel model) {
        CustomerDO DO = new CustomerDO(model.get());
        try {
            if (StringUtils.isBlank(DO.getBizNO())) {
                DO.get().setPassword(SecurityUtil.getHash(model.get().getPassword()));
                customerDAO.insert(DO);
                model.setBizNO(DO.getBizNO());
            } else {
                customerDAO.update(DO);
            }
        } catch (DuplicateKeyException e) {
        	String message = e.getMessage();
        	System.out.println(message.substring(message.length()-17));
            //TODO 需要改动
        	boolean equals = e.getMessage().contentEquals(new StringBuffer(UniqueEnum.UQ_CR_NICKNMAE.code()));
        	System.out.println(equals);
        	
            if (equals) {
                throw new BizException(UniqueEnum.UQ_CR_NICKNMAE.bizCode());
            }
            if (e.getMessage().contains(UniqueEnum.UQ_CR_MOBILE.code())) {
                throw new BizException(UniqueEnum.UQ_CR_MOBILE.bizCode());
            }
            if (e.getMessage().contains(UniqueEnum.UQ_CR_EXTNO.code())) {
                throw new BizException(UniqueEnum.UQ_CR_EXTNO.bizCode());
            }
        }
    }

    public CustomerModel get(String bizNO) {
        CustomerModel model = new CustomerModel();
        if (StringUtils.isNotBlank(bizNO)) {
            model = new CustomerModel(customerDAO.getByKey(bizNO).get());
        }
        return model;
    }

}
