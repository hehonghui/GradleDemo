package com.simple.gradleplugin.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.simple.gradleplugin.MainActivity;
import com.simple.gradleplugin.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import static junit.framework.Assert.*;

/**
 * Created by mrsimple on 2/8/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testTextView() {
        onView(withText("onResume")).check(matches(isDisplayed()));
        onView(withId(R.id.main_tv)).check(matches(isDisplayed()));
    }

    @Test
    public void testFailed() {
        assertEquals(1, 2);
    }
}
