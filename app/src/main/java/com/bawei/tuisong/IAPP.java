package com.bawei.tuisong;

import android.app.Application;

import com.igexin.sdk.PushManager;

/**
 * Created by yufuhao on 2017/5/11.
 */

public class IAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //注册
        PushManager.getInstance().initialize(this,DemoPushService.class);
        //登陆
        PushManager.getInstance().registerPushIntentService(this,DemoIntentService.class);
    }
}
