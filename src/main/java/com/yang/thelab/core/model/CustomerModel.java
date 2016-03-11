package com.yang.thelab.core.model;

import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.vojo.Customer;

public class CustomerModel extends BaseModel<Customer> {

    public CustomerModel() {
        this.prop = new Customer();
    }

    public CustomerModel(Customer prop) {
        this.prop =  prop;
    }
    
}
