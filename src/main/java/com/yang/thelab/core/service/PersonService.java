package com.yang.thelab.core.service;

import java.util.List;

import com.yang.thelab.core.model.PersonModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: PersonService.java, v 0.1 2016年3月11日 下午1:29:11 dev Exp $
 */
public interface PersonService {
    
    void save(PersonModel model);
    
    PersonModel get(String bizNO);
    
    PersonModel getByIDCard(String idCardNO);
    
    PersonModel getByCustNO(String custNO);
    
    List<PersonModel> queryByCustNOList(List<String> custNOList);
}
