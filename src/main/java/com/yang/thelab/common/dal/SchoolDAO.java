package com.yang.thelab.common.dal;

import com.yang.thelab.common.dataobj.SchoolDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolDAO.java, v 0.1 2016年3月14日 上午11:35:38 dev Exp $
 */
public interface SchoolDAO {

    void insert(SchoolDO obj);
    
    int update(SchoolDO obj);
    
    SchoolDO getByKey(String key);
}
