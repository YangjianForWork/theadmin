package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.School;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolModel.java, v 0.1 2016年3月14日 上午11:10:53 dev Exp $
 */
public class SchoolModel extends BaseModel<School> {

    public SchoolModel() {
        this.prop = new School();
    }

    public SchoolModel(School prop) {
        this.prop = prop;
    }
    
}
