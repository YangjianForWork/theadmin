package com.yang.thelab.common.dal;

import java.util.List;

import com.yang.thelab.common.dataobj.ShInstituteDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: ShInstituteDAO.java, v 0.1 2016年3月14日 上午11:40:14 dev Exp $
 */
public interface ShInstituteDAO {
    
    void insert(ShInstituteDO obj);
    
    int update(ShInstituteDO obj);
    
    ShInstituteDO getByKey(String key);
    
    List<ShInstituteDO> getBySchoolNO(String schoolNO);
}
