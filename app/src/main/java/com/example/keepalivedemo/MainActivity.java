package com.example.keepalivedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


/*
 * 广播拉活
 *       在发生特定系统事件时，系统会发出广播，通过在 AndroidManifest 中
 *   静态注册对应的广播监听器，即可在发生响应事件时拉活。
 *       但是从7.0开始，对广播进行了限制，而在8.0更加严格
 *       可静态注册广播列表：
 *    https://developer.android.google.cn/guide/components/broadcast-exceptions.html
 *
 *  "全家桶"拉活
 *       有多个app在用户设备上安装，只要开启其中一个就可以将其他的app也拉活。比如手机里装了
 *   qq ,qq空间等，那么打开任意一个app后，其他的app也都会被唤醒。
 *
 * Service 系统机制拉活
 *   成本低
 *   坏处是不是很稳定
 *
 *
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, StickyService.class));

    }

}