package com.simple.gradleplugin.dao;

import com.simple.gradleplugin.BuildConfig;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 注意测试数据库时两个测试之间没有任何关联,数据也会被清理掉. 因此测试时需要保持各个测试用例的独立性.
 *
 * Created by mrsimple on 29/7/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class SQLiteHelperTest {

    @Test
    public void testInsert() {
        String log = "my log";
        DemoHelper demoHelper = DemoHelper.getInstance();
        demoHelper.insertLog(log);

        List<String> logs = demoHelper.queryLogs() ;
        // 判断数据库中的数据
        assertEquals(logs.size(), 1 );

        // 判断数据库中的数据
        assertEquals(log, logs.get(0));
    }

    @After
    public void resetDatabaseConnection() {
        // 每次测试之后要断掉数据链接, 否则会出现异常
        // java.lang.IllegalStateException: Illegal connection pointer 1.
        // Current pointers for thread Thread[pool-4-thread-1,5,main] []
        DemoHelper.reset();
    }

    @Test
    public void testInsertSecond() {
        String log = "my log 2";
        DemoHelper demoHelper = DemoHelper.getInstance();
        demoHelper.insertLog(log);
        demoHelper.insertLog(log + 3);

        List<String> logs = demoHelper.queryLogs() ;
        // 判断数据库中的数据
        assertEquals(logs.size(), 2);

        // 判断数据库中的数据
        assertEquals(log, logs.get(0));

        // 判断数据库中的数据
        assertEquals(log + 3, logs.get(1));
    }
}
