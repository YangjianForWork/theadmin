package com.yang.thelab.common.dal;

import com.yang.thelab.common.dataobj.ClassesDO;

/**
 * 
 * @author YJ.yang
 * @version $Id: ClassesDAO.java, v 0.1 2016年3月14日 上午11:30:56 dev Exp $
 */
public interface ClassesDAO {

    void insert(ClassesDO obj);

    int update(ClassesDO obj);

    ClassesDO getByKey(String key);

}
