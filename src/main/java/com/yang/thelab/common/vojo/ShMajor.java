package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;

/**
 * 专业
 * @author YJ.yang
 * @version $Id: ShMajor.java, v 0.1 2016年3月14日 上午10:10:21 dev Exp $
 */
public class ShMajor extends BaseSO {
    /**名称*/
    private String name;
    /**代码*/
    private int    code;
    /**学院编号*/
    private String instituteNO;

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

    public String getInstituteNO() {
        return instituteNO;
    }

    public void setInstituteNO(String instituteNO) {
        this.instituteNO = instituteNO;
    }

}
