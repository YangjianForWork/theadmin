package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.dal.ShMajorDAO;
import com.yang.thelab.common.dataobj.ShMajorDO;
import com.yang.thelab.common.enums.SeqServiceKey;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisShMajorDAO.java, v 0.1 2016年3月14日 下午6:26:11 dev Exp $
 */
public class IbatisShMajorDAO extends BaseDAO<ShMajorDO> implements ShMajorDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.SH_MAJOR;
    }

}
