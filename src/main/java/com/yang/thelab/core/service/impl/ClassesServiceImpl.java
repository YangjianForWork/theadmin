package com.yang.thelab.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.common.dal.ClassesDAO;
import com.yang.thelab.common.dataobj.ClassesDO;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.ClassesModel;
import com.yang.thelab.core.service.ClassesService;

/**
 * 
 * @author YJ.yang
 * @version $Id: ClassesServiceImpl.java, v 0.1 2016年3月14日 下午6:36:59 dev Exp $
 */
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesDAO classesDAO;
    
    public void save(ClassesModel model) {
        ClassesDO DO = new ClassesDO(model.get());
        if (CommUtil.isInsert(model)) {
            classesDAO.insert(DO);
            model.setBizNO(DO.getBizNO());
        }else {
            classesDAO.update(DO);
        }
    }

    public ClassesModel get(String bizNO) {
        return new ClassesModel(classesDAO.getByKey(bizNO).get());
    }

}
