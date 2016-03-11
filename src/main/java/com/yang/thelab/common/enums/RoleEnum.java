package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author YJ.yang
 * @version $Id: RoleEnum.java, v 0.1 2016年3月11日 下午12:14:26 dev Exp $
 */
public enum RoleEnum implements EnumInterface {

    /**初始化角色*/
    INIT_ROLE("INIT_ROLE","初始化角色"),
    /**老师*/
    TEACHER("TEACHER","老师"),
    /**学生*/
    STUDENT("STUDENT","学生"),
    /**管理员*/
    MANAGER("MANAGER","管理员"),
    
    ;

    private String code;
    private String desc;
    private int    seqCode;

    private RoleEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private RoleEnum(String code, String desc, int seqCode) {
        this(code, desc);
        this.seqCode = seqCode;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public int seqCode(){
        return seqCode;
    }

}
