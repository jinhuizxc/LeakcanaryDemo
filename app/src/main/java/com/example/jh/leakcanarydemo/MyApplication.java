package com.example.jh.leakcanarydemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jinhui on 2017/6/28.
 * 邮箱: 1004260403@qq.com
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
