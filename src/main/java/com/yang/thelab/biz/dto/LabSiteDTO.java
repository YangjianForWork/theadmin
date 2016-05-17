package com.yang.thelab.biz.dto;

import com.yang.thelab.common.BaseDTO;
import com.yang.thelab.common.vojo.LabSite;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabSiteDTO.java, v 0.1 2016年5月17日 下午1:13:58 dev Exp $
 */
public class LabSiteDTO extends BaseDTO<LabSite> {

    public LabSiteDTO() {
        this.prop = new LabSite();
    }

    public LabSiteDTO(LabSite prop) {
        this.prop = prop;
    }
    
}
