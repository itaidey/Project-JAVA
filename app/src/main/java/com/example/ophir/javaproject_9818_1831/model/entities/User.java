package com.example.ophir.javaproject_9818_1831.model.entities;

/**
 * Created by ophir on 26/11/2016.
 */

public class User {
    int identificationNumber;
    String password;

    public User(int identificationNumber, String password) {
        this.identificationNumber = identificationNumber;
        this.password = password;
    }


    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}