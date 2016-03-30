package com.yang.thelab.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.yang.thelab.common.dal.SchoolDAO;
import com.yang.thelab.common.dal.ShInstituteDAO;
import com.yang.thelab.common.dal.ShMajorDAO;
import com.yang.thelab.common.dataobj.SchoolDO;
import com.yang.thelab.common.dataobj.ShInstituteDO;
import com.yang.thelab.common.dataobj.ShMajorDO;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.SchoolModel;
import com.yang.thelab.core.model.ShInstituteModel;
import com.yang.thelab.core.model.ShMajorModel;
import com.yang.thelab.core.service.SchoolService;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolServiceImpl.java, v 0.1 2016年3月14日 下午6:39:44 dev Exp $
 */
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDAO schoolDAO;
	@Autowired
	private ShInstituteDAO shInstituteDAO;
	@Autowired
	private ShMajorDAO shMajorDAO;

	public void save(SchoolModel model) {
		SchoolDO DO = new SchoolDO(model.get());
		try {
			if (CommUtil.isInsert(model)) {
				schoolDAO.insert(DO);
				model.setBizNO(DO.getBizNO());
			} else {
				schoolDAO.update(DO);
			}
		} catch (DuplicateKeyException e) {
			throw new BizException(CommUtil.getDuplicateKeyItem(e.getMessage())
					.bizCode());
		}
	}

	public SchoolModel get(String bizNO) {
		return new SchoolModel(schoolDAO.getByKey(bizNO).get());
	}

	public void saveInstitute(ShInstituteModel instituteModel) {
		ShInstituteDO instituteDO = new ShInstituteDO(instituteModel.get());
		if (CommUtil.isInsert(instituteModel)) {
			shInstituteDAO.insert(instituteDO);
			instituteModel.setBizNO(instituteDO.getBizNO());
		} else {
			shInstituteDAO.update(instituteDO);
		}
	}

	public ShInstituteModel getInstitute(String shInstituteNO) {
		return new ShInstituteModel(shInstituteDAO.getByKey(shInstituteNO)
				.get());
	}

	public void saveMajor(ShMajorModel majorModel) {
		ShMajorDO majorDO = new ShMajorDO(majorModel.get());
		if (CommUtil.isInsert(majorModel)) {
			shMajorDAO.insert(majorDO);
			majorModel.setBizNO(majorDO.getBizNO());
		} else {
			shMajorDAO.update(majorDO);
		}
	}

	public ShMajorModel getMajor(String shMajorNO) {
		return new ShMajorModel(shMajorDAO.getByKey(shMajorNO).get());
	}

	public List<ShInstituteModel> getBySchoolNO(String schoolNO) {
		return CommUtil.covDOList2ModelList(ShInstituteModel.class,
				shInstituteDAO.getBySchoolNO(schoolNO));
	}

}
