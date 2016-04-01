package com.yang.thelab.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.biz.dto.SchoolDTO;
import com.yang.thelab.biz.manager.SchoolManager;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.SchoolDAO;
import com.yang.thelab.common.dataobj.SchoolDO;
import com.yang.thelab.common.enums.EnumItemType;
import com.yang.thelab.common.requ.SchoolQueryRequ;
import com.yang.thelab.core.model.EnumItemModel;
import com.yang.thelab.core.model.SchoolModel;
import com.yang.thelab.core.model.ShInstituteModel;
import com.yang.thelab.core.service.EnumItemService;
import com.yang.thelab.core.service.SchoolService;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolManagerImpl.java, v 0.1 2016年3月16日 上午9:52:21 dev Exp $
 */
public class SchoolManagerImpl implements SchoolManager {

	@Autowired
	private SchoolService schoolService;
	@Autowired
	private EnumItemService enumItemService;
	@Autowired
	private SchoolDAO schoolDAO;
	

	public String save(SchoolDTO DTO) {
		schoolService.save(new SchoolModel(DTO.get()));
		return DTO.get().getBizNO();
	}

	public List<EnumItemModel> getSchoolTypeList() {
		return enumItemService.getListByType(EnumItemType.SCHOOL_TYPE);
	}

	public List<EnumItemModel> getSchoolGradeList() {
		return enumItemService.getListByType(EnumItemType.SCHOOL_GRADE);
	}

	public Paginator<SchoolDTO> query(SchoolQueryRequ requ) {
		Paginator<SchoolDO> pagi = schoolDAO.compQuery(requ);
		Paginator<SchoolDTO> result = new Paginator<SchoolDTO>(
				pagi.getItemsPerPage(), pagi.getItems());
		result.setPage(pagi.getPage());
		List<SchoolDTO> data = new ArrayList<SchoolDTO>();
		for (SchoolDO schoolDO : pagi.getPdate()) {
			data.add(new SchoolDTO(schoolDO.get()));
		}
		result.setPdate(data);
		return result;
	}

	public List<ShInstituteModel> getShInstituteList(String schoolNO) {
		return schoolService.getBySchoolNO(schoolNO);
	}

    public SchoolDTO get(String bizNO) {
        return new SchoolDTO(schoolService.get(bizNO).get());
    }

}
