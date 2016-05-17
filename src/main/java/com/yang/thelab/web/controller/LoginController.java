package com.yang.thelab.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.biz.dto.PersonDTO;
import com.yang.thelab.biz.manager.PersonManager;
import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.LoginControlEnum;
import com.yang.thelab.common.exception.BizCode;
import com.yang.thelab.common.exception.BizException;
import com.yang.thelab.common.utils.CommUtil;

/**
 * 
 * @author YJ.yang
 * @version $Id: LoginController.java, v 0.1 2016年3月9日 下午12:37:35 dev Exp $
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private PersonManager personManager;

    @RequestMapping("/control")
    public String controllLogin(HttpServletRequest request, HttpServletResponse response) {
        String uri = (String) request.getAttribute("code");
        LoginControlEnum item = (LoginControlEnum) CommUtil.getEnumByCode(LoginControlEnum.class,
            uri);
        if (item == null) {
            return "redirect:/login.htm";
        }
        return item.mapStr();
    }

    @RequestMapping("/error.htm")
    public String notFound() {
        return "404";
    }

    @RequestMapping("/login.htm")
    public String loginhtm() {
        return "login";
    }

    @RequestMapping("/api/dologin")
    public void doLogin(String userName, String pwd, HttpServletResponse response,
                        HttpServletRequest request) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(pwd)) {
            throw new BizException(BizCode.LOGIN_INFO_BLANK);
        }
        PersonDTO personDTO = personManager.checkLogin(userName, pwd);
        request.getSession().setAttribute("user", personDTO);
        toResponse(response, personDTO.getCustomer().getNickname());
    }

    @RequestMapping("/home")
    public String login( HttpServletRequest request) {
        PersonDTO user = (PersonDTO) request.getSession().getAttribute("user");
        if (null == user) {
        	return "redirect:/login.htm";
		}
        return "default";
    }

/*    private String validLogin(String userName, String pwd, Customer customer) {
        if (!customer.getPassword().equals(SecurityUtil.getHash(pwd))) {
            return "redirect:/";
        }
        String mobile = SecurityUtil.decrypt(customer.getMobile(), personManager.getSecurityKey());
        if (mobile.equals(userName) || customer.getNickname().equals(userName)
            || customer.getExtNO().equals(userName)) {
            return "default";
        }
        return "redirect:/";
    }*/

    @RequestMapping("/api/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }
}
