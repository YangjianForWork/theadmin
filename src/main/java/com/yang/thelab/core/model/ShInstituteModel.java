package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.ShInstitute;

/**
 * 
 * @author YJ.yang
 * @version $Id: ShInstituteModel.java, v 0.1 2016年3月14日 上午11:19:22 dev Exp $
 */
public class ShInstituteModel extends BaseModel<ShInstitute> {

    public ShInstituteModel() {
        this.prop = new ShInstitute();
    }

    public ShInstituteModel(ShInstitute prop) {
        this.prop = prop;
    }
}
