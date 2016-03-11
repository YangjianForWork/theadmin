package com.yang.thelab.common.dal;

import java.util.List;

import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dataobj.PersonDO;
import com.yang.thelab.common.requ.PersonQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: PersonDAO.java, v 0.1 2016年3月11日 下午1:19:28 dev Exp $
 */
public interface PersonDAO {
    
    void insert(PersonDO obj);
    
    int update(PersonDO obj);
    
    PersonDO getByKey(String key);
    /**
     * 条件查询
     * 
     * @param custNO
     * @param idCardNO
     * @return
     */
    PersonDO getByCondition(String custNO,String idCardNO);
    /**
     * 根据用户编号查询
     * 
     * @param custNOList
     * @return
     */
    List<PersonDO> queryByCustNoList(List<String> custNOList);
    /**
     * 分页查询
     * 
     * @param req
     * @return
     */
    Paginator<PersonDO> compQuery(PersonQueryRequ req);
}
