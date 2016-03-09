package com.yang.thelab.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.thelab.common.BaseController;
/**
 * 
 * @author YJ.yang
 * @version $Id: LoginController.java, v 0.1 2016年3月9日 下午12:37:35 dev Exp $
 */
@Controller
public class LoginController extends BaseController {
    
    @RequestMapping("/error.htm")
    public String notFound(){
        return "404";
    }
    
    @RequestMapping("/login.htm")
    public String login(HttpServletResponse response){
        return "login";
    }
    
    @RequestMapping("/api/dologin")
    public String doLogin(HttpServletResponse response,HttpServletRequest request){
        
        return "";
    }
      
}
