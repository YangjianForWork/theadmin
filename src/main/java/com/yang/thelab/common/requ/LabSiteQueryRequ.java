package com.yang.thelab.common.requ;

import java.util.List;

import com.yang.thelab.common.PageRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabSiteQueryRequ.java, v 0.1 2016年5月17日 下午12:09:52 dev Exp $
 */
public class LabSiteQueryRequ extends PageRequ {

    private List<String> statusList;

    private String       labNO;

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getLabNO() {
        return labNO;
    }

    public void setLabNO(String labNO) {
        this.labNO = labNO;
    }
    
    

}
