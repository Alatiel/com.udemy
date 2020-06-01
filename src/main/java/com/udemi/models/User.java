package com.udemi.models;

public class User {

    private String name;
    private String email;
    private String password;
    private String UserLbl;
    private String cookieName;
    private String cookieValue;

    public User() {}

    public User (String cookieName, String cookieValue) {
        this.cookieName = cookieName;
        this.cookieValue = cookieValue;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setUserLbl(String newUserLbl) {
        this.UserLbl = newUserLbl;
        return this;
    }

    public String getCookieValue() {
        return cookieValue;
    }

    public String getCookieName() {
        return cookieName;
    }

    public String getUserLbl() {
        return UserLbl;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

