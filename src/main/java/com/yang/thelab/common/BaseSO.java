package com.yang.thelab.common;

import java.util.Date;

/**
 * 
 * @author YJ.yang
 * @version $Id: BaseSO.java, v 0.1 2016年3月8日 下午6:41:33 dev Exp $
 */
public abstract class BaseSO {
    /**业务号*/
    private String bizNO;
    /**创建时间*/
    private Date   gmtCreate;
    /**修改时间*/
    private Date   gmtModified;

    public String getBizNO() {
        return bizNO;
    }

    public void setBizNO(String bizNO) {
        this.bizNO = bizNO;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}
