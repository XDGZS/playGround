package com.gradproject.playground.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int ID;
    private String NickName;
    private String Name;
    private String Address;
    private String Phone;
    private String Email;
    private String Password;
    private Date Birthday;
    private byte sex;
    private String Occupation;

    public User() {
    }

    public User(String email, String password) {
        Email = email;
        Password = password;
    }
}
