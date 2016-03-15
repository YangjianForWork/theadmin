package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.Laboratory;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryModel.java, v 0.1 2016年3月14日 上午11:07:41 dev Exp $
 */
public class LaboratoryModel extends BaseModel<Laboratory> {

    public LaboratoryModel() {
        this.prop = new Laboratory();
    }

    public LaboratoryModel(Laboratory prop) {
        this.prop = prop;
    }
}
