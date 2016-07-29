package com.simple.gradleplugin.app;

import android.app.Application;

/**
 * Created by mrsimple on 29/7/16.
 */
public class CustomApplication extends Application {

    private static CustomApplication sInstance ;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this ;
    }

    public static CustomApplication getInstance() {
        return sInstance;
    }
}
