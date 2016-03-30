package com.yang.thelab.common.dal.ibatis;

import java.util.HashMap;
import java.util.List;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.LaboratoryDAO;
import com.yang.thelab.common.dataobj.LaboratoryDO;
import com.yang.thelab.common.enums.SeqServiceKey;
import com.yang.thelab.common.requ.LaboratoryQueryRequ;
import com.yang.thelab.common.utils.PaginatUtil;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisLaboratoryDAO.java, v 0.1 2016年3月30日 下午1:41:39 dev Exp $
 */
public class IbatisLaboratoryDAO extends BaseDAO<LaboratoryDO> implements LaboratoryDAO {

    /** 
     * @see com.yang.thelab.common.dal.LaboratoryDAO#laboratory(com.yang.thelab.common.requ.LaboratoryQueryRequ)
     */
    public Paginator<LaboratoryDO> compQuery(LaboratoryQueryRequ requ) {
        return PaginatUtil.execute(getSqlMapClientTemplate(), getSeqServiceKey(), requ);
    }

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.LABORATORY;
    }

    @SuppressWarnings("unchecked")
    public List<LaboratoryDO> getByCondtion(HashMap<String, Object> params) {
        return getSqlMapClientTemplate().queryForList("LABORATORY.getByCondition",params);
    }

}
