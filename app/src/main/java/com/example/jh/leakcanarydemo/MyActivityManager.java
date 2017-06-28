package com.example.jh.leakcanarydemo;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by jinhui on 2017/6/28.
 * 邮箱: 1004260403@qq.com
 */

public class MyActivityManager {

    static ArrayList arrayList = new ArrayList();

    public static void registActivity(Activity activity){
        arrayList.add(activity);
    }

    public static void unregistActivity(Activity activity)  {
        arrayList.remove(activity);
    }


}