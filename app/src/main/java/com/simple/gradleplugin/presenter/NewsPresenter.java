package com.simple.gradleplugin.presenter;

import android.util.Log;

import com.simple.gradleplugin.dao.NewsDAO;

import java.util.List;

/**
 * Mockito 文档: http://mockito.org/
 * Created by mrsimple on 28/7/16.
 */
public class NewsPresenter {

    NewsDAO mDao = new NewsDAO();

    public void setDao(NewsDAO dao) {
        this.mDao = dao;
    }

    public NewsDAO getmDao() {
        return mDao;
    }

    public void fetchNews() {
        List<String> newsCache = mDao.loadDataFromDatabase();
        if (newsCache.size() == 0) {
            fetchFromServer();
        } else {
            showCacheNews(newsCache);
        }
    }

    public void fetchFromServer() {
        for (int i = 0; i < 5; i++) {
            mDao.insert(i, "news title " + i);
        }
    }

    public void showCacheNews(List<String> newsCache) {
        for (String newsItem : newsCache) {
            Log.e("", "### cache new : " + newsItem);
        }
    }
}
