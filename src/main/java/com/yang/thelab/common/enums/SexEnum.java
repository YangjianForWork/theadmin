package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author YJ.yang
 * @version $Id: SexEnum.java, v 0.1 2016年3月11日 下午12:24:17 dev Exp $
 */
public enum SexEnum implements EnumInterface {
    /**男*/
    MAN("1","男"),
    /**女*/
    WOMAN("0","女"),
    ;

    private String code;
    private String desc;
    
    private SexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

}
