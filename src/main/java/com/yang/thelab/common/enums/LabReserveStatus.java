package com.yang.thelab.common.enums;

import java.util.ArrayList;
import java.util.List;

import com.yang.thelab.common.EnumInterface;

/**
 * 预订单状态
 * 
 * @author YJ.yang
 * @version $Id: LabReserveStatus.java, v 0.1 2016年3月14日 上午10:30:14 dev Exp $
 */
public enum LabReserveStatus implements EnumInterface {
    /**初始化*/
    INIT("INIT", "初始化"),
    /**等待审核*/
    WAIT_ADUIT("WAIT_ADUIT", "等待审核"),
    /**同意*/
    AGREE("AGREE", "同意"),
    /**拒绝*/
    REFUSE("REFUSE", "拒绝", true),
    /**结束*/
    FINISH("FINISH", "结束", true),;

    private String                   code;

    private String                   desc;

    private boolean                  finishStatus  = false;

    public final static List<String> ING_STATUS    = new ArrayList<String>();

    public final static List<String> FINISH_STATUS = new ArrayList<String>();

    static {
        for (LabReserveStatus status : LabReserveStatus.values()) {
            if (status.finishStatus) {
                FINISH_STATUS.add(status.code);
            } else {
                ING_STATUS.add(status.code);
            }
        }
    }

    private LabReserveStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private LabReserveStatus(String code, String desc, boolean finishStatus) {
        this.code = code;
        this.desc = desc;
        this.finishStatus = finishStatus;
    }

    public String code() {
        return code;
    }

    public String desc() {
        return desc;
    }

    public boolean finishStatus() {
        return finishStatus;
    }
}
