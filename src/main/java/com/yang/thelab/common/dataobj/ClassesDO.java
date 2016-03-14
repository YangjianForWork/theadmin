package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.vojo.Classes;

/**
 * 
 * @author YJ.yang
 * @version $Id: ClassesDO.java, v 0.1 2016年3月14日 上午10:46:46 dev Exp $
 */
public class ClassesDO extends BaseDO<Classes> {

    public ClassesDO() {
        this.prop = new Classes();
    }

    public ClassesDO(Classes prop) {
        this.prop = prop;
    }

    @Override
    public Classes getProp() {
        return this.prop;
    }

    @Override
    public void setProp(Classes prop) {
        this.prop = prop;
    }

}
