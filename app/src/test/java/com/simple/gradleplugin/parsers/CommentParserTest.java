package com.simple.gradleplugin.parsers;

import android.test.AndroidTestCase;

import com.simple.gradleplugin.BuildConfig;
import com.simple.gradleplugin.utils.AssetsUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by mrsimple on 2/8/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class CommentParserTest extends AndroidTestCase {

    @Test
    public void testParseComment() {
        // 模拟的数据在resource中
        String commentsStr = AssetsUtil.getResourceString(getClass().getClassLoader(), "mock_comments.json") ;
        assertTrue(commentsStr.length() > 30);

        System.out.println(commentsStr);
//        assertTrue( 10 > 3);
    }
}
