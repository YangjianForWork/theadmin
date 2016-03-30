package com.yang.thelab.common.requ;

import com.yang.thelab.common.PageRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryQueryRequ.java, v 0.1 2016年3月30日 下午1:40:03 dev Exp $
 */
public class LaboratoryQueryRequ extends PageRequ {
    /**实验室状态*/
    private String status;
    /**实验室名称*/
    private String name;
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
