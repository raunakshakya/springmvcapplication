package com.springapp.mvc.config.core;

import com.springapp.mvc.config.SecurityConfig;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created with IntelliJ IDEA.
 * User: raunakshakya
 * Date: 5/7/15
 * Time: 6:45 AM
 * To change this template use File | Settings | File Templates.
 */
//@Order(2)
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}

/*

The equivalent of Spring Security in web.xml file :

	<filter>
		<filter-name>springSecurityFilterChain</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy
                </filter-class>
	</filter>

	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

*/
