package com.example.keepalivedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.keepalivedemo.account.AccountHelper;


/*
 * 账号同步拉活
 *
 *
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AccountHelper.addAccount(this);
        AccountHelper.autoSync();
    }

}