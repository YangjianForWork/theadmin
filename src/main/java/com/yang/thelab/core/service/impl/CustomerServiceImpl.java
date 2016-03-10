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
            //TODO 需要改动
            if (e.getMessage().contains(UniqueEnum.UQ_CR_NICKNMAE.code())) {
                throw new BizException(UniqueEnum.UQ_CR_NICKNMAE.bizCode(),e);
            }
            if (e.getMessage().contains(UniqueEnum.UQ_CR_MOBILE.code())) {
                throw new BizException(UniqueEnum.UQ_CR_MOBILE.bizCode(),e);
            }
            if (e.getMessage().contains(UniqueEnum.UQ_CR_EXTNO.code())) {
                throw new BizException(UniqueEnum.UQ_CR_EXTNO.bizCode(),e);
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
