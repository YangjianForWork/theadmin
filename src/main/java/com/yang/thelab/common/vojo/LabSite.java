package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;
import com.yang.thelab.common.enums.LabSiteStatus;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabSite.java, v 0.1 2016年5月17日 上午11:46:21 dev Exp $
 */
public class LabSite extends BaseSO {

    /**座位号*/
    private String        siteNO;
    /**实验室编号*/
    private String        labNO;
    /**状态*/
    private LabSiteStatus status;
    /**当前实验者*/
    private String        currPers;
    public String getSiteNO() {
        return siteNO;
    }
    public void setSiteNO(String siteNO) {
        this.siteNO = siteNO;
    }
    public String getLabNO() {
        return labNO;
    }
    public void setLabNO(String labNO) {
        this.labNO = labNO;
    }
    public LabSiteStatus getStatus() {
        return status;
    }
    public void setStatus(LabSiteStatus status) {
        this.status = status;
    }
    public String getCurrPers() {
        return currPers;
    }
    public void setCurrPers(String currPers) {
        this.currPers = currPers;
    }
    
    
}
