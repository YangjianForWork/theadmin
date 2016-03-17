package com.yang.thelab.common.dal.ibatis;

import java.util.List;

import com.yang.thelab.common.BaseDAO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.SchoolDAO;
import com.yang.thelab.common.dataobj.SchoolDO;
import com.yang.thelab.common.enums.SeqServiceKey;
import com.yang.thelab.common.requ.SchoolQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: IbatisSchoolDAO.java, v 0.1 2016年3月14日 下午6:23:12 dev Exp $
 */
public class IbatisSchoolDAO extends BaseDAO<SchoolDO> implements SchoolDAO {

	@Override
	protected SeqServiceKey getSeqServiceKey() {
		return SeqServiceKey.SCHOOL;
	}

	@SuppressWarnings({ "unchecked" })
	public Paginator<SchoolDO> compQuery(SchoolQueryRequ req) {
		Long count = (Long) getSqlMapClientTemplate().queryForObject(
				"SCHOOL.compQueryCount", req);
		if (count.longValue() == 0) {
			return new Paginator<SchoolDO>(req.getItemsPerPage(), 0);
		}
		Paginator<SchoolDO> result = null;
		result = new Paginator<SchoolDO>(req.getItemsPerPage(),
				count.intValue());
		result.setPage(req.getPage());
		req.setItemsPerPage(result.getItemsPerPage());
		req.setBeginIndex(result.getBeginIndex() - 1);
		req.setEndIndex(result.getEndIndex());
		result.setPdate((List<SchoolDO>) getSqlMapClientTemplate()
				.queryForList("SCHOOL.compQuery", req));
		return result;
	}

}
