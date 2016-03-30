package com.yang.thelab.common.dal.ibatis;

import java.util.HashMap;
import java.util.List;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.ReserveDAO;
import com.yang.thelab.common.dataobj.ReserveDO;
import com.yang.thelab.common.enums.SeqServiceKey;
import com.yang.thelab.common.requ.ReserveQueryRequ;
import com.yang.thelab.common.utils.PaginatUtil;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisReserveDAO.java, v 0.1 2016年3月30日 下午6:33:45 dev Exp $
 */
public class IbatisReserveDAO extends BaseDAO<ReserveDO> implements ReserveDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.RESERVE;
    }

    public Paginator<ReserveDO> compQuery(ReserveQueryRequ requ) {
        return PaginatUtil.execute(getSqlMapClientTemplate(), getSeqServiceKey(), requ);
    }

    @SuppressWarnings("unchecked")
    public List<ReserveDO> getByCondtion(HashMap<String, Object> params) {
        return getSqlMapClientTemplate().queryForList("RESERVE.getByCondtion",params);
    }

    
}
