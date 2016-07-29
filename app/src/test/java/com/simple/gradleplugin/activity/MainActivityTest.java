package com.simple.gradleplugin.activity;

import android.app.Activity;
import android.widget.TextView;

import com.simple.gradleplugin.BuildConfig;
import com.simple.gradleplugin.MainActivity;
import com.simple.gradleplugin.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static junit.framework.Assert.*;

/**
 * Created by mrsimple on 29/7/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class MainActivityTest {

    public void testUiElements() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class) ;
        assertNotNull(activity);
    }

    @Test
    public void testLifecycle() {
        ActivityController<MainActivity> activityController = Robolectric.buildActivity(MainActivity.class).create().start();
        Activity activity = activityController.get();
        TextView textview = (TextView) activity.findViewById(R.id.main_tv);
        assertEquals("onCreate", textview.getText().toString());
        activityController.resume();
        assertEquals("onResume", textview.getText().toString());
        activityController.destroy();
        assertEquals("onDestroy", textview.getText().toString());
    }
}
