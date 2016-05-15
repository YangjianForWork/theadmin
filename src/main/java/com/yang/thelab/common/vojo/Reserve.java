package com.yang.thelab.common.vojo;

import java.util.Date;

import com.yang.thelab.common.BaseSO;
import com.yang.thelab.common.enums.LabReserveStatus;

/**
 * 预订单
 * 
 * @author YJ.yang
 * @version $Id: Reseve.java, v 0.1 2016年3月14日 上午10:39:09 dev Exp $
 */
public class Reserve extends BaseSO {
    /** 实验室编号*/
    private String           labNO;
    /** 预订时间*/
    private Date             bookDate;
    /** 开始时间*/
    private Date             beginDate;
    /** 结束时间*/
    private Date             finishDate;
    /** 预订单状态*/
    private LabReserveStatus status;
    /** 申请人*/
    private String           applyPersNO;
    /** 处理时间*/
    private Date             dealDate;
    /** 处理人*/
    private String           dealPersNO;
    /** 处理原因*/
    private String           dealReson;

    public String getLabNO() {
        return labNO;
    }

    public void setLabNO(String labNO) {
        this.labNO = labNO;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public LabReserveStatus getStatus() {
        return status;
    }

    public void setStatus(LabReserveStatus status) {
        this.status = status;
    }

    public String getApplyPersNO() {
        return applyPersNO;
    }

    public void setApplyPersNO(String applyPersNO) {
        this.applyPersNO = applyPersNO;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getDealPersNO() {
        return dealPersNO;
    }

    public void setDealPersNO(String dealPersNO) {
        this.dealPersNO = dealPersNO;
    }

    public String getDealReson() {
        return dealReson;
    }

    public void setDealReson(String dealReson) {
        this.dealReson = dealReson;
    }

}
