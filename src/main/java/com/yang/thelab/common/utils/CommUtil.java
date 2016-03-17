/**
 * Yixiu.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.yang.thelab.common.utils;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.yang.thelab.common.BaseDO;
import com.yang.thelab.common.BaseModel;
import com.yang.thelab.common.EnumInterface;
import com.yang.thelab.common.enums.UniqueEnum;



/**
 * 
 * @author nibo
 * @version $Id: CommUtils.java, v 0.1 2015年11月15日 下午5:32:14 nibo Exp $
 */
public final class CommUtil {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final <T extends EnumInterface> T getEnumByCode(Class clazz, String code) {
        EnumSet<?> currEnumSet = EnumSet.allOf(clazz);
        for (Enum<?> elelent : currEnumSet) {
            T result = (T) elelent;
            if (result.code().equals(code)) {
                return result;
            }
        }
        return null;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static final <T extends BaseDO> Map<String,T> covDOList2Map(List<T> doList) {
        Map<String,T> result = new HashMap<String,T>();
        for (BaseDO DO : doList) {
           result.put(DO.getBizNO(), (T)DO);
        }
        return result;
    }
    
    public static final boolean isInsert(BaseModel<?> model){
        return StringUtils.isBlank(model.getBizNO());
    }

    /**
     * 简单的脱敏字符串
     * 
     * @param string
     * @return
     */
    public static final String loseSensitiveStr(String string){
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length - 4; i++) {
            array[i] = '*';
        }
        return String.copyValueOf(array);
    }
    /**
     * 处理主键重复异常冲突
     * 
     * @param e
     * @return
     */
    public static final UniqueEnum getDuplicateKeyItem(String eMessage){
        int eLen = eMessage.length();
        UniqueEnum tempEnum = null;
        for (UniqueEnum item : UniqueEnum.ENUM_LIST) {
            int len = item.code().length();
            String code = eMessage.substring(eLen-len-1, eLen-1);
            if (item.code().equals(code)) {
               tempEnum = item;
            }
        }
        if (tempEnum == null) {
            tempEnum = UniqueEnum.UQ_DEFAULT;
        }
        return tempEnum;
    }
    
}