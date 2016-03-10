package com.yang.thelab.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.common.BaseController;
import com.yang.thelab.core.service.CustomerService;
import com.yang.thelab.core.service.model.CustomerModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: CustomerController.java, v 0.1 2016年3月8日 下午7:21:07 dev Exp $
 */
@Controller
public class CustomerController extends BaseController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/api/customer", params = { "service=save" })
    public void saveCustomer(CustomerModel form, HttpServletResponse response) {
        customerService.save(form);
        toResponse(response , form.getBizNO());
    }
    @RequestMapping(value = "/api/customer", params = {"service=getByKey"})
    public void getCustomerByKey(String bizNO,HttpServletResponse response){
        toResponse(response , customerService.get(bizNO));
    }
}
