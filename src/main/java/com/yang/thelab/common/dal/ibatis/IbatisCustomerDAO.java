package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.dal.CustomerDAO;
import com.yang.thelab.common.dataobj.CustomerDO;
import com.yang.thelab.common.enums.SeqServiceKey;
/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisCustomerDAO.java, v 0.1 2016年3月9日 上午9:21:08 dev Exp $
 */
public class IbatisCustomerDAO extends BaseDAO<CustomerDO> implements CustomerDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.CUSTOMER;
    }
}
