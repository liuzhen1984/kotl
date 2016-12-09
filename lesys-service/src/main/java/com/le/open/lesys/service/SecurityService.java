package com.le.open.lesys.service;

import com.letv.store.sso.core.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zliu on 16/10/27.
 */
@Service
public class SecurityService {

    public static final String ADMIN_SESSION_ATTRIBUTE = "session_admin"; //保存用户信息的seesion attribute name


    private String SSO_LOGOUT = "/sso/_logout";

    @Value("${sso.host}")
    private String SSO_HOST;

    public void logout(HttpServletRequest req,HttpServletResponse resp){
        try {
            req.getSession().removeAttribute(ADMIN_SESSION_ATTRIBUTE);
            String logoutUrl = SSO_HOST+SSO_LOGOUT;
            if(!logoutUrl.startsWith("http")){
                logoutUrl = "http://" + logoutUrl;
            }
            resp.sendRedirect(logoutUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param req
     * @return
     */
    public static Authentication getAdmin(HttpServletRequest req){
        HttpSession session = req.getSession();
        return (Authentication) session.getAttribute(ADMIN_SESSION_ATTRIBUTE);
    }

    /**
     *
     * @param req
     * @return
     */
    public static void setAdmin(HttpServletRequest req,Authentication admin){
        HttpSession session = req.getSession();
        session.setAttribute(ADMIN_SESSION_ATTRIBUTE,admin);
    }

    /**
     *
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return null;
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equalsIgnoreCase(name)){
                return cookie;
            }
        }

        return null;
    }
}

