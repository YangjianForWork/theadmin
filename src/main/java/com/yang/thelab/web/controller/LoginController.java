package com.yang.thelab.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.common.BaseController;
import com.yang.thelab.common.enums.LoginControlEnum;
import com.yang.thelab.common.utils.CommUtil;

/**
 * 
 * @author YJ.yang
 * @version $Id: LoginController.java, v 0.1 2016年3月9日 下午12:37:35 dev Exp $
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping("/control")
    public String controllLogin(HttpServletRequest request, HttpServletResponse response) {
        String uri = (String) request.getAttribute("code");
        LoginControlEnum item = (LoginControlEnum)CommUtil.getEnumByCode(LoginControlEnum.class,
            uri);
        if (item == null) {
            return "login";
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

    @RequestMapping("/home")
    public String doLogin(String userName, String pwd, HttpServletResponse response,
                          HttpServletRequest request) {
        if (StringUtils.isBlank(userName) && StringUtils.isBlank(pwd)) {
            return "redirect:/login.htm";
        }

        return "default";
    }

    @RequestMapping("/api/logout")
    public String logout(){
        //TODO 清空session
        return "login";
    }
}
