package com.yang.thelab.common.requ;

import com.yang.thelab.common.PageRequ;
import com.yang.thelab.common.vojo.School;

/**
 * 
 * @author YJ.yang
 * @vesion $Id:SchoolQueryRequ.java, v 0.1 2016年3月17日 下午9:25:04 wztw Exp $
 */
public class SchoolQueryRequ extends PageRequ {
	
	private School prop;

	public SchoolQueryRequ() {
		this.prop = new School();
	}

	public SchoolQueryRequ(School prop) {
		this.prop = prop;
	}

	public School getProp() {
		return prop;
	}

	public void setProp(School prop) {
		this.prop = prop;
	}
	
}
