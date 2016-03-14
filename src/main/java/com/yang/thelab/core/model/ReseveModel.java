package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.Reseve;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReseveModel.java, v 0.1 2016年3月14日 上午11:08:58 dev Exp $
 */
public class ReseveModel extends BaseModel<Reseve> {

    public ReseveModel() {
        this.prop = new Reseve();
    }

    public ReseveModel(Reseve prop) {
        this.prop = prop;
    }
}
