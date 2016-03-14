package com.yang.thelab.core.service;

import com.yang.thelab.core.model.ClassesModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: ClassesService.java, v 0.1 2016年3月14日 下午6:30:16 dev Exp $
 */
public interface ClassesService {
    
    void save(ClassesModel model);
    
    ClassesModel get(String bizNO);
}
