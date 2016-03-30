package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.vojo.ReserveExec;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveExecDO.java, v 0.1 2016年3月30日 下午6:12:50 dev Exp $
 */
public class ReserveExecDO extends BaseDO<ReserveExec> {

    public ReserveExecDO() {
        this.prop = new ReserveExec();
    }

    public ReserveExecDO(ReserveExec prop) {
        this.prop = prop;
    }

    @Override
    public ReserveExec getProp() {
        return this.prop;
    }

    @Override
    public void setProp(ReserveExec prop) {
        this.prop = prop;
    }

}
