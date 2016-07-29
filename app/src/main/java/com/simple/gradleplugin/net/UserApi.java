package com.simple.gradleplugin.net;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.simple.gradleplugin.app.CustomApplication;

/**
 * Created by mrsimple on 29/7/16.
 */
public class UserApi {

    public void fetchProfile() {
        RequestQueue queue = Volley.newRequestQueue(CustomApplication.getInstance());
        StringRequest request = new StringRequest("www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("", "### 百度页面 : " + s) ;
            }
        }, null) ;
        queue.add(request) ;
    }
}
