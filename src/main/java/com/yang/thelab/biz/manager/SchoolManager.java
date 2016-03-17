package com.yang.thelab.biz.manager;

import java.util.List;

import com.yang.thelab.biz.dto.SchoolDTO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.requ.SchoolQueryRequ;
import com.yang.thelab.core.model.EnumItemModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolManager.java, v 0.1 2016年3月16日 上午9:48:38 dev Exp $
 */
public interface SchoolManager {
    
    String save(SchoolDTO DTO);

    /**
     * 获取学校性质的枚举列表
     * 
     * @return
     */
    List<EnumItemModel> getSchoolTypeList();
    /**
     * 获取年级的枚举列表
     * 
     * @return
     */
    List<EnumItemModel> getSchoolGradeList();
    /**
     * 分页查询
     * @param requ
     * @return
     */
    Paginator<SchoolDTO> query(SchoolQueryRequ requ);
}
