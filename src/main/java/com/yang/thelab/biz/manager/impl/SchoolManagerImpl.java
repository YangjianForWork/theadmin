package com.yang.thelab.biz.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.biz.dto.SchoolDTO;
import com.yang.thelab.biz.manager.SchoolManager;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.core.model.EnumItemModel;
import com.yang.thelab.core.model.SchoolModel;
import com.yang.thelab.core.service.EnumItemService;
import com.yang.thelab.core.service.SchoolService;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolManagerImpl.java, v 0.1 2016年3月16日 上午9:52:21 dev Exp $
 */
public class SchoolManagerImpl implements SchoolManager {

    @Autowired
    private SchoolService   schoolService;
    @Autowired
    private EnumItemService enumItemService;

    public String save(SchoolDTO DTO) {
        schoolService.save(new SchoolModel(DTO.get()));
        return DTO.get().getBizNO();
    }

    public List<EnumItemModel> getSchoolTypeList() {
        return enumItemService.getListByType(EnumItemType.SCHOOL_TYPE);
    }

    public List<EnumItemModel> getSchoolGradeList() {
        return enumItemService.getListByType(EnumItemType.SCHOOL_GRADE);
    }

}
