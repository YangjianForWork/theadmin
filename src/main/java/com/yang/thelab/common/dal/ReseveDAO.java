package com.yang.thelab.common.dal;

import com.yang.thelab.common.dataobj.ReseveDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReseveDAO.java, v 0.1 2016年3月14日 上午11:34:09 dev Exp $
 */
public interface ReseveDAO {

    void insert(ReseveDO obj);
    
    int update(ReseveDO obj);
    
    ReseveDO getByKey(String key);
}
