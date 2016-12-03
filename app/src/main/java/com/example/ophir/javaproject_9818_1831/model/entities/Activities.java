package com.example.ophir.javaproject_9818_1831.model.entities;

import java.util.Date;

/**
 * Created by ophir on 26/11/2016.
 */


public class Activities {
    ActivityDescription activityType;
    String country;
    Date startDate;
    Date endDate;
    int coast;
    String description;
    int businessId;

    public Activities(ActivityDescription activityType, String country, Date startDate, Date endDate, int coast, String description, int businessId) {
        this.activityType = activityType;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.coast = coast;
        this.description = description;
        this.businessId = businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setActivityType(ActivityDescription activityType) {
        this.activityType = activityType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ActivityDescription getActivityType() {
        return activityType;
    }

    public String getCountry() {
        return country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getCoast() {
        return coast;
    }

    public String getDescription() {
        return description;
    }



}
