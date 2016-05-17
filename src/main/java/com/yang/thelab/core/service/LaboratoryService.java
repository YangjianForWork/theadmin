package com.yang.thelab.core.service;

import java.util.List;

import com.yang.thelab.core.model.LabSiteModel;
import com.yang.thelab.core.model.LaboratoryModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryService.java, v 0.1 2016年3月14日 下午6:31:36 dev Exp $
 */
public interface LaboratoryService {
    
    void save(LaboratoryModel model);
    
    LaboratoryModel get(String bizNO);
    
    void saveLabSiteList(List<LabSiteModel> siteList);
    
}
