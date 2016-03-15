package com.yang.thelab.common.vojo;

import com.yang.thelab.common.BaseSO;

/**
 * 学院
 * 
 * @author YJ.yang
 * @version $Id: ShInstitute.java, v 0.1 2016年3月14日 上午10:16:13 dev Exp $
 */
public class ShInstitute extends BaseSO {

    /**名称*/
    private String name;
    /**代码*/
    private int    code;
    /**学校编号*/
    private String schoolNO;

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

    public String getSchoolNO() {
        return schoolNO;
    }

    public void setSchoolNO(String schoolNO) {
        this.schoolNO = schoolNO;
    }
    
    
}
