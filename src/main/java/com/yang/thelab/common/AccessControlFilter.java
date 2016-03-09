package com.yang.thelab.common;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;
/**
 * 
 * @author YJ.yang
 * @version $Id: AccessControlFilter.java, v 0.1 2016年3月9日 下午12:30:03 dev Exp $
 */
public class AccessControlFilter extends OncePerRequestFilter {
    
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
        System.out.println(uri);
        if (uri.equals("/")||uri.endsWith("login")||uri.endsWith("login.htm")) {
            request.getRequestDispatcher("/login.htm").forward(request, response);
            return ; 
        }
        if(!(uri.startsWith("/api") 
                || uri.startsWith("/img")
                || uri.endsWith(".css")
                || uri.endsWith(".js")
                || uri.endsWith(".ico"))){
            request.getRequestDispatcher("/error.htm").forward(request, response);
            return ;
        }
        filterChain.doFilter(request, response);
    }
}
