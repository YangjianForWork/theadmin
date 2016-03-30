package com.yang.thelab.common.enums;

import com.yang.thelab.common.EnumInterface;

/**
 * 
 * @author YJ.yang
 * @version $Id: LabReserveExecStatus.java, v 0.1 2016年3月30日 下午6:15:50 dev Exp $
 */
public enum LabReserveExecStatus implements EnumInterface {
    /**初始化*/
    INIT("INIT","初始化"),
    /**等待执行*/
    WAIT_EXEC("WAIT_EXEC","等待执行"),
    /**执行结束*/
    FINISH("FINISH","执行结束"),
    ;

    private String code;
    private String desc;
    
    private LabReserveExecStatus(String code, String desc) {
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
