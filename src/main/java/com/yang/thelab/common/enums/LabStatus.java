package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 实验室状态
 * 
 * @author YJ.yang
 * @version $Id: LabStatusEnum.java, v 0.1 2016年3月14日 上午10:23:46 dev Exp $
 */
public enum LabStatus implements EnumInterface {
    /**正常*/
    NORMAL("NORMAL","正常"),
    /**预约中*/
    RESERVE("RESERVE","预约中"),
    /**使用中*/
    IN_USE("IN_USE","使用中"),
    ;

    private String code;
    
    private String desc;
    
    private LabStatus(String code, String desc) {
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
