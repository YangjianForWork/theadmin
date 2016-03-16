package com.yang.thelab.biz.dto;

import com.yang.thelab.common.BaseDTO;
import com.yang.thelab.common.vojo.School;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolDTO.java, v 0.1 2016年3月16日 上午9:49:33 dev Exp $
 */
public class SchoolDTO extends BaseDTO<School> {

    public SchoolDTO() {
        this.prop = new School();
    }

    public SchoolDTO(School prop) {
        this.prop = prop;
    }
    
    
}
