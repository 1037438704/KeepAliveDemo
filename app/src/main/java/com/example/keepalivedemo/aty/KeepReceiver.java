package com.example.keepalivedemo.aty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

public class KeepReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("zdl", "onReceive: ");
        KeepManager keepManager = new KeepManager();

        if (TextUtils.equals(action,Intent.ACTION_SCREEN_OFF)){
            //关闭屏幕时，开启1像素activity\
            Log.e("zdl", "onReceive: ====打开");
            keepManager.startKeep(context);
        }else{
            //打开屏幕时 关闭1像素activity
            Log.e("zdl", "onReceive: =====关闭");
            keepManager.finishKeep();
        }
    }
}
