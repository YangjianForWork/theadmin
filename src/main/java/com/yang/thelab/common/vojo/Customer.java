package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;
/**
 * 用户
 * 
 * @author YJ.yang
 * @version $Id: Customer.java, v 0.1 2016年3月8日 下午6:43:02 dev Exp $
 */
public class Customer extends BaseSO {
    /**用户名*/
    private String username;
    /**学号（工号）*/
    private String extNO;
    /**密码*/
    private String password;
    /**手机号码*/
    private String mobile;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getExtNO() {
        return extNO;
    }
    public void setExtNO(String extNO) {
        this.extNO = extNO;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    
}
