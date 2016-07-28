package com.simple.gradleplugin.dao;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by mrsimple on 28/7/16.
 */
public class NewsDAO {

    private Map<Integer, String> mCaches = new HashMap<>() ;

    public boolean insert(int id, String newsItem) {
        Log.e("", "### 插入数据 : " + newsItem) ;
        mCaches.put(id, newsItem) ;
        return true ;
    }

    public String query(int id) {
        return mCaches.get(id) ;
    }

    public List<String> loadDataFromDatabase() {
        Log.e("", "### 耗时操作") ;
        mCaches.keySet();
        List<String> caches = new ArrayList<>() ;
        Iterator<Integer> iterator = mCaches.keySet().iterator() ;
        while ( iterator.hasNext() ) {
            int key = iterator.next() ;
            caches.add(mCaches.get(key));
        }
        return caches ;
    }
}
