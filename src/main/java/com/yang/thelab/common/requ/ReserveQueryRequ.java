package com.yang.thelab.common.requ;

import com.yang.thelab.common.PageRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveQueryRequ.java, v 0.1 2016年3月30日 下午6:24:10 dev Exp $
 */
public class ReserveQueryRequ extends PageRequ {
    /**预订单状态*/
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}