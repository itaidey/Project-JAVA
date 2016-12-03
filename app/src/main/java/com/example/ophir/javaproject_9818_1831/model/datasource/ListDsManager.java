package com.example.ophir.javaproject_9818_1831.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;

import com.example.ophir.javaproject_9818_1831.model.backend.IDSManager;
import com.example.ophir.javaproject_9818_1831.model.entities.Activities;
import com.example.ophir.javaproject_9818_1831.model.entities.ActivityDescription;
import com.example.ophir.javaproject_9818_1831.model.entities.Address;
import com.example.ophir.javaproject_9818_1831.model.entities.Business;
import com.example.ophir.javaproject_9818_1831.model.entities.User;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by ophir on 26/11/2016.
 */

public class ListDsManager implements IDSManager {
    Boolean businessOrActivitiesAdded = false;
    Boolean dbChanges = false;
    ArrayList<Business> businesses = new ArrayList<>();
    ArrayList<Activities> activities = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    @Override
    public Boolean addUser(ContentValues user) {
        try {
            users.add(new User(
                    user.getAsInteger("identificationNumber"),
                    user.getAsString("password")
            ));
        }
        catch (Exception e){return false;}
        dbChanges = true;
        return true;
    }

    @Override
    public Boolean addBusiness(ContentValues business) {
        try {
            businesses.add(new Business(
                    business.getAsInteger("id"),
                    business.getAsString("name"),
                    new Address(business.getAsString("country"), business.getAsString("city"), business.getAsString("street"), business.getAsInteger("houseNumber")),
                    business.getAsString("phoneNumber"),
                    business.getAsString("email"),
                    business.getAsString("webSiteUrl")
            ));
        }
        catch (Exception e){return false;}
        businessOrActivitiesAdded = true;
        dbChanges = true;
        return true;
    }

    @Override
    public Boolean addActivity(ContentValues activity) {
        try {
            activities.add(new Activities(
                    ActivityDescription.valueOf(activity.getAsString("activityType")),
                    activity.getAsString("country"),
                    Date.valueOf(activity.getAsString("startDate")),
                    Date.valueOf(activity.getAsString("endDate")),
                    activity.getAsInteger("coast"),
                    activity.getAsString("description"),
                    activity.getAsInteger("businessId")
                    ));
        }
        catch (Exception e){return false;}
        businessOrActivitiesAdded = true;
        dbChanges = true;
        return true;

    }

    @Override
    public Boolean checkChangeInBusinessesAndActivities() {

        if(businessOrActivitiesAdded)
        {
            businessOrActivitiesAdded = false;
            return true;
        }
        return false;
    }

    @Override
    public Cursor getUsers() {
        MatrixCursor usersCursor = new MatrixCursor(new String[]{"identificationNumber","password"});
        for(User user:users){
            usersCursor.addRow(new Object[]{
                    user.getIdentificationNumber(),
                    user.getPassword()
            });
        }
        return usersCursor;
    }

    @Override
    public Cursor getBusinesses() {
        MatrixCursor usersCursor = new MatrixCursor(new String[]{"id","name","country","city","street","houseNumber","phoneNumber","email","webSiteUrl"});
        for(Business business:businesses){
            usersCursor.addRow(new Object[]{
                    business.getId(),
                    business.getName(),
                    business.getAddress().getCountry(),
                    business.getAddress().getCity(),
                    business.getAddress().getStreet(),
                    business.getAddress().getHouseNumber(),
                    business.getPhoneNumber(),
                    business.getEmail(),
                    business.getWebSiteUrl()
            });
        }
        return usersCursor;
    }

    @Override
    public Cursor getActivities() {
        MatrixCursor activitiesCursor = new MatrixCursor(new String[]{"activityType","country","startDate","endDate","coast","description","businessId"});
        for(Activities activity:activities){
            activitiesCursor.addRow(new Object[]{
                    activity.getActivityType().toString(),
                    activity.getCountry(),
                    activity.getStartDate().toString(),
                    activity.getEndDate().toString(),
                    activity.getCoast(),
                    activity.getDescription(),
                    activity.getBusinessId()
            });
        }
        return activitiesCursor;
    }

    @Override
    public Boolean checkChangeInDataSource() {
        if(businessOrActivitiesAdded)
        {
            businessOrActivitiesAdded = false;
            return true;
        }
        return false;
    }
    @Override
    public Boolean dbChange()
    {
        if(dbChanges)
        {
            dbChanges = false;
            return true;
        }
        return false;
    }
}