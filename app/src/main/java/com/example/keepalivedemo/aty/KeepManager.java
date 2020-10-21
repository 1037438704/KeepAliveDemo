package com.example.keepalivedemo.aty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.lang.ref.WeakReference;

public class KeepManager {
    KeepReceiver mKeepReceiver;
    private WeakReference<Activity>  mKeepActivity;

    /* *
     * 注册 开屏  关屏  广播
     * */
    public void registerKeep(Context context) {
        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);

        mKeepReceiver = new KeepReceiver();
        context.registerReceiver(mKeepReceiver, filter);
    }


    /*
     * 注销 广播接受者
     * */
    public void unregisterKeep(Context context) {
        if (mKeepReceiver != null) {
            context.unregisterReceiver(mKeepReceiver);
        }
    }


    /*
     * 开启1像素Activity
     * */
    public void startKeep(Context context) {
        Intent intent = new Intent(context, KeepActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    /*
     * 关闭1像素Activity
     * */
    public void finishKeep() {
        if (mKeepActivity != null) {
            Activity activity =  mKeepActivity.get();
            if (activity != null) {
                activity.finish();
            }
            mKeepActivity = null;
        }
    }
    /*
    * 设置弱引用
    * */
    public void setKeep(KeepActivity keep){
        mKeepActivity = new WeakReference<Activity>(keep);
    }

}
