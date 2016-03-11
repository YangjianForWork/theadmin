package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;
import com.yang.thelab.common.enums.EnumItemType;

/**
 * 枚举项
 * 
 * @author YJ.yang
 * @version $Id: EnumItem.java, v 0.1 2016年3月11日 下午5:23:28 dev Exp $
 */
public class EnumItem extends BaseSO {
    /**内容*/
    private String       content;
    /**类型*/
    private EnumItemType type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EnumItemType getType() {
        return type;
    }

    public void setType(EnumItemType type) {
        this.type = type;
    }
    
    
}
