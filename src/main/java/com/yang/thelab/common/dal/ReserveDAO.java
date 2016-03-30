package com.yang.thelab.common.dal;

import java.util.HashMap;
import java.util.List;

import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dataobj.ReserveDO;
import com.yang.thelab.common.requ.ReserveQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReseveDAO.java, v 0.1 2016年3月14日 上午11:34:09 dev Exp $
 */
public interface ReserveDAO {

    void insert(ReserveDO obj);
    
    int update(ReserveDO obj);
    
    ReserveDO getByKey(String key);
    
    Paginator<ReserveDO> compQuery(ReserveQueryRequ requ);
    
    List<ReserveDO> getByCondtion(HashMap<String, Object> params);
}
