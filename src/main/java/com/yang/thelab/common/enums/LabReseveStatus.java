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
    INIT("INIT","初始化"),
    /**等待审核*/
    WAIT_ADUIT("WAIT_ADUIT","等待审核"),
    /**同意*/
    AGREE("AGREE","同意"),
    /**拒绝*/
    REFUSE("REFUSE","拒绝"),
    /**结束*/
    FINISH("FINISH","结束"),
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
