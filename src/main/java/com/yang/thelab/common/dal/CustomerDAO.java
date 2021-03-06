package com.yang.thelab.common.dal;

import java.util.List;

import com.yang.thelab.common.dataobj.CustomerDO;

/**
 *  用户数据交流层 
 * @author YJ.yang
 * @version $Id: CustomerDAO.java, v 0.1 2016年3月8日 下午7:23:48 dev Exp $
 */
public interface CustomerDAO {

    void insert(CustomerDO obj);

    int update(CustomerDO obj);
    
    CustomerDO getByKey(String key);
    
    List<CustomerDO> getByKeyList(List<String> bizNOList);
    
    CustomerDO getByCond(String extNO, String mobile ,String nikename);
    
}
