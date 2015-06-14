package com.springapp.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: raunakshakya
 * Date: 5/7/15
 * Time: 6:27 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationProvider")
    AuthenticationProvider authenticationProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/admin/**")
                .access("hasRole('ROLE_USER')").and().formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutSuccessUrl("/login?logout").and().csrf();
    }

}

/*

The equivalent of the Spring Security XML file :

    <!-- enable use-expressions -->
	<http auto-config="true" use-expressions="true">

		<intercept-url pattern="/admin**" access="hasRole('ROLE_ADMIN')" />

		<!-- access denied page -->
		<access-denied-handler error-page="/403" />

		<form-login
		    login-page="/login"
		    default-target-url="/welcome"
			authentication-failure-url="/login?error"
			username-parameter="username"
			password-parameter="password" />
		<logout logout-success-url="/login?logout"  />
		<!-- enable csrf protection -->
		<csrf/>
	</http>

	<!-- Select users and user_roles from database -->
	<authentication-manager>
	  <authentication-provider>
		<jdbc-user-service data-source-ref="dataSource"
		  users-by-username-query=
		    "select username,password, enabled from users where username=?"
		  authorities-by-username-query=
		    "select username, role from user_roles where username =?  " />
	  </authentication-provider>
	</authentication-manager>

*/
