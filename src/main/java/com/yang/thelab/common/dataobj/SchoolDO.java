package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.vojo.School;

public class SchoolDO extends BaseDO<School> {
    
    public SchoolDO() {
        this.prop = new School();
    }

    public SchoolDO(School prop) {
        this.prop = prop;
    }

    @Override
    public School getProp() {
        return this.prop;
    }

    @Override
    public void setProp(School prop) {
        this.prop = prop;
    }
}
