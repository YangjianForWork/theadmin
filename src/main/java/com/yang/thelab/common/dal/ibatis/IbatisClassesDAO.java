package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.dal.ClassesDAO;
import com.yang.thelab.common.dataobj.ClassesDO;
import com.yang.thelab.common.enums.SeqServiceKey;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisClassesDAO.java, v 0.1 2016年3月14日 下午6:20:54 dev Exp $
 */
public class IbatisClassesDAO extends BaseDAO<ClassesDO> implements ClassesDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.CLASSES;
    }

}
