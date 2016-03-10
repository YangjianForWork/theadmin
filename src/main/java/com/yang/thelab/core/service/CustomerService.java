package com.yang.thelab.core.service;

import com.yang.thelab.core.service.model.CustomerModel;

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
}
