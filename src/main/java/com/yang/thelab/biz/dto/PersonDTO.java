package com.yang.thelab.biz.dto;

import com.yang.thelab.common.BaseDTO;
import com.yang.thelab.common.enums.RoleEnum;
import com.yang.thelab.common.enums.SexEnum;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Customer;
import com.yang.thelab.common.vojo.Person;

/**
 * 
 * @author YJ.yang
 * @version $Id: PersonDTO.java, v 0.1 2016年3月11日 下午3:04:12 dev Exp $
 */
public class PersonDTO extends BaseDTO<Person> {

    private Customer customer;

    public PersonDTO() {
        this.prop = new Person();
    }

    public PersonDTO(Person prop) {
        this.prop = prop;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRole() {
        return this.prop.getRole().desc();
    }

    public void setRole(String code) {
        this.prop.setRole((RoleEnum) CommUtil.getEnumByCode(RoleEnum.class, code));
    }

    public String getSex() {
        return this.prop.getSex().desc();
    }

    public void setSex(String code) {
        this.prop.setSex((SexEnum) CommUtil.getEnumByCode(SexEnum.class, code));
    }
}
