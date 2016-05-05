package com.yang.thelab.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Customer;
import com.yang.thelab.core.model.EnumItemModel;
import com.yang.thelab.core.model.SchoolModel;
import com.yang.thelab.core.service.EnumItemService;
import com.yang.thelab.core.service.SchoolService;

/**
 * 
 * @author YJ.yang
 * @version $Id: TestController.java, v 0.1 2016年3月15日 上午10:33:14 dev Exp $
 */
@Controller
public class TestController extends BaseController {

    @Autowired
    private EnumItemService enumItemService;
    @Autowired
    private SchoolService   schoolService;

    @RequestMapping(value = "/api/test", params = { "service=saveEnumItem" })
    public void saveEnumItem(EnumItemModel form, HttpServletResponse response) {
        enumItemService.save(form);
        toResponse(response, form.get());
    }

    @RequestMapping(value = "/api/test", params = { "service=getEnumByType" })
    public void getEnumByType(String type, HttpServletResponse response) {
        EnumItemType enumType = (EnumItemType) CommUtil.getEnumByCode(EnumItemType.class, type);
        toResponse(response, enumItemService.getListByType(enumType));
    }

    @RequestMapping(value = "/api/test", params = { "service=saveSchool" })
    public void saveSchool(SchoolModel form, HttpServletResponse response) {
        schoolService.save(form);
        toResponse(response, form.get());
    }
    
    @RequestMapping(value="/api/test",params={"service=testArray"})
    public void testArray(String NOListStr,HttpServletResponse response){
        List<String> NOList = JSON.parseArray(NOListStr,java.lang.String.class );
        if (CollectionUtils.isEmpty(NOList)) {
            toResponse(response,"空数组");
        }
        List<Customer> result = new ArrayList<Customer>();
        for (String string : NOList) {
            Customer customer = new Customer();
            customer.setNickname(string);
            customer.setExtNO(string);
            result.add(customer);
        }
        toResponse(response,result);
    }
}
