package com.yang.thelab.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.biz.dto.PersonDTO;
import com.yang.thelab.biz.manager.PersonManager;
import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.requ.PersonQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: CustomerController.java, v 0.1 2016年3月8日 下午7:21:07 dev Exp $
 */
@Controller
public class PersonController extends BaseController {

    @Autowired
    private PersonManager personManager;

    @RequestMapping(value = "/api/person", params = { "service=save" })
    public void savePerson(PersonDTO form, HttpServletResponse response) {
        toResponse(response , personManager.save(form));
    }
    @RequestMapping(value = "/api/person", params = {"service=getByKey"})
    public void getPersonByKey(String bizNO,HttpServletResponse response){
        toResponse(response , personManager.get(bizNO));
    }
    
    @RequestMapping(value="/api/person",params = {"service=query"})
    public void queryPerson(PersonQueryRequ requ,HttpServletResponse response){
        toResponse(response,personManager.query(requ));
    }
}
