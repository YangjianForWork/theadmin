package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 预订单状态
 * 
 * @author YJ.yang
 * @version $Id: LabReseveStatus.java, v 0.1 2016年3月14日 上午10:30:14 dev Exp $
 */
public enum LabReseveStatus implements EnumInterface {
    /**初始化*/
    INIT("",""),
    /**等待审核*/
    WAIT_ADUIT("",""),
    /**同意*/
    AGREE("",""),
    /**拒绝*/
    REFUSE("",""),
    /**结束*/
    FINISH("",""),
    ;

    private String code;
    
    private String desc;
    
    private LabReseveStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

}
