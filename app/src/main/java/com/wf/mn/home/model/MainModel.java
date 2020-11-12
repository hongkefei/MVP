package com.wf.mn.home.model;

import android.util.Log;

import com.wf.mn.home.contract.MainContract;

/**
 * @author : wf
 * @time : 2020-11-10-9:00
 */
public class MainModel implements MainContract.IMainModel {

    private MainContract.IMainPresenter iMainPresenter;
    public MainModel(MainContract.IMainPresenter iMainPresenter) {
        this.iMainPresenter = iMainPresenter;
    }

    @Override
    public void getData() {
        Log.e("TAG","当前进入Model执行数据操作，模拟等待执行完毕");

        iMainPresenter.mCallBackData("我是数据，请接受");

    }
}
