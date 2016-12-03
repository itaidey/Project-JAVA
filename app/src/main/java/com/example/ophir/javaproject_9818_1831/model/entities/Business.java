package com.example.ophir.javaproject_9818_1831.model.entities;

import android.content.ContentValues;

/**
 * Created by ophir on 26/11/2016.
 */

public class Business {
    int id;
    String name;
    Address address;
    String phoneNumber;
    String email;
    String webSiteUrl;

    public Business(int id, String name, Address address, String phoneNumber, String email, String webSiteUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.webSiteUrl = webSiteUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }
}

