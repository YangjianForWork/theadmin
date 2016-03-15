package com.yang.thelab.common.dal;

import com.yang.thelab.common.dataobj.ShMajorDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: ShMajorDAO.java, v 0.1 2016年3月14日 上午11:38:59 dev Exp $
 */
public interface ShMajorDAO {
    
    void insert(ShMajorDO obj);
    
    int update(ShMajorDO obj);
    
    ShMajorDO getByKey(String key);
}
