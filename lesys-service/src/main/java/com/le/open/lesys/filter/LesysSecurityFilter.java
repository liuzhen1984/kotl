package com.le.open.lesys.filter;

import com.letv.store.sso.client.filter.SecurityFilter;
import org.apache.catalina.core.ApplicationFilterConfig;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

/**
 * Created by zliu on 16/10/27.
 */
public class LesysSecurityFilter extends SecurityFilter {

    public void init(FilterConfig config) throws ServletException {
        if(config instanceof ApplicationFilterConfig){
            return;
        }
       super.init(config);

    }
}
