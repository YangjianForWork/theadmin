package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.EnumItem;

/**
 * 
 * 
 * @author YJ.yang
 * @version $Id: EnumItemModel.java, v 0.1 2016年3月14日 上午9:27:36 dev Exp $
 */
public class EnumItemModel extends BaseModel<EnumItem> {

    public EnumItemModel() {
        this.prop = new EnumItem();
    }

    public EnumItemModel(EnumItem prop) {
        this.prop = prop;
    }
    
}
