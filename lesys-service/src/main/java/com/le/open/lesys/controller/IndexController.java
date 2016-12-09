package com.le.open.lesys.controller;

import com.le.open.lesys.service.SecurityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by zliu on 16/10/26.
 */
@Controller
public class IndexController {
    private final static Logger LOGGER = Logger.getLogger(IndexController.class);
    @Value("${application.message}")
    private String message = "Hello World";


    @Autowired
    private SecurityService securityService;

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }

    @GetMapping("/")
    public String index(HttpServletRequest request,Map<String,Object> model){
        model.put("admin",request.getSession().getAttribute(SecurityService.ADMIN_SESSION_ATTRIBUTE));
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        LOGGER.info("logout");
        securityService.logout(request,response);
        return "index";
    }

//    @RequestMapping("/security_check")
//    public String security_check(){
//        LOGGER.debug("security_check");
//        return "index";
//    }
}
