package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.Person;

/**
 * 
 * @author YJ.yang
 * @version $Id: PersonModel.java, v 0.1 2016年3月11日 下午1:29:49 dev Exp $
 */
public class PersonModel extends BaseModel<Person> {

    public PersonModel() {
        this.prop = new Person();
    }

    public PersonModel(Person prop) {
        this.prop = prop;
    }

    
}
