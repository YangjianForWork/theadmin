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
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryController.java, v 0.1 2016年3月16日 下午12:58:21 dev Exp $
 */
@Controller
public class LaboratoryController extends BaseController {
    
    @Autowired
    private EnumItemService enumItemService;

    @RequestMapping(value="/api/lab",params={"service=getLabCategory"})
    public void getLabCategoryList(HttpServletResponse response){
        toResponse(response, enumItemService.getListByType(EnumItemType.LAB_CATEGORY));
    }
    
    @RequestMapping(value="/api/lab",params={"service=getLabAttribute"})
    public void getLabAttributeList(HttpServletResponse response){
        toResponse(response, enumItemService.getListByType(EnumItemType.LAB_ATTRIBUTE));
    }
}
