package com.example.keepalivedemo;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class ForegroundService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startForeground(1,new Notification());
        //8.0之前 看你有没有启动一个前台服务  id 为1 想要在8.0之前不想显示这个通知
        // 我启动一个同样的id为1 的服务自杀掉  然后就不显示了
        startService(new Intent(this,InnerService.class));

    }
    public static class InnerService extends Service{

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public void onCreate() {
            super.onCreate();
            startForeground(1,new Notification());
            stopSelf();
        }
    }

}