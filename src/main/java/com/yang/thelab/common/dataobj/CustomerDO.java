package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.vojo.Customer;
/**
 * 
 * 
 * @author YJ.yang
 * @version $Id: CustomerDO.java, v 0.1 2016年3月8日 下午6:59:19 dev Exp $
 */
public class CustomerDO extends BaseDO<Customer> {

    public CustomerDO() {
        this.prop = new Customer();
    }

    public CustomerDO(Customer prop) {
        this.prop = prop;
    }

    @Override
    public Customer getProp() {
        return this.prop;
    }

    @Override
    public void setProp(Customer prop) {
        this.prop = prop;
    }

}
