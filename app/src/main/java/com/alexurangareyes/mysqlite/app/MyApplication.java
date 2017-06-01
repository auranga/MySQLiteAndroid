package com.alexurangareyes.mysqlite.app;

import android.app.Application;

import com.alexurangareyes.mysqlite.model.DataBaseManager;

/**
 * Created by alexurangareyes on 6/1/17.
 */

public class MyApplication extends Application {

    DataBaseManager manager;

    @Override
    public void onCreate() {
        super.onCreate();

        manager = new DataBaseManager(this);
    }

    public DataBaseManager getManager() {
        return manager;
    }


}
