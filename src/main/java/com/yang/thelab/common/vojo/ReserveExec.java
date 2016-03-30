package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;
import com.yang.thelab.common.enums.LabReserveExecStatus;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveExec.java, v 0.1 2016年3月30日 下午6:10:40 dev Exp $
 */
public class ReserveExec extends BaseSO {

    private String               reserveNO;

    private LabReserveExecStatus status;

    public String getReserveNO() {
        return reserveNO;
    }

    public void setReserveNO(String reserveNO) {
        this.reserveNO = reserveNO;
    }

    public LabReserveExecStatus getStatus() {
        return status;
    }

    public void setStatus(LabReserveExecStatus status) {
        this.status = status;
    }
    
}
