package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;
import com.yang.thelab.common.enums.LabStatus;

/**
 * 实验室
 * @author YJ.yang
 * @version $Id: Laboratory.java, v 0.1 2016年3月14日 上午10:22:38 dev Exp $
 */
public class Laboratory extends BaseSO {
    /**名称*/
    private String    name;
    /**状态*/
    private LabStatus status;
    /**类别*/
    private String    categoryNO;
    /**特性*/
    private String    attributeNO;
    /**负责人*/
    private String    masterNO;
    /**地址*/
    private String    address;
    /**容量*/
    private String    content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LabStatus getStatus() {
        return status;
    }

    public void setStatus(LabStatus status) {
        this.status = status;
    }

    public String getAttributeNO() {
        return attributeNO;
    }

    public void setAttributeNO(String attributeNO) {
        this.attributeNO = attributeNO;
    }

    public String getCategoryNO() {
        return categoryNO;
    }

    public void setCategoryNO(String categoryNO) {
        this.categoryNO = categoryNO;
    }

    public String getMasterNO() {
        return masterNO;
    }

    public void setMasterNO(String masterNO) {
        this.masterNO = masterNO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
}
