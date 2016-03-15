package com.yang.thelab.common.dal;

import java.util.List;

import com.yang.thelab.common.dataobj.EnumItemDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: EnumItemDAO.java, v 0.1 2016年3月11日 下午5:30:54 dev Exp $
 */
public interface EnumItemDAO {
    
    void insert(EnumItemDO obj);
    
    int update(EnumItemDO obj);
    
    EnumItemDO getByKey(String key);
    
    List<EnumItemDO> getListByType(String type);
}
