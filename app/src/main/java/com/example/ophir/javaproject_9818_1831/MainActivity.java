package com.example.ophir.javaproject_9818_1831;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.provider.UserDictionary;

import com.example.ophir.javaproject_9818_1831.model.backend.IDSManager;
import com.example.ophir.javaproject_9818_1831.model.backend.ManagerFactory;
import com.example.ophir.javaproject_9818_1831.model.datasource.CustomContentProvider;
import com.example.ophir.javaproject_9818_1831.model.entities.User;
import com.example.ophir.javaproject_9818_1831.model.entities.Activities;
import com.example.ophir.javaproject_9818_1831.model.entities.Business;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Business> businesses;
    ArrayList<Activities> activities;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IDSManager manager= ManagerFactory.getDataSource();
        ContentValues values=new ContentValues();
    }
}