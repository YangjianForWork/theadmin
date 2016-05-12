package com.yang.thelab.common.requ;

import com.yang.thelab.common.PageRequ;
import com.yang.thelab.common.enums.RoleEnum;
import com.yang.thelab.common.enums.SexEnum;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Customer;
import com.yang.thelab.common.vojo.Person;

/**
 * 
 * @author YJ.yang
 * @version $Id: PersonQueryRequ.java, v 0.1 2016年3月11日 下午2:52:58 dev Exp $
 */
public class PersonQueryRequ extends PageRequ {

    private Person   prop;

    private Customer customer;

    public PersonQueryRequ() {
        this.prop = new Person();
    }

    public PersonQueryRequ(Person prop) {
        this.prop = prop;
    }

    public Person getProp() {
        return prop;
    }

    public void setProp(Person prop) {
        this.prop = prop;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRole() {
        return this.prop.getRole().code();
    }

    public void setRole(String code) {
        this.prop.setRole((RoleEnum) CommUtil.getEnumByCode(RoleEnum.class, code));
    }

    public String getSex() {
        return this.prop.getSex().code();
    }

    public void setSex(String code) {
        this.prop.setSex((SexEnum) CommUtil.getEnumByCode(SexEnum.class, code));
    }

}
