package com.yang.thelab.common.vojo;

import java.util.Date;

import com.yang.thelab.common.BaseSO;
import com.yang.thelab.common.enums.RoleEnum;
import com.yang.thelab.common.enums.SexEnum;

/**
 * 人物
 * 
 * @author YJ.yang
 * @version $Id: Person.java, v 0.1 2016年3月11日 下午12:21:42 dev Exp $
 */
public class Person extends BaseSO {
    /**姓名*/
    private String   name;
    /**身份证号*/
    private String   idCardNO;
    /**角色*/
    private RoleEnum role;
    /**班级号*/
    private String   classNO;
    /**用户编号*/
    private String   custNO;
    /**性别*/
    private SexEnum  sex;
    /**生日*/
    private Date     birthDate;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdCardNO() {
        return idCardNO;
    }
    public void setIdCardNO(String idCardNO) {
        this.idCardNO = idCardNO;
    }
    public RoleEnum getRole() {
        return role;
    }
    public void setRole(RoleEnum role) {
        this.role = role;
    }
    public String getClassNO() {
        return classNO;
    }
    public void setClassNO(String classNO) {
        this.classNO = classNO;
    }
    public String getCustNO() {
        return custNO;
    }
    public void setCustNO(String custNO) {
        this.custNO = custNO;
    }
    public SexEnum getSex() {
        return sex;
    }
    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
