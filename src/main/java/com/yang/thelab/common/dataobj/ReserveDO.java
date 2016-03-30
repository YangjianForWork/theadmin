package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.enums.LabReseveStatus;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Reserve;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReseveDO.java, v 0.1 2016年3月14日 上午10:52:51 dev Exp $
 */
public class ReserveDO extends BaseDO<Reserve> {

    public ReserveDO() {
        this.prop = new Reserve();
    }

    public ReserveDO(Reserve prop) {
        this.prop = prop;
    }

    @Override
    public Reserve getProp() {
        return this.prop;
    }

    @Override
    public void setProp(Reserve prop) {
        this.prop = prop;
    }
    
    public String getStatus(){
        return this.prop.getStatus().code();
    }
    
    public void setStatus(String status){
        this.prop.setStatus((LabReseveStatus) CommUtil.getEnumByCode(LabReseveStatus.class, status));
    }
}
