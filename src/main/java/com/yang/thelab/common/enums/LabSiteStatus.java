package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabSiteStatus.java, v 0.1 2016年5月17日 上午11:49:09 dev Exp $
 */
public enum LabSiteStatus implements EnumInterface {
    ;

    private String code;
    private String desc;
    
    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

}
