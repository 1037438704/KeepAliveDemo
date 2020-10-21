package com.example.keepalivedemo;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

@SuppressLint("MissingPermission")
public class MyJobService extends JobService {
    public static void startJob(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
//        JobInfo.Builder builder = new JobInfo.Builder(8, new ComponentName(context.getPackageName(), MyJobService.class.getName())).setPersisted(true);
        JobInfo.Builder builder = new JobInfo.Builder( 1,
                new ComponentName( context.getPackageName(),
                        MyJobService.class.getName()));

        // 小于7.0是可以的
//        builder.setPeriodic(1000);
        //7.0之后
        builder.setMinimumLatency(1000);
        jobScheduler.schedule(builder.build());
    }


    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.e("zdl","onStartJob:");
        // STOPSHIP: 2020/10/21
        startJob(this);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
