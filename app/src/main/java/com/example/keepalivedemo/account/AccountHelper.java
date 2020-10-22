package com.example.keepalivedemo.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.keepalivedemo.R;

public class AccountHelper {
    private static final String TAG = "AccountHelper";

    private static final String ACCOUNT_TYPE = "com.example.keepalivedemo";
    public static void addAccount(Context context){
        AccountManager accountManager = (AccountManager) context.getSystemService(context.ACCOUNT_SERVICE);
        //获得此类型的账户
        //需要增加权限 GET_ACCOUNTS
        Account[] accounts = accountManager.getAccountsByType(ACCOUNT_TYPE);
        if (accounts.length > 0){
            Log.e(TAG, "addAccount: 账户已存在");
            return;
        }
        //给这个账户类型添加一个账户
        //需要增加权限 AUTHENTICATE_ACCOUNTS
        Account account = new Account(R.string.app_name+"",ACCOUNT_TYPE);
        accountManager.addAccountExplicitly(account, null, null);

    }
    public static void autoSync(){
        Account account = new Account(R.string.app_name+"",ACCOUNT_TYPE);

        //下面三个都需要同一个权限 WRITE_SYNC_SETTINGS

        //设置同步
        ContentResolver.setIsSyncable(account,"com.example.keepalivedemo.provider",1);

        //自动同步
        ContentResolver.setSyncAutomatically(account,"com.example.keepalivedemo.provider",true);

        //设置同步周期
        ContentResolver.addPeriodicSync(account,"com.example.keepalivedemo.provider",new Bundle(),1);

    }

}
