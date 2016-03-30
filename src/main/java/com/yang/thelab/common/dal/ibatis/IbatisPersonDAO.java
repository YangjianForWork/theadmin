package com.yang.thelab.common.dal.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.PersonDAO;
import com.yang.thelab.common.dataobj.PersonDO;
import com.yang.thelab.common.enums.SeqServiceKey;
import com.yang.thelab.common.requ.PersonQueryRequ;
import com.yang.thelab.common.utils.PaginatUtil;

public class IbatisPersonDAO extends BaseDAO<PersonDO> implements PersonDAO {

    public PersonDO getByCondition(String custNO, String idCardNO) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("idCardNO", idCardNO);
        param.put("custNO", custNO);
        return (PersonDO) getSqlMapClientTemplate().queryForObject("PERSON.getByCondition",param);
    }

    @Override
    protected SeqServiceKey getSeqServiceKey() {
        return SeqServiceKey.PERSON;
    }

    @SuppressWarnings("unchecked")
    public List<PersonDO> queryByCustNoList(List<String> custNOList) {
        if(CollectionUtils.isEmpty(custNOList)){
            return null;
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("custNOList", custNOList);
        return (List<PersonDO>) getSqlMapClientTemplate().queryForList( "PERSON.queryByCustNoList", param);
    }

    public Paginator<PersonDO> compQuery(PersonQueryRequ requ) {
        return PaginatUtil.execute(getSqlMapClientTemplate(), getSeqServiceKey(), requ);
    }

}
