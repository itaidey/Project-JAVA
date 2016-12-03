package com.example.ophir.javaproject_9818_1831.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.ophir.javaproject_9818_1831.model.entities.Activities;
import com.example.ophir.javaproject_9818_1831.model.entities.Business;
import com.example.ophir.javaproject_9818_1831.model.entities.User;

import java.util.ArrayList;

/**
 * Created by ophir on 26/11/2016.
 */

public interface IDSManager {
    Boolean addUser(ContentValues user);
    Boolean addBusiness(ContentValues business);
    Boolean addActivity(ContentValues activity);
    Boolean checkChangeInBusinessesAndActivities();
    Cursor getUsers();
    Cursor getBusinesses();
    Cursor getActivities();
    Boolean checkChangeInDataSource();
    //Content Provider to check what that means.
}
