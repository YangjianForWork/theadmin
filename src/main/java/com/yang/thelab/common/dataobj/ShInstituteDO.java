package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.vojo.ShInstitute;


/**
 * 
 * @author YJ.yang
 * @version $Id: ShInstituteDO.java, v 0.1 2016年3月14日 上午11:00:17 dev Exp $
 */
public class ShInstituteDO extends BaseDO<ShInstitute> {

    public ShInstituteDO() {
        this.prop = new ShInstitute();
    }

    public ShInstituteDO(ShInstitute prop) {
        this.prop = prop;
    }

    @Override
    public ShInstitute getProp() {
        return this.prop;
    }

    @Override
    public void setProp(ShInstitute prop) {
        this.prop = prop;
    }

}
