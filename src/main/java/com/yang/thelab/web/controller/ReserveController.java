package com.yang.thelab.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.biz.dto.PersonDTO;
import com.yang.thelab.biz.dto.ReserveDTO;
import com.yang.thelab.biz.manager.ReserveManager;
import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.LabReserveStatus;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.requ.ReserveQueryRequ;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveController.java, v 0.1 2016年5月11日 下午1:57:48 dev Exp $
 */
@Controller
public class ReserveController extends BaseController {

    @Autowired
    private ReserveManager      reserveManager;
    
    private final static String ADULT = "AGREE";

    @RequestMapping(value = "/api/reserve", params = { "service=submitReserve" })
    public void submitReserve(ReserveDTO DTO, HttpServletRequest request,
                              HttpServletResponse response) {
        PersonDTO personDTO = (PersonDTO) request.getSession().getAttribute("user");
        if (null == personDTO) {
            throw new BizException(BizCode.LOGIN_DATA_EXCE);
        }
        DTO.get().setApplyPersNO(personDTO.get().getBizNO());
        reserveManager.save(DTO);
        toResponse(response, DTO.get().getBizNO());
    }

    @RequestMapping(value = "/api/reserve", params = { "service=adultReserve" })
    public void adultReserve(ReserveDTO DTO, HttpServletResponse response,
                             HttpServletRequest request) {
        PersonDTO personDTO = (PersonDTO) request.getSession().getAttribute("user");
        if (null == personDTO) {
            throw new BizException(BizCode.LOGIN_DATA_EXCE);
        }
        if (personDTO.get().getRole().level() > 2) {
            throw new BizException(BizCode.MISS_PERMISSION);
        }
        if (DTO.getAdultStr().equals(ADULT)) {
            DTO.get().setStatus(LabReserveStatus.AGREE);
        } else {
            DTO.get().setStatus(LabReserveStatus.REFUSE);
        }
        DTO.get().setDealDate(new Date());
        reserveManager.save(DTO);
        toResponse(response, DTO.get().getBizNO());
    }

    @RequestMapping(value = "/api/reserve", params = { "service=query" })
    public void queryReserve(ReserveQueryRequ requ, HttpServletRequest request,
                             HttpServletResponse response) {
        PersonDTO personDTO = (PersonDTO) request.getSession().getAttribute("user");
        if (null == personDTO) {
            throw new BizException(BizCode.NOT_LOGIN);
        }
        requ.setRoleLevel(personDTO.get().getRole().level());
        if (personDTO.get().getRole().level() > 2) {
            requ.setApplyPersNO(personDTO.get().getBizNO());
        }
        if (personDTO.get().getRole().level() <= 2) {
            requ.setDealPersNO(personDTO.get().getBizNO());
        }
        toResponse(response, reserveManager.query(requ));
    }

}
