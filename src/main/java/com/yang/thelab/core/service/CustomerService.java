package com.yang.thelab.core.service;

import java.util.List;

import com.yang.thelab.core.model.CustomerModel;

/**
 * 用户服务层
 * 
 * @author YJ.yang
 * @version $Id: CustomerService.java, v 0.1 2016年3月8日 下午7:08:33 dev Exp $
 */
public interface CustomerService {
    /**
     * 保存
     * @param model
     */
    void save(CustomerModel model);
    
    /**
     * 根据ID获取
     * 
     * @param bizNO
     * @return
     */
    CustomerModel get(String bizNO);
    /**
     * 根据编号列表获取用户
     * 
     * @param custNOList
     * @return
     */
    List<CustomerModel> getByKeyList(List<String> custNOList);
    
    
    CustomerModel checkLogin(String userName,String pwd);
}

