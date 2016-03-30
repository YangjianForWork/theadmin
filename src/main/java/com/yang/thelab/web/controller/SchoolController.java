package com.yang.thelab.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.biz.manager.SchoolManager;
import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.common.requ.SchoolQueryRequ;
import com.yang.thelab.core.service.EnumItemService;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolController.java, v 0.1 2016年3月16日 上午10:00:38 dev Exp $
 */
@Controller
public class SchoolController extends BaseController {

	@Autowired
	private SchoolManager schoolManager;
    @Autowired
    private EnumItemService enumItemService;

    @RequestMapping(value = "/api/school", params = { "service=getSchoolType" })
    public void getSchoolTypeList(HttpServletResponse response) {
        toResponse(response, enumItemService.getListByType(EnumItemType.SCHOOL_TYPE));
    }

    @RequestMapping(value = "/api/school", params = { "service=getSchoolGrade" })
    public void getSchoolGradeList(HttpServletResponse response) {
        toResponse(response, enumItemService.getListByType(EnumItemType.SCHOOL_GRADE));
    }

    @RequestMapping(value = "/api/school", params = { "service=saveSchoolType" })
    public void saveSchoolType(String content, HttpServletResponse response) {
        toResponse(response, enumItemService.saveItem(content, EnumItemType.SCHOOL_TYPE));
    }

    @RequestMapping(value = "/api/school", params = { "service=saveSchoolGrade" })
    public void saveSchoolGrade(String content, HttpServletResponse response) {
        toResponse(response, enumItemService.saveItem(content, EnumItemType.SCHOOL_GRADE));
    }
    
    @RequestMapping(value = "/api/school", params = { "service=query" })
    public void query(SchoolQueryRequ requ,HttpServletResponse response){
    	toResponse(response,schoolManager.query(requ));
    }
    
    @RequestMapping(value="/api/school" , params = {"service=getInsitituteList"})
    public void getInstituteBySchool(String schoolNO,HttpServletResponse response){
    	toResponse(response,schoolManager.getShInstituteList(schoolNO));
    }
}
