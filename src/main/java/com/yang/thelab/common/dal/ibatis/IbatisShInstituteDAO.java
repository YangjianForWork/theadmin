package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.dal.ShInstituteDAO;
import com.yang.thelab.common.dataobj.ShInstituteDO;
import com.yang.thelab.common.enums.SeqServiceKey;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisShInstituteDAO.java, v 0.1 2016年3月14日 下午6:24:43 dev Exp $
 */
public class IbatisShInstituteDAO extends BaseDAO<ShInstituteDO> implements ShInstituteDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.SH_INSTITUTE;
    }

}
