package com.springapp.mvc.users.model;

import java.util.Date;

/**
 * Created by raunakshakya on 5/10/15.
 * This class represents the data of “user_attempts” table.
 */
public class UserAttempts {

    private int id;
    private String username;
    private int attempts;
    private Date lastModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

}
