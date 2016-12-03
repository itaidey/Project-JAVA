package com.example.ophir.javaproject_9818_1831.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;

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
    Boolean agenciesUpdates = false;
    ArrayList<Business> businesses = new ArrayList<>();
    ArrayList<Activities> activities = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    @Override
    public Boolean addUser(ContentValues user) {
        return null;
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
        agenciesUpdates = true;
        return  true;
    }

    @Override
    public Boolean addActivity(ContentValues activity) {
        try {
            /*this.activityType = activityType;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coast = coast;
        this.description = description;
        this.businessId = businessId;*/
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
        agenciesUpdates = true;
        return  true;

    }

    @Override
    public Boolean checkChangeInBusinessesAndActivities() {
        return null;
    }

    @Override
    public Cursor getUsers() {
        return null;
    }

    @Override
    public Cursor getBusinesses() {
        return null;
    }

    @Override
    public Cursor getActivities() {
        return null;
    }

    @Override
    public Boolean checkChangeInDataSource() {
        if(agenciesUpdates)
        {
            agenciesUpdates = false;
            return true;
        }
        return false;
    }
}