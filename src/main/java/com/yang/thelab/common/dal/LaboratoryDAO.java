package com.yang.thelab.common.dal;

import com.yang.thelab.common.dataobj.LaboratoryDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryDAO.java, v 0.1 2016年3月14日 上午11:32:48 dev Exp $
 */
public interface LaboratoryDAO {
    
    void insert(LaboratoryDO obj);
    
    int update(LaboratoryDO obj);
    
    LaboratoryDO getByKey(String key);
}
