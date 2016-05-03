package com.yang.thelab.core.service;

import java.util.List;

import com.yang.thelab.core.model.ReserveExecModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveExecService.java, v 0.1 2016年5月3日 下午7:29:47 dev Exp $
 */
public interface ReserveExecService {
    
    void save(ReserveExecModel model);
    
    ReserveExecModel get(String bizNO);
    
    List<ReserveExecModel> getByCond(String reserveNO,String personNO);
}
