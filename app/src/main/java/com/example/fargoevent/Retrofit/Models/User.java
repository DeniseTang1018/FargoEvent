package com.example.fargoevent.Retrofit.Models;


public class User {
    private String userName;
    private String userPassword;
    private String token;
    private static boolean loggedIn = false;


    public static void setLoggedIn(boolean loggedIn) {
        User.loggedIn = loggedIn;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
