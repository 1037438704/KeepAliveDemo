package com.example.keepalivedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.keepalivedemo.aty.KeepManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        JobScheduler
                MyJobService.startJob(this);

    }

}