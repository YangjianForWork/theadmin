package com.yang.thelab.core.service;

import com.yang.thelab.core.model.ReserveModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReseveService.java, v 0.1 2016年3月14日 下午6:33:52 dev Exp $
 */
public interface ReserveService {

    void save(ReserveModel model);
    
    ReserveModel get(String bizNO);
}
