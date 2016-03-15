package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.Classes;

/**
 * 
 * @author YJ.yang
 * @version $Id: ClassesModel.java, v 0.1 2016年3月14日 上午11:06:00 dev Exp $
 */
public class ClassesModel extends BaseModel<Classes> {

    public ClassesModel() {
        this.prop = new Classes();
    }

    public ClassesModel(Classes prop) {
        this.prop = prop;
    }

    
}
