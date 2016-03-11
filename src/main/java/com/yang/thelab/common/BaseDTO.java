package com.yang.thelab.common;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author YJ.yang
 * @version $Id: BaseDTO.java, v 0.1 2016年3月11日 下午12:11:02 dev Exp $
 */
public abstract class BaseDTO<T> {
    
    protected T prop;

    public BaseDTO(T prop) {
        this.prop = prop;
    }
  
    public BaseDTO() {
        
    }

    /**
     * ibatis属性赋值会用到，而且无法统一使用父类的泛型直接实现
     * @return
     */
    public T getProp(){
        return this.prop;
    }

    /**
     * ibatis属性赋值会用到，而且无法统一使用父类的泛型直接实现
     * @return
     */
    public void setProp(T prop){
        this.prop = prop;
    }

    /**
     * 获取基础属性快捷方式
     * @return
     */
    public T get() {
        return prop;
    }

    /**
     * 设置基础属性快捷方式
     * @return
     */
    public void set(T prop) {
        setProp(prop);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
