package com.yang.thelab.biz.manager;

import com.yang.thelab.biz.dto.ReserveDTO;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.requ.ReserveQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveManager.java, v 0.1 2016年5月3日 下午7:15:19 dev Exp $
 */
public interface ReserveManager {
    
    Paginator<ReserveDTO> query(ReserveQueryRequ requ);
    
    void save(ReserveDTO DTO);
}
