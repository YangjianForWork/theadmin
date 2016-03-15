package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 枚举项的类型
 * 
 * @author YJ.yang
 * @version $Id: EnumItemType.java, v 0.1 2016年3月8日 下午7:27:24 dev Exp $
 */
public enum EnumItemType implements EnumInterface {
    
    /**学校性质*/
    SCHOOL_TYPE("SCHOOL_TYPE","学校性质"),
    /**实验室类别*/
    LAB_CATEGORY("LAB_CATEGORY","实验室类别"),
    /**年级枚举*/
    SCHOOL_GRADE("SCHOOL_GRADE","年级枚举"),
    /**实验室特性*/
    LAB_ATTRIBUTE("LAB_ATTRIBUTE","实验室特性"),
    ;

    private String code;

    private String desc;
    
    private EnumItemType(String code, String desc) {
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
