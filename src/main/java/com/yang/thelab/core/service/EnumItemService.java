package com.yang.thelab.core.service;

import java.util.List;

import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.core.model.EnumItemModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: EnumItemService.java, v 0.1 2016年3月14日 上午9:25:25 dev Exp $
 */
public interface EnumItemService {
    
    void save(EnumItemModel model);
    
    List<EnumItemModel> getListByType(EnumItemType type);
    
    /**
     * 保存枚举项  结果放入List返回
     * 
     * @param content
     * @param type
     * @return
     */
    List<EnumItemModel> saveItem(String content,EnumItemType type);
}
