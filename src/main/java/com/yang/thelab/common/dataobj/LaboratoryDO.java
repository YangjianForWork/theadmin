package com.yang.thelab.common.dataobj;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.enums.LabStatus;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.common.vojo.Laboratory;

/**
 * 
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryDO.java, v 0.1 2016年3月14日 上午10:49:19 dev Exp $
 */
public class LaboratoryDO extends BaseDO<Laboratory> {

    public LaboratoryDO() {
        this.prop = new Laboratory();
    }

    public LaboratoryDO(Laboratory prop) {
        this.prop = prop;
    }

    @Override
    public Laboratory getProp() {
        return this.prop;
    }

    @Override
    public void setProp(Laboratory prop) {
        this.prop = prop;
    }

    public String getStatus(){
        return this.prop.getStatus().code();
    }
    
    public void setStatus(String status){
        this.prop.setStatus((LabStatus) CommUtil.getEnumByCode(LabStatus.class, status));
    }
}
