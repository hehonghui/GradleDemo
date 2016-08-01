package com.simple.gradleplugin.mvp.base;

import android.content.Context;

/**
 * MVP Presenter 基类
 * @param <V> 视图的类型
 */
public abstract class BasePresenter<V extends MvpView> {

    Context mContext ;
    V mView ;

    public void attach(Context context, V view) {
        mContext = context ;
        mView = view ;
    }

    public void detach() {
        mContext = null;
        mView = null;
    }
}
