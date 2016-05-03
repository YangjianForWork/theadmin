package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.ReserveExec;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveExecModel.java, v 0.1 2016年5月3日 下午7:30:40 dev Exp $
 */
public class ReserveExecModel extends BaseModel<ReserveExec> {

    public ReserveExecModel() {
        this.prop = new ReserveExec();
    }

    public ReserveExecModel(ReserveExec prop) {
        this.prop = prop;
    }
}
