package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;

/**
 * 学校（简单设计）
 * @author YJ.yang
 * @version $Id: School.java, v 0.1 2016年3月14日 上午10:00:55 dev Exp $
 */
public class School extends BaseSO {

    /**名称*/
    private String name;
    /**代码*/
    private int    code;
    /**性质*/
    private String typeNO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTypeNO() {
        return typeNO;
    }

    public void setTypeNO(String typeNO) {
        this.typeNO = typeNO;
    }

}
