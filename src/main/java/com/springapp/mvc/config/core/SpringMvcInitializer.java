package com.springapp.mvc.config.core;

import com.springapp.mvc.config.AppConfig;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.Filter;

import org.springframework.web.filter.*;
import org.springframework.web.servlet.support.*;

/**
 * Created with IntelliJ IDEA.
 * User: raunakshakya
 * Date: 5/7/15
 * Time: 7:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

/*
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }
*/

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;//new Class[]{WebMvcSecurityConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

/*
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new DelegatingFilterProxy("springSecurityFilterChain")};
    }
*/

}