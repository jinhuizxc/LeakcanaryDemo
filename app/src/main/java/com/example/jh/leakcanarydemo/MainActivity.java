package com.example.jh.leakcanarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决内存泄漏的简单示例demo
 *
 * 重点关注结果图，最后的红点表示的是MainActivity实例泄漏的，
 * 而上面几个是跟踪过程，可以看到最后定位到的是arrayList这个容器有泄漏，然后就可以走查代码了
 * static ArrayList arrayList = new ArrayList();
 * 也就是定位到上面这行，也就能发现问题了，解决方法是这样的，非常通用，在onDestory反注册就完了：
 */
public class MainActivity extends AppCompatActivity {

    List<Object> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }
        Log.e("ch", "------------>" + list.size());
        MyActivityManager.registActivity(this);
    }

    // 加上这句不会出现内存泄漏的问题了
    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyActivityManager.unregistActivity(this);
    }
}
