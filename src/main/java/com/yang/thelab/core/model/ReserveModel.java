package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.Reserve;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReseveModel.java, v 0.1 2016年3月14日 上午11:08:58 dev Exp $
 */
public class ReserveModel extends BaseModel<Reserve> {

    public ReserveModel() {
        this.prop = new Reserve();
    }

    public ReserveModel(Reserve prop) {
        this.prop = prop;
    }
}
