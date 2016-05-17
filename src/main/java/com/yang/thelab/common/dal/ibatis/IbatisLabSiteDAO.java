package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.LabSiteDAO;
import com.yang.thelab.common.dataobj.LabSiteDO;
import com.yang.thelab.common.enums.SeqServiceKey;
import com.yang.thelab.common.requ.LabSiteQueryRequ;
import com.yang.thelab.common.utils.PaginatUtil;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisLabSiteDAO.java, v 0.1 2016年5月17日 上午11:56:31 dev Exp $
 */
public class IbatisLabSiteDAO extends BaseDAO<LabSiteDO> implements LabSiteDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.LAB_SITE;
    }

    public Paginator<LabSiteDO> compQuery(LabSiteQueryRequ requ) {
        return PaginatUtil.execute(getSqlMapClientTemplate(), getSeqServiceKey(), requ);
    }

}
