package com.yang.thelab.common.dal;

import java.util.HashMap;
import java.util.List;

import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dataobj.LaboratoryDO;
import com.yang.thelab.common.requ.LaboratoryQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryDAO.java, v 0.1 2016年3月14日 上午11:32:48 dev Exp $
 */
public interface LaboratoryDAO {
    
    void insert(LaboratoryDO obj);
    
    int update(LaboratoryDO obj);
    
    LaboratoryDO getByKey(String key);
    
    Paginator<LaboratoryDO> compQuery(LaboratoryQueryRequ requ);
    
    List<LaboratoryDO> getByCondtion(HashMap<String, Object> params);
}
