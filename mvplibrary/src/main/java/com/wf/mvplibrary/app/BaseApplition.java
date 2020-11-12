package com.wf.mvplibrary.app;

import android.app.Application;

/**
 * @author : wf
 * @time : 2020-11-10-19:59
 */
public class BaseApplition extends Application {

    public  static BaseApplition baseApplition;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplition = this;

    }
}
