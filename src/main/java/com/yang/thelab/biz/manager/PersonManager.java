package com.yang.thelab.biz.manager;

import com.yang.thelab.biz.dto.PersonDTO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.requ.PersonQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: CustomerManager.java, v 0.1 2016年3月11日 下午12:03:03 dev Exp $
 */
public interface PersonManager {

    String save(PersonDTO perDTO);
    
    Paginator<PersonDTO> query(PersonQueryRequ requ);
    
    PersonDTO get(String bizNO);
}
