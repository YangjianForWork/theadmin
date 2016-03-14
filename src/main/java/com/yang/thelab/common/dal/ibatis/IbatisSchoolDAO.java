package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.dal.SchoolDAO;
import com.yang.thelab.common.dataobj.SchoolDO;
import com.yang.thelab.common.enums.SeqServiceKey;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisSchoolDAO.java, v 0.1 2016年3月14日 下午6:23:12 dev Exp $
 */
public class IbatisSchoolDAO extends BaseDAO<SchoolDO> implements SchoolDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.SCHOOL;
    }

}
