package com.yang.thelab.common;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求IP地址
 * @author YJ.yang
 * @version $Id: RemoteIP.java, v 0.1 2016年4月25日 下午3:37:46 dev Exp $
 */
public class RemoteIP {
    /** 
     * <p> 
     * Web 服务器反向代理中用于存放客户端原始 IP 地址的 Http header 名字， 
     * 若新增其他的需要增加或者修改其中的值。 
     * </p> 
     */
    private static final String[] PROXY_REMOTE_IP_ADDRESS = { "X-Forwarded-For",
                                                              "HTTP_X_FORWARDED_FOR",
                                                              "Proxy-Client-IP",
                                                              "WL-Proxy-Client-IP",
                                                              "HTTP_CLIENT_IP", "X-Real-IP" };

    /** 
     * <p> 
     * 获取请求的客户端的 IP 地址。若应用服务器前端配有反向代理的 Web 服务器， 
     * 需要在 Web 服务器中将客户端原始请求的 IP 地址加入到 HTTP header 中。 
     * 详见 {@link #PROXY_REMOTE_IP_ADDRESS} 
     * </p> 
     */
    public static String get(HttpServletRequest request) {
        for (int i = 0; i < PROXY_REMOTE_IP_ADDRESS.length; i++) {
            String ip = request.getHeader(PROXY_REMOTE_IP_ADDRESS[i]);
            if (ip != null && ip.trim().length() > 0) {
                return getRemoteIpFromForward(ip.trim());
            }
        }
        return request.getRemoteHost();
    }

    private static String getRemoteIpFromForward(String xforwardIp) {
        int commaOffset = xforwardIp.indexOf(',');
        if (commaOffset < 0) {
            return xforwardIp;
        }
        return xforwardIp.substring(0, commaOffset);
    }
}
