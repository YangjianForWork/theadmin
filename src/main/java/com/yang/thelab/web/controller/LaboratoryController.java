package com.yang.thelab.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.biz.manager.LaboratoryManager;
import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.common.requ.LaboratoryQueryRequ;
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
    private EnumItemService   enumItemService;
    @Autowired
    private LaboratoryManager laboratoryManager;

    @RequestMapping(value = "/api/lab", params = { "service=getLabCategory" })
    public void getLabCategoryList(HttpServletResponse response) {
        toResponse(response, enumItemService.getListByType(EnumItemType.LAB_CATEGORY));
    }

    @RequestMapping(value = "/api/lab", params = { "service=getLabAttribute" })
    public void getLabAttributeList(HttpServletResponse response) {
        toResponse(response, enumItemService.getListByType(EnumItemType.LAB_ATTRIBUTE));
    }

    @RequestMapping(value = "/api/lab", params = { "service=saveLabCategory" })
    public void saveCategory(String content, HttpServletResponse response) {
        toResponse(response, enumItemService.saveItem(content, EnumItemType.LAB_CATEGORY));
    }

    @RequestMapping(value = "/api/lab", params = { "service=saveLabAttribute" })
    public void saveAttribute(String content, HttpServletResponse response) {
        toResponse(response, enumItemService.saveItem(content, EnumItemType.LAB_ATTRIBUTE));
    }

    @RequestMapping(value = "/api/lab", params = { "service=queryLab" })
    public void queryLab(LaboratoryQueryRequ requ, HttpServletResponse response) {
        toResponse(response, laboratoryManager.query(requ));
    }

    @RequestMapping(value = "/api/lab", params = { "service=updateLabStatus" })
    public void updateLabStatus(String bizNO, String status, HttpServletResponse response) {
        laboratoryManager.updateStatus(status, bizNO);
        toResponse(response);
    }

    @RequestMapping(value = "/api/lab", params = { "service=getLab" })
    public void getLab(String bizNO, HttpServletResponse response) {
        toResponse(response, laboratoryManager.get(bizNO));
    }
}
