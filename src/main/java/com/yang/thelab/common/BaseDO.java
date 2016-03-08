package com.yang.thelab.common;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 基本数据类型
 * 
 * @author YJ.yang
 * @version $Id: BaseDO.java, v 0.1 2016年3月8日 下午6:58:35 dev Exp $
 */
public abstract class BaseDO <T extends BaseSO> {
    /**属性*/
    protected T prop;

    public BaseDO() {
    }
    
    public BaseDO(T prop){
        this.prop = prop;
    }
    
    public String getBizNO(){
        return this.prop.getBizNO();
    }
    
    public void setBizNO(String bizNO){
        this.prop.setBizNO(bizNO);
    }
    
    public abstract T getProp();
    
    public abstract void setProp(T prop);
    
    /**快速获取属性值*/
    public T get(){
        return prop;
    }
    /**快速设置属性值*/
    public void set(T prop){
        this.prop = prop;
    }
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
