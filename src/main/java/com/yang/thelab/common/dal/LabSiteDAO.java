package com.yang.thelab.common.dal;

import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dataobj.LabSiteDO;
import com.yang.thelab.common.requ.LabSiteQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabSiteDAO.java, v 0.1 2016年5月17日 上午11:54:42 dev Exp $
 */
public interface LabSiteDAO {

    void insert(LabSiteDO obj);

    int update(LabSiteDO obj);

    LabSiteDO getByKey(String key);
    
    Paginator<LabSiteDO> compQuery(LabSiteQueryRequ requ);
}
