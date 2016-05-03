package com.yang.thelab.common.dal;

import java.util.HashMap;
import java.util.List;

import com.yang.thelab.common.dataobj.ReserveExecDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveExecDAO.java, v 0.1 2016年3月30日 下午6:47:39 dev Exp $
 */
public interface ReserveExecDAO {
    
    void insert(ReserveExecDO obj);
    
    int update(ReserveExecDO obj);
    
    ReserveExecDO getByKey(String key);
    
    List<ReserveExecDO> getByCond(HashMap<String, Object> params);
}
