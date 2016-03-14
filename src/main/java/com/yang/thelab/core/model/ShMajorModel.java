package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.ShMajor;

/**
 * 
 * @author YJ.yang
 * @version $Id: ShMajorModel.java, v 0.1 2016年3月14日 上午11:14:00 dev Exp $
 */
public class ShMajorModel extends BaseModel<ShMajor> {

    public ShMajorModel() {
        this.prop = new ShMajor();
    }

    public ShMajorModel(ShMajor prop) {
        this.prop = prop;
    }
    
}
