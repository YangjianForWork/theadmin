package com.yang.thelab.common.enums;

import java.util.ArrayList;
import java.util.List;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author YJ.yang
 * @version $Id: LoginType.java, v 0.1 2016年3月17日 下午3:07:12 dev Exp $
 */
public enum LoginType implements EnumInterface {

    /**学生登录*/
    STU_LOGIN("STU_LOGIN","学生登录"),
    /**老师登录*/
    TEA_LOGIN("TEA_LOGIN","老师登录"),
    /**管理员登录*/
    MAG_LOGIN("MAG_LOGIN","管理员登录"),

    ;

    private String                      code;
    private String                      desc;
    /** 所有项*/
    public static final List<LoginType> ALL_LIST = new ArrayList<LoginType>();

    static {
        for (LoginType loginType : LoginType.values()) {
            ALL_LIST.add(loginType);
        }
    }
    
    private LoginType(String code, String desc) {
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
