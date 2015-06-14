package com.springapp.mvc.web.handler;

import java.util.Date;

import com.springapp.mvc.users.dao.UserDetailsDao;
import com.springapp.mvc.users.model.UserAttempts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created by raunakshakya on 5/10/15.
 * Create a custom authentication provider, for every invalid login attempts,
 * update to user_attempts table and throws LockedException if the maximum attempts is hit.
 */

@Component("authenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    UserDetailsDao userDetailsDao;

    @Autowired
    @Qualifier("userDetailsService")
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        try {
            Authentication auth = super.authenticate(authentication);

            //if reach here, means login success, else an exception will be thrown
            //reset the user_attempts
            userDetailsDao.resetFailAttempts(authentication.getName());

            return auth;
        } catch (BadCredentialsException e) {

            //invalid login, update to user_attempts
            userDetailsDao.updateFailAttempts(authentication.getName());
            throw e;
        } catch (LockedException e) {

            //this user is locked!
            String error = "";
            UserAttempts userAttempts = userDetailsDao.getUserAttempts(authentication.getName());

            if (userAttempts != null) {
                Date lastAttempts = userAttempts.getLastModified();
                error = "User account is locked! <br><br>Username : "
                        + authentication.getName() + "<br>Last Attempts : " + lastAttempts;
            } else {
                error = e.getMessage();
            }

            throw new LockedException(error);
        }
    }

}
