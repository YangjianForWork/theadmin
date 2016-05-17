package com.yang.thelab.biz.dto;

import com.yang.thelab.common.BaseDTO;
import com.yang.thelab.common.vojo.EnumItem;
import com.yang.thelab.common.vojo.Laboratory;

/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryDTO.java, v 0.1 2016年4月19日 下午12:57:45 dev Exp $
 */
/**
 * 
 * @author YJ.yang
 * @version $Id: LaboratoryDTO.java, v 0.1 2016年5月17日 下午3:05:55 dev Exp $
 */
public class LaboratoryDTO extends BaseDTO<Laboratory> {
    /**负责人*/
    private PersonDTO master;
    /**状态描述*/
    private String    statuDesc;
    /**类型*/
    private EnumItem  category;
    /**特性*/
    private EnumItem  attribute;
    /**当前预约数量*/
    private Long      currResCount;

    public LaboratoryDTO() {
        this.prop = new Laboratory();
    }

    public LaboratoryDTO(Laboratory prop) {
        this.prop = prop;
    }

    public PersonDTO getMaster() {
        return master;
    }

    public void setMaster(PersonDTO master) {
        this.master = master;
    }

    public String getStatuDesc() {
        return statuDesc;
    }

    public void setStatuDesc(String statuDesc) {
        this.statuDesc = statuDesc;
    }

    public EnumItem getCategory() {
        return category;
    }

    public void setCategory(EnumItem category) {
        this.category = category;
    }

    public EnumItem getAttribute() {
        return attribute;
    }

    public void setAttribute(EnumItem attribute) {
        this.attribute = attribute;
    }

    public Long getCurrResCount() {
        return currResCount;
    }

    public void setCurrResCount(Long currResCount) {
        this.currResCount = currResCount;
    }

    
}
