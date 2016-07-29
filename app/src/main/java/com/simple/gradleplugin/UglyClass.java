package com.simple.gradleplugin;

import android.util.Log;

/**
 * Created by mrsimple on 28/7/16.
 */
public class UglyClass {
    private int myAge;
    public String name;

    void sayHello(int i) {
        if (i == 0) {
            Log.e("", "hello");
        } else {
            Log.e("", "no talk");
        }
    }
}
