package com.yang.thelab.biz.dto;

import com.yang.thelab.common.BaseDTO;
import com.yang.thelab.common.vojo.Reserve;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveDTO.java, v 0.1 2016年5月3日 下午7:16:38 dev Exp $
 */
public class ReserveDTO extends BaseDTO<Reserve> {

    public ReserveDTO() {
        this.prop = new Reserve();
    }

    public ReserveDTO(Reserve prop) {
        this.prop = prop;
    }
}
