package com.yang.thelab.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.core.service.EnumItemService;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolController.java, v 0.1 2016年3月16日 上午10:00:38 dev Exp $
 */
@Controller
public class SchoolController extends BaseController {
    
    @Autowired
    private EnumItemService enumItemService;
    
    @RequestMapping(value="/api/school" , params={"service=getSchoolType"})
    public void getSchoolTypeList(HttpServletResponse response) {
        toResponse(response,enumItemService.getListByType(EnumItemType.SCHOOL_TYPE));
    }
    
    @RequestMapping(value="/api/school" , params={"service=getSchoolGrade"})
    public void getSchoolGradeList(HttpServletResponse response) {
        toResponse(response,enumItemService.getListByType(EnumItemType.SCHOOL_GRADE));
    }
}
