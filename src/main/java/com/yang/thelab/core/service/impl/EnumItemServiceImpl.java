package com.yang.thelab.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.yang.thelab.common.dal.EnumItemDAO;
import com.yang.thelab.common.dataobj.EnumItemDO;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.EnumItemModel;
import com.yang.thelab.core.service.EnumItemService;

/**
 * 
 * @author YJ.yang
 * @version $Id: EnumItemServiceImpl.java, v 0.1 2016年3月14日 上午9:31:45 dev Exp $
 */
public class EnumItemServiceImpl implements EnumItemService {

    @Autowired
    private EnumItemDAO enumItemDAO;

    public void save(EnumItemModel model) {
        EnumItemDO DO = new EnumItemDO(model.get());
        try {
            if (CommUtil.isInsert(model)) {
                enumItemDAO.insert(DO);
                model.setBizNO(DO.getBizNO());
            } else {
                enumItemDAO.update(DO);
            }
        } catch (DuplicateKeyException e) {
            throw new BizException(CommUtil.getDuplicateKeyItem(e.getMessage()).bizCode());
        }
    }

    public List<EnumItemModel> getListByType(String type) {
        List<EnumItemModel> models = new ArrayList<EnumItemModel>();
        List<EnumItemDO> enumItemDOs = enumItemDAO.getListByType(type);
        for (EnumItemDO enumItemDO : enumItemDOs) {
            EnumItemModel model = new EnumItemModel(enumItemDO.get());
            models.add(model);
        }
        return models;
    }

}
