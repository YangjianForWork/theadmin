package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.LabSite;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabSiteModel.java, v 0.1 2016年5月17日 上午11:52:56 dev Exp $
 */
public class LabSiteModel extends BaseModel<LabSite> {

    public LabSiteModel() {
        this.prop = new LabSite();
    }

    public LabSiteModel(LabSite prop) {
        this.prop = prop;
    }
}
