package com.yang.thelab.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import com.yang.thelab.common.enums.LoginType;

/**
 * 
 * @author YJ.yang
 * @version $Id: AccessControlFilter.java, v 0.1 2016年3月9日 下午12:30:03 dev Exp $
 */
public class AccessControlFilter extends OncePerRequestFilter {

    private static final List<LoginControl> CONTROL_LIST = new ArrayList<LoginControl>();

    private static class LoginControl {
        private String          uri;
        private List<LoginType> loginTypeList = new ArrayList<LoginType>();
        private String          mapUri;

        public LoginControl(String uri,String mapUri, LoginType... loginType) {
            this.uri = uri;
            this.mapUri = mapUri;
            CollectionUtils.addAll(loginTypeList, loginType);
        }
        
    }

    static {
        CONTROL_LIST.add(new LoginControl("/itemmanager", "/enumItemList" ,LoginType.STU_LOGIN));
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            //方便测试环境中的跨域测试
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Headers",
                "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
            return;
        }
        String uri = request.getRequestURI();

        if (uri.equals("/testPage")) {
            request.getRequestDispatcher("/testPage").forward(request, response);
            return;
        }
        if (uri.equals("/")) {
            request.getRequestDispatcher("/login.htm").forward(request, response);
            return;
        }
        if (!(uri.startsWith("/api") || uri.startsWith("/img") || uri.endsWith(".txt")
              || uri.endsWith("/login.htm") || uri.endsWith("/home") || uri.endsWith(".css")
              || uri.endsWith(".js") || uri.endsWith(".ico"))) {
            request.getRequestDispatcher("/error.htm").forward(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
