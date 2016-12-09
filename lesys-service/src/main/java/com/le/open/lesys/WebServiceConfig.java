package com.le.open.lesys;

import com.le.open.lesys.filter.LesysSecurityFilter;
import com.le.open.lesys.handle.LetvSSOAccessDecisionManager;
import com.letv.store.sso.client.filter.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Enumeration;

/**
 * Created by zliu on 16/10/27.
 */
@Configuration
public class WebServiceConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private WebApplicationContext applicationContext;
//
//    @Resource(name="org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedContext",type=StandardContext.class)
//    private StandardContext standardContext;

    @Value("${sso.host}")
    private String sso_host;

    @Value("${sso.site.code}")
    private String sso_site_code;

    @Value("${sso.site.secure}")
    private String sso_site_secure;
    @Value("${sso.site.secure.excludes}")
    private String sso_site_secure_excludes;

    @Bean
    public CharacterEncodingFilter characterEncodingFilter(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    public SecurityFilter securityFilter(){
        LesysSecurityFilter securityFilter = new LesysSecurityFilter();

        SecurityFilterConfig securityFilterConfig = new SecurityFilterConfig();
        securityFilterConfig = new SecurityFilterConfig();
        securityFilterConfig.setFilterName("securityFilter");
        securityFilterConfig.setParams("sso_host", sso_host);
        securityFilterConfig.setParams("sso_site_code", sso_site_code);
        securityFilterConfig.setParams("sso_site_secure", sso_site_secure);
        securityFilterConfig.setParams("access_decision_manager_class", LetvSSOAccessDecisionManager.class.getName());
        securityFilterConfig.setParams("excludes", sso_site_secure_excludes);
        try {
            securityFilter.init(securityFilterConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return securityFilter;
    }

    public class SecurityFilterConfig implements FilterConfig{
        private String filterName;

        public void setFilterName(String name){
            this.filterName = name;
        }
        public void setParams(String key,String value){
            applicationContext.getServletContext().setAttribute(key, value);
        }

        @Override
        public String getFilterName() {
            return this.filterName;
        }

        @Override
        public ServletContext getServletContext() {
            return applicationContext.getServletContext();
        }

        @Override
        public String getInitParameter(String s) {
            return (String) getServletContext().getAttribute(s);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return getServletContext().getInitParameterNames();
        }
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    // Only used when running in embedded servlet
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/WEB-INF");
    }
}

