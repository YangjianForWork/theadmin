package com.yang.thelab.biz.manager;

import com.yang.thelab.biz.dto.LabSiteDTO;
import com.yang.thelab.biz.dto.LaboratoryDTO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.requ.LabSiteQueryRequ;
import com.yang.thelab.common.requ.LaboratoryQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryManager.java, v 0.1 2016年3月16日 下午1:00:51 dev Exp $
 */
public interface LaboratoryManager {
    /**
     * 查询
     * 
     * @param requ
     * @return
     */
    Paginator<LaboratoryDTO> query(LaboratoryQueryRequ requ);
    
    void save(LaboratoryDTO DTO);
    
    void updateStatus(String status,String bizNO);
    
    LaboratoryDTO get(String bizNO);
    
    Paginator<LabSiteDTO> query(LabSiteQueryRequ requ);
}
