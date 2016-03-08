package com.yang.thelab.common;
/**
 * 基本数据模型
 * 
 * @author YJ.yang
 * @version $Id: BaseModel.java, v 0.1 2016年3月8日 下午7:01:40 dev Exp $
 */
public abstract class BaseModel<T extends BaseSO> {
    /**属性*/
    protected T prop;
    
    public BaseModel(T prop) {
        this.prop = prop;
    }

    public BaseModel() {
    }

    public T get() {
        return prop;
    }

    public void set(T prop) {
        this.prop = prop;
    }

    public T getProp() {
        return prop;
    }

    public void setProp(T prop) {
        this.prop = prop;
    }

    public String getBizNO() {
        return prop.getBizNO();
    }

    public void setBizNO(String bizNO) {
        prop.setBizNO(bizNO);
    }
    
}
