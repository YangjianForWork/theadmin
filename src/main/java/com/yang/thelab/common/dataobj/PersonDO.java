package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.enums.RoleEnum;
import com.yang.thelab.common.enums.SexEnum;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Person;

/**
 * 人 
 * @author YJ.yang
 * @version $Id: PersonDO.java, v 0.1 2016年3月11日 下午12:29:32 dev Exp $
 */
public class PersonDO extends BaseDO<Person> {

    public PersonDO() {
        this.prop =  new Person();
    }

    public PersonDO(Person prop) {
        this.prop = prop;
    }

    @Override
    public Person getProp() {
        return this.prop;
    }

    @Override
    public void setProp(Person prop) {
        this.prop = prop;
    }

    public String getRole(){
        return this.get().getRole().code();
    }
    
    public void setRole(String role){
        this.get().setRole((RoleEnum) CommUtil.getEnumByCode(RoleEnum.class, role));
    }

    public String getSex() {
        return this.prop.getSex().code();
    }

    public void setSex(String sex) {
        this.prop.setSex((SexEnum) CommUtil.getEnumByCode(SexEnum.class, sex));
    }
    
  
    
}
