package com.example.ophir.javaproject_9818_1831.model.datasource;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.ophir.javaproject_9818_1831.model.backend.IDSManager;
import com.example.ophir.javaproject_9818_1831.model.backend.ManagerFactory;

/**
 * Created by ophir on 26/11/2016.
 */

public class CustomContentProvider extends ContentProvider {
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static IDSManager manager = ManagerFactory.getDataSource();


    //sets the uris
    static {
        sUriMatcher.addURI("com.example.ophir.javaproject_9818_1831.model.datasource", "Businesses", 1);
        sUriMatcher.addURI("com.example.ophir.javaproject_9818_1831.model.datasource", "Activities", 2);
        sUriMatcher.addURI("com.example.ophir.javaproject_9818_1831.model.datasource", "Users", 3);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    /*
    The function returns a cursor containing a table of agencies or trips according to the given uri
    */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        /*
         ### The uri.getPath() function returns the path with the preceding "/", if you want to get rid of it you can simply
         use the substring function  as shown below.
         */
        String table = uri.getPath().substring(1);
        if (table.equalsIgnoreCase("businesses")) {
            try {
                return manager.getBusinesses();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (table.equalsIgnoreCase("activities")) {
            try {
                return manager.getActivities();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (table.equalsIgnoreCase("users")) {
            try {
                return manager.getUsers();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    /*
    adds a trip to the DB
    PARAMETERS
    uri - must contain the path to the table Trips
    Trip - must contain the values of the trips with the following filed names
    agencyID, image, country, startDate (string - dd/MM/yyy), endDate (string - dd/MM/yyy), price
    RETURN VALUE
    returns a null Uri, since the calling application has no use of the address of the given trip
     */
    public Uri insert(Uri uri, ContentValues obj) {
        String table = uri.getPath().substring(1);
        if (table.equalsIgnoreCase("Businesses")) {
            manager.addActivity(obj);
            return null;
        }
        if (table.equalsIgnoreCase("Activities")) {
            manager.addBusiness(obj);
            return null;
        }
        if (table.equalsIgnoreCase("Users")) {
            manager.addUser(obj);
            return null;
        }
        throw new IllegalArgumentException("This Content Provider supports only trips insertion");
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}