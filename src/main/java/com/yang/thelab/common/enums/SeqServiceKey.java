/**
 * Yixiu.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author nibo
 * @version $Id: SeqServiceKey.java, v 0.1 2015年11月12日 下午11:15:16 nibo Exp $
 */
public enum SeqServiceKey implements EnumInterface {
   

    /**用户*/
    CUSTOMER("CUSTOMER", "用户", "CR"),
    /**人*/
    PERSON("PERSON","人","PR"),
    /**枚举项*/
    ENUM_ITEM("ENUM_ITEM","枚举项","EI"),
    /**班级*/
    CLASSES("CLASSES","班级","CL"),
    /**学校*/
    SCHOOL("SCHOOL","","SH"),
    /**实验室*/
    LABORATORY("LABORATORY","","LB"),
    /**预约单*/
    RESERVE("RESERVE","","RS"),
    /**学院*/
    SH_INSTITUTE("SH_INSTITUTE","","SI"),
    /**专业*/
    SH_MAJOR("SH_MAJOR","","SJ"),
    ;
    private String code;
    private String desc;
    private String shortName;

    private SeqServiceKey(String code, String desc, String shortName) {
        this.code = code;
        this.desc = desc;
        this.shortName = shortName;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public String shortName() {
        return shortName;
    }

}
