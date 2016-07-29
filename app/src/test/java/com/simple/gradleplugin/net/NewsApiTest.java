package com.simple.gradleplugin.net;

import com.simple.gradleplugin.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

/**
 * Created by mrsimple on 29/7/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class NewsApiTest {

    @Test
    public void test() {
        assertTrue(true);
    }
}
