package com.yang.thelab.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.yang.thelab.common.dal.CustomerDAO;
import com.yang.thelab.common.dataobj.CustomerDO;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.utils.SecurityUtil;
import com.yang.thelab.core.model.CustomerModel;
import com.yang.thelab.core.service.CustomerService;

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
            throw new BizException(CommUtil.getDuplicateKeyItem(e.getMessage()).bizCode());
        }
    }

    public CustomerModel get(String bizNO) {
        CustomerModel model = new CustomerModel();
        if (StringUtils.isNotBlank(bizNO)) {
            model = new CustomerModel(customerDAO.getByKey(bizNO).get());
        }
        return model;
    }

    public List<CustomerModel> getByKeyList(List<String> custNOList) {
        return CommUtil.covDOList2ModelList(CustomerModel.class,
            customerDAO.getByKeyList(custNOList));
    }

    public CustomerModel checkLogin(String userName, String pwd) {
        CustomerDO customerDO = customerDAO.getByCond(userName, null, null);
        if (null == customerDO) {
            customerDO = customerDAO.getByCond(null, userName, null);
        }
        if (null == customerDO) {
            customerDO = customerDAO.getByCond(null, null, userName);
        }
        if (null == customerDO || StringUtils.isBlank(customerDO.getBizNO())) {
            throw new BizException(BizCode.CUST_NOT_FOUND);
        }
        if (!customerDO.get().getPassword().equals(SecurityUtil.getHash(pwd))) {
            throw new BizException(BizCode.CUST_LOGIN_FAIL);
        }
        return new CustomerModel(customerDO.get());
    }
}
