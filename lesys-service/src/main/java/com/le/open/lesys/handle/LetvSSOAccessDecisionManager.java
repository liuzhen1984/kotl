package com.le.open.lesys.handle;

import com.le.open.lesys.service.SecurityService;
import com.letv.store.sso.client.AccessDecisionManager;
import com.letv.store.sso.client.security.SecurityContext;
import com.letv.store.sso.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by zliu on 16/10/27.
 */
public class LetvSSOAccessDecisionManager implements AccessDecisionManager {
    private static Logger LOGGER = LoggerFactory.getLogger(LetvSSOAccessDecisionManager.class);

    @Override
    public boolean decide(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Authentication admin = SecurityService.getAdmin(httpServletRequest);

        if(admin!=null){
            return true;
        }
        Authentication authentication = SecurityContext.getAuthentication();
        if(authentication==null){
            return false;
        }else{
            SecurityService.setAdmin(httpServletRequest, authentication);
        }
        return true;
    }



}