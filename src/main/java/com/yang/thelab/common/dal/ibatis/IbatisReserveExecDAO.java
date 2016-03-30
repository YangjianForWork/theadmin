package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.dal.ReserveExecDAO;
import com.yang.thelab.common.dataobj.ReserveExecDO;
import com.yang.thelab.common.enums.SeqServiceKey;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbaitsReserveExecDAO.java, v 0.1 2016年3月30日 下午6:49:12 dev Exp $
 */
public class IbatisReserveExecDAO extends BaseDAO<ReserveExecDO> implements ReserveExecDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.RESERVE_EXEC;
    }

}
