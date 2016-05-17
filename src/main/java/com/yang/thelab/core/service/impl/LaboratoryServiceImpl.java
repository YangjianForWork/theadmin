/**
 * Yixiu.com Inc.
 * Copyright (c) 2015-2016 All Rights Reserved.
 */
package com.yang.thelab.core.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.common.dal.LabSiteDAO;
import com.yang.thelab.common.dal.LaboratoryDAO;
import com.yang.thelab.common.dataobj.LabSiteDO;
import com.yang.thelab.common.dataobj.LaboratoryDO;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.LabSiteModel;
import com.yang.thelab.core.model.LaboratoryModel;
import com.yang.thelab.core.service.LaboratoryService;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryServiceImpl.java, v 0.1 2016年5月3日 下午3:06:25 dev Exp $
 */
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    private LaboratoryDAO laboratoryDAO;
    @Autowired
    private LabSiteDAO    labSiteDAO;

    public void save(LaboratoryModel model) {
        LaboratoryDO DO = new LaboratoryDO(model.get());
        if (CommUtil.isInsert(model)) {
            laboratoryDAO.insert(DO);
            model.setBizNO(DO.getBizNO());
        } else {
            laboratoryDAO.update(DO);
        }

    }

    public LaboratoryModel get(String bizNO) {
        return new LaboratoryModel(laboratoryDAO.getByKey(bizNO).get());
    }

    public void saveLabSiteList(List<LabSiteModel> siteList) {
        if (CollectionUtils.isEmpty(siteList)) {
            return;
        }
        for (LabSiteModel model : siteList) {
            LabSiteDO labSiteDO = new LabSiteDO(model.get());
            if (CommUtil.isInsert(model)) {
                labSiteDAO.insert(labSiteDO);
                model.setBizNO(labSiteDO.getBizNO());
            }else {
                labSiteDAO.update(labSiteDO);
            }
        }

    }

}
