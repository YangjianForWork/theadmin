package com.yang.thelab.core.service;

import com.yang.thelab.core.model.SchoolModel;
import com.yang.thelab.core.model.ShInstituteModel;
import com.yang.thelab.core.model.ShMajorModel;

/**
 * 
 * @author YJ.yang
 * @version $Id: SchoolService.java, v 0.1 2016年3月14日 下午6:35:00 dev Exp $
 */
public interface SchoolService {
    
    void save(SchoolModel model);
    
    SchoolModel get(String bizNO);
    /**
     * 保存学院
     * 
     * @param model
     */
    void saveInstitute(ShInstituteModel instituteModel);
    /**
     * 根据ID获取学院
     * 
     * @param shInstituteNO
     * @return
     */
    ShInstituteModel getInstitute(String shInstituteNO);
    /**
     * 保存专业
     * 
     * @param model
     */
    void saveMajor(ShMajorModel majorModel);
    /**
     * 根据ID获取专业
     * 
     * @param shMajorNO
     * @return
     */
    ShMajorModel getMajor(String shMajorNO);
}
