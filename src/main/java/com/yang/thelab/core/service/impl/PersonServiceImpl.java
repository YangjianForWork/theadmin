package com.yang.thelab.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.yang.thelab.common.dal.PersonDAO;
import com.yang.thelab.common.dataobj.PersonDO;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.PersonModel;
import com.yang.thelab.core.service.PersonService;

/**
 * 
 * @author YJ.yang
 * @version $Id: PersonServiceImpl.java, v 0.1 2016年3月11日 下午1:33:24 dev Exp $
 */
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    public void save(PersonModel model) {
        PersonDO DO = new PersonDO(model.get());
        try {
            if (StringUtils.isBlank(DO.getBizNO())) {
                personDAO.insert(DO);
                model.setBizNO(DO.getBizNO());
            } else {
                personDAO.update(DO);
            }
        } catch (DuplicateKeyException e) {
            throw new BizException(CommUtil.getDuplicateKeyItem(e.getMessage()).bizCode());
        }
    }

    public PersonModel get(String bizNO) {
        return new PersonModel(personDAO.getByKey(bizNO).get());
    }

    public PersonModel getByIDCard(String idCardNO) {
        return new PersonModel(personDAO.getByCondition(null, idCardNO).get());
    }

    public PersonModel getByCustNO(String custNO) {
        return new PersonModel(personDAO.getByCondition(custNO, null).get());
    }

    public List<PersonModel> queryByCustNOList(List<String> custNOList) {
        List<PersonModel> listModel = new ArrayList<PersonModel>();
        List<PersonDO> listDO = personDAO.queryByCustNoList(custNOList);
        for (PersonDO personDO : listDO) {
            listModel.add(new PersonModel(personDO.get()));
        }
        return listModel;
    }

}
