package com.simple.gradleplugin;

/**
 * Created by mrsimple on 28/7/16.
 */
public class SDKManager {
    private static SDKManager sInstance = new SDKManager();

    public static SDKManager getInstance() {
        return sInstance;
    }

    private SDKManager() {
    }
}
