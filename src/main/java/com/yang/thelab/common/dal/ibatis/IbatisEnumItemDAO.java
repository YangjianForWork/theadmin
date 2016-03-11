package com.yang.thelab.common.dal.ibatis;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.dal.EnumItemDAO;
import com.yang.thelab.common.dataobj.EnumItemDO;
import com.yang.thelab.common.enums.SeqServiceKey;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisEnumItemDAO.java, v 0.1 2016年3月11日 下午5:31:58 dev Exp $
 */
public class IbatisEnumItemDAO extends BaseDAO<EnumItemDO> implements EnumItemDAO {

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.ENUM_ITEM;
    }

}
