package com.yang.thelab.common.requ;

import java.util.List;

import com.yang.thelab.common.PageRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveQueryRequ.java, v 0.1 2016年3月30日 下午6:24:10 dev Exp $
 */
public class ReserveQueryRequ extends PageRequ {
    /**预订单状态*/
    private String       status;
    /**申请者*/
    private String       applyPersNO;
    /**处理者*/
    private String       dealPersNO;
    /**请求角色等级*/
    private int          roleLevel;
    /**实验室编号*/
    private String       labNO;
    /**预约单状态列表*/
    private List<String> statusList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyPersNO() {
        return applyPersNO;
    }

    public void setApplyPersNO(String applyPersNO) {
        this.applyPersNO = applyPersNO;
    }

    public String getDealPersNO() {
        return dealPersNO;
    }

    public void setDealPersNO(String dealPersNO) {
        this.dealPersNO = dealPersNO;
    }

    public int getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getLabNO() {
        return labNO;
    }

    public void setLabNO(String labNO) {
        this.labNO = labNO;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

}
