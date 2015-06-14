package com.springapp.mvc.users.dao;

import com.springapp.mvc.users.model.UserAttempts;

/**
 * Created by raunakshakya on 5/10/15.
 * A DAO class to update the invalid login attempts.
 */
public interface UserDetailsDao {

    void updateFailAttempts(String username);

    void resetFailAttempts(String username);

    UserAttempts getUserAttempts(String username);

}
