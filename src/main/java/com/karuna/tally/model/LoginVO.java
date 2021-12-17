package com.karuna.tally.model;

import java.io.Serializable;

public class LoginVO implements Serializable {

    private static final long serialVersionUID = 767373534338020399L;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
