package com.wf.mn.app;

import com.tencent.mmkv.MMKV;
import com.wf.mvplibrary.app.BaseApplition;

/**
 * @author : wf
 * @time : 2020-11-12-14:35
 */
public class App extends BaseApplition {

    public String mmkvDir;

    @Override
    public void onCreate() {
        super.onCreate();

       mmkvDir  = MMKV.initialize(this);
    }
}
