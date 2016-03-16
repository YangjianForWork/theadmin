package com.yang.thelab.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.common.utils.CommUtil;
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

    @RequestMapping(value = "/testPage")
    public String testPage(HttpServletResponse response) {
        return "temp";
    }

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
}
