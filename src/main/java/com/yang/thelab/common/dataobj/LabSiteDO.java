package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.enums.LabSiteStatus;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.LabSite;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabSiteDO.java, v 0.1 2016年5月17日 上午11:51:56 dev Exp $
 */
public class LabSiteDO extends BaseDO<LabSite> {
    
    public LabSiteDO() {
        this.prop = new LabSite();
    }

    public LabSiteDO(LabSite prop) {
        this.prop = prop;
    }

    @Override
    public LabSite getProp() {
        return this.prop;
    }

    @Override
    public void setProp(LabSite prop) {
        this.prop = prop;
    }

    public String getStatus(){
        return this.prop.getStatus().code();
    }
    
    public void setStatus(String status){
        this.prop.setStatus((LabSiteStatus) CommUtil.getEnumByCode(LabSiteStatus.class, status));
    }
    
}
