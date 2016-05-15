package com.yang.thelab.biz.dto;

import com.yang.thelab.common.BaseDTO;
import com.yang.thelab.common.vojo.Reserve;
import com.yang.thelab.core.model.LaboratoryModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveDTO.java, v 0.1 2016年5月3日 下午7:16:38 dev Exp $
 */
public class ReserveDTO extends BaseDTO<Reserve> {

    private String          startDateStr;

    private String          endDateStr;
    /**审核字段*/
    private String          adultStr;
    /**角色等级*/
    private int             roleLevel;
    /**申请者*/
    private PersonDTO       applyPer;
    /**处理者*/
    private PersonDTO       dealPer;
    /**实验室*/
    private LaboratoryModel lab;

    public ReserveDTO() {
        this.prop = new Reserve();
    }

    public ReserveDTO(Reserve prop) {
        this.prop = prop;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getAdultStr() {
        return adultStr;
    }

    public void setAdultStr(String adultStr) {
        this.adultStr = adultStr;
    }

    public int getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
    }

    public PersonDTO getApplyPer() {
        return applyPer;
    }

    public void setApplyPer(PersonDTO applyPer) {
        this.applyPer = applyPer;
    }

    public PersonDTO getDealPer() {
        return dealPer;
    }

    public void setDealPer(PersonDTO dealPer) {
        this.dealPer = dealPer;
    }

    public String getStatusDesc() {
        return this.prop.getStatus().desc();
    }

    public LaboratoryModel getLab() {
        return lab;
    }

    public void setLab(LaboratoryModel lab) {
        this.lab = lab;
    }

    
}
