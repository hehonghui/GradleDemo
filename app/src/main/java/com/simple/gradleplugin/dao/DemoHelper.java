package com.simple.gradleplugin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.simple.gradleplugin.app.CustomApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrsimple on 27/7/16.
 */
public class DemoHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "demo.db";
    private static final int DATABASE_VERSION = 1;

    static DemoHelper demoHelper = null;

    public DemoHelper(Context context) {
        //CursorFactory设置为null,使用默认值
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DemoHelper getInstance() {
        if (demoHelper == null) {
            demoHelper = new DemoHelper(CustomApplication.getInstance());
        }
        return demoHelper;
    }

    public static void reset() {
        demoHelper.close();
        demoHelper = null;
    }

    //数据库第一次被创建时onCreate会被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS logs"
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, log TEXT)");

        Log.e("", "### 创建log表") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertLog(String log) {
        ContentValues values = new ContentValues();
        values.put("log", log);
        getWritableDatabase().insert("logs", null, values);
    }

    public List<String> queryLogs() {
        Cursor cursor = null;
        List<String> results = new ArrayList<>();
        try {
            cursor = getReadableDatabase().query("logs", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                results.add(cursor.getString(1));
            }
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }
}