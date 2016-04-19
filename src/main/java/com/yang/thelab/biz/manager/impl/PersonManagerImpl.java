package com.yang.thelab.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.yang.thelab.biz.dto.PersonDTO;
import com.yang.thelab.biz.manager.PersonManager;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.PersonDAO;
import com.yang.thelab.common.dataobj.PersonDO;
import com.yang.thelab.common.enums.RoleEnum;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.requ.PersonQueryRequ;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Customer;
import com.yang.thelab.common.vojo.Person;
import com.yang.thelab.core.model.CustomerModel;
import com.yang.thelab.core.model.PersonModel;
import com.yang.thelab.core.service.CustomerService;
import com.yang.thelab.core.service.PersonService;

/**
 * 
 * @author YJ.yang
 * @version $Id: CustomerManagerImpl.java, v 0.1 2016年3月11日 下午12:04:59 dev Exp $
 */
public class PersonManagerImpl implements PersonManager {

    @Autowired
    private PersonService       personService;
    @Autowired
    private CustomerService     customerService;
    @Autowired
    private PersonDAO           personDAO;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public String save(PersonDTO perDTO) {
        final PersonDTO personDTO  = perDTO;
        //将保存操作放入事务，保证操作的一致性
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                CustomerModel customerModel = new CustomerModel(personDTO.getCustomer());
                boolean insert = CommUtil.isInsert(customerModel);
                customerService.save(customerModel);
                if (insert) {
                    if (personDTO.get().getRole() == null) {
                        personDTO.get().setRole(RoleEnum.INIT_ROLE);
                    }
                }
                personDTO.get().setCustNO(customerModel.getBizNO());
                personService.save(new PersonModel(personDTO.get()));
            }
        });
        return personDTO.get().getBizNO();
    }

    public Paginator<PersonDTO> query(PersonQueryRequ requ) {
        Paginator<PersonDO> pagi = personDAO.compQuery(requ);
        Paginator<PersonDTO> result = new Paginator<PersonDTO>(pagi.getItemsPerPage(),
            pagi.getItems());
        result.setPage(pagi.getPage());
        List<PersonDTO> data = new ArrayList<PersonDTO>();
        for (PersonDO personDO : pagi.getPdate()) {
            data.add(getDTO(personDO.get()));
        }
        result.setPdate(data);
        return result;
    }

    public PersonDTO get(String bizNO) {
        PersonModel model = personService.get(bizNO);
        if (StringUtils.isBlank(model.getBizNO())) {
            throw new BizException(BizCode.PERSON_NOT_FOUND);
        }
        return getDTO(model.get());
    }

    private PersonDTO getDTO(Person person) {
        PersonDTO personDTO = new PersonDTO(CommUtil.hideBaseFeild(person));
        Customer customer = customerService.get(person.getCustNO()).get();
        customer.setPassword(null);
        personDTO.setCustomer(CommUtil.hideBaseFeild(customer));
        return personDTO;
    }

}
