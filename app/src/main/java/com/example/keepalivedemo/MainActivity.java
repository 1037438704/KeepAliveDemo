package com.example.keepalivedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.keepalivedemo.aty.KeepManager;

public class MainActivity extends AppCompatActivity {
//    KeepManager keepManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //1像素保活
//        keepManager = new KeepManager();
//        keepManager.registerKeep(this);

//        JobScheduler
        //        MyJobService.startJob(this);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        keepManager.unregisterKeep(this);//Activity退出时解注册
    }
}