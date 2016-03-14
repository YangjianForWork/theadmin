package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.vojo.ShMajor;

/**
 * 
 * @author YJ.yang
 * @version $Id: ShMajorDO.java, v 0.1 2016年3月14日 上午10:58:40 dev Exp $
 */
public class ShMajorDO extends BaseDO<ShMajor> {

    public ShMajorDO() {
        this.prop = new ShMajor();
    }

    public ShMajorDO(ShMajor prop) {
        this.prop = prop;
    }

    @Override
    public ShMajor getProp() {
        return this.prop;
    }

    @Override
    public void setProp(ShMajor prop) {
        this.prop = prop;
    }

}
