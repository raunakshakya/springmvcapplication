package com.springapp.mvc.users.dao;

import com.springapp.mvc.users.model.User;

public interface UserDao {

    User findByUserName(String username);

}