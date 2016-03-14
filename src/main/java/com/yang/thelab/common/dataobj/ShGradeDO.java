package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.vojo.ShGrade;

/**
 * 
 * @author YJ.yang
 * @version $Id: ShGradeDO.java, v 0.1 2016年3月14日 上午10:56:40 dev Exp $
 */
public class ShGradeDO extends BaseDO<ShGrade> {
    
    public ShGradeDO() {
        this.prop = new ShGrade();
    }

    public ShGradeDO(ShGrade prop) {
        this.prop = prop;
    }

    @Override
    public ShGrade getProp() {
        return this.prop;
    }

    @Override
    public void setProp(ShGrade prop) {
        this.prop = prop;
    }

}
