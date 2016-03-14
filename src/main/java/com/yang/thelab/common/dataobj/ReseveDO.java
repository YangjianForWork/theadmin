package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.enums.LabReseveStatus;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Reseve;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReseveDO.java, v 0.1 2016年3月14日 上午10:52:51 dev Exp $
 */
public class ReseveDO extends BaseDO<Reseve> {

    public ReseveDO() {
        this.prop = new Reseve();
    }

    public ReseveDO(Reseve prop) {
        this.prop = prop;
    }

    @Override
    public Reseve getProp() {
        return this.prop;
    }

    @Override
    public void setProp(Reseve prop) {
        this.prop = prop;
    }
    
    public String getStatus(){
        return this.prop.getStatus().code();
    }
    
    public void setStatus(String status){
        this.prop.setStatus((LabReseveStatus) CommUtil.getEnumByCode(LabReseveStatus.class, status));
    }
}
