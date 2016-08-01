package com.simple.gradleplugin;

/**
 * Created by mrsimple on 28/7/16.
 */
public class SDKManager {
    private static final SDKManager INSTANCCE = new SDKManager();

    public static SDKManager getInstance() {
        return INSTANCCE;
    }

    private SDKManager() {
    }
}
