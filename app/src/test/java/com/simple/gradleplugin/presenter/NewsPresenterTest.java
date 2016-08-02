package com.simple.gradleplugin.presenter;

import com.simple.gradleplugin.BuildConfig;
import com.simple.gradleplugin.dao.NewsDAO;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Collections;
import java.util.Random;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Mockito 文档: http://mockito.org/, roboletric 文章 http://gold.xitu.io/entry/56f2ad2d128fe1005164312a,
 * http://iceanson.github.io/Robolectric-%E6%8E%A2%E7%B4%A2%E4%B9%8B%E8%B7%AF.
 *
 * 示例: https://github.com/geniusmart/LoveUT
 *
 * <p/>
 * Created by mrsimple on 28/7/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class NewsPresenterTest extends TestCase {

    //    监控该对象, 真实调用NewsPresenter中的逻辑
    NewsPresenter mPresenter = spy(NewsPresenter.class);
    NewsDAO mMockNewsDao = mock(NewsDAO.class);

    @Test
    public void testLoadDataFromDatabase() {
        mPresenter.fetchNews();
        // 从服务器返回数据
        verify(mPresenter, times(1)).fetchFromServer();
        verify(mPresenter, never()).showCacheNews(anyList());
        // 从服务器返回5项数据
        assertEquals(5, mPresenter.getmDao().loadDataFromDatabase().size());

        // 重新获取数据
        mPresenter.fetchNews();
        verify(mPresenter, times(1)).showCacheNews(anyList());
    }

    @Test
    public void testWithMockDao() {
        NewsPresenter presenter = spy(NewsPresenter.class);
        verify(presenter, never()).showCacheNews(anyList());

        // 获取数据
        presenter.fetchNews();
        // 从服务器返回数据
        verify(presenter, times(1)).fetchFromServer();
        verify(presenter, never()).showCacheNews(anyList());
        // 从服务器返回5项数据
        assertEquals(5, presenter.getmDao().loadDataFromDatabase().size());

        // 注入 mock dao
        when(mMockNewsDao.loadDataFromDatabase()).thenReturn(Collections.EMPTY_LIST);
        presenter.setDao(mMockNewsDao);

        // 获取数据, 由于使用了mock dao, 返回的缓存数据为0
        presenter.fetchNews();
        // 从服务器返回数据
        verify(presenter, times(2)).fetchFromServer();
        verify(presenter, times(0)).showCacheNews(anyList());
        // 从服务器返回0项数据
        assertEquals(0, presenter.getmDao().loadDataFromDatabase().size());
    }

    @Test
    public void testFailed() {
        // 随机数,有一定积累测试失败
//        assertTrue(  new Random().nextInt(5) % 2 == 0 );
    }
}
