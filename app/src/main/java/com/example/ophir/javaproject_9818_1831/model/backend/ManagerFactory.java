package com.example.ophir.javaproject_9818_1831.model.backend;

import com.example.ophir.javaproject_9818_1831.model.datasource.ListDsManager;

/**
 * Created by ophir on 26/11/2016.
 */

public class ManagerFactory {
    static IDSManager dataSource;
    public static IDSManager getDataSource()
    {
        if(dataSource==null)
            dataSource=new ListDsManager();
        return dataSource;
    }
}