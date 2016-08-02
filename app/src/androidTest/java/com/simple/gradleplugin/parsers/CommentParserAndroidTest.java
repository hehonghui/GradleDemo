package com.simple.gradleplugin.parsers;

import android.test.InstrumentationTestCase;

import com.simple.gradleplugin.utils.AssetsUtil;

/**
 * Android Unit Test, 任务名为 : connectedAndroidTest
 * Created by mrsimple on 2/8/16.
 */
public class CommentParserAndroidTest extends InstrumentationTestCase {

    public void testParse() {
        String commentsStr = AssetsUtil.getStringFromAsset(getInstrumentation().getContext(), "mock_comments.json") ;
        assertTrue( commentsStr.length() > 30 );
    }
}
