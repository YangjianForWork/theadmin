package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.ShGrade;

/**
 * 
 * @author YJ.yang
 * @version $Id: ShGradeModel.java, v 0.1 2016年3月14日 上午11:12:17 dev Exp $
 */
public class ShGradeModel extends BaseModel<ShGrade> {

    public ShGradeModel() {
        this.prop = new ShGrade();
    }

    public ShGradeModel(ShGrade prop) {
        this.prop = prop;
    }
    
}
