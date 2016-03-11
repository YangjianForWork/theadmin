package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.EnumItem;

/**
 * 
 * @author YJ.yang
 * @version $Id: EnumItemDO.java, v 0.1 2016年3月11日 下午5:25:36 dev Exp $
 */
public class EnumItemDO extends BaseDO<EnumItem> {

    public EnumItemDO() {
        this.prop = new EnumItem();
    }

    public EnumItemDO(EnumItem prop) {
        this.prop = prop;
    }

    @Override
    public EnumItem getProp() {
        return this.prop;
    }

    @Override
    public void setProp(EnumItem prop) {
        this.prop = prop;
    }

    public String getType() {
        return this.prop.getType().code();
    }

    public void setType(String type) {
        this.prop.setType((EnumItemType) CommUtil.getEnumByCode(EnumItemType.class, type));
    }
}
