package com.wf.mn.home.presenter;

import android.util.Log;

import com.wf.mn.home.contract.MainContract;
import com.wf.mn.home.model.MainModel;
import com.wf.mvplibrary.base.BasePresenter;

/**
 * @author : wf
 * @time : 2020-11-10-9:00
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView,MainModel> implements MainContract.IMainPresenter {

    @Override
    public MainModel setModel() {
        return new MainModel(this);
    }
    @Override
    public void getDate() {
        Log.e("TAG","调用方法");
        iModel.getData();
    }
    @Override
    public void mCallBackData(String string) {
        Log.e("TAG","P层接收到了M成发送过来得数据了，准备刷新UI");
        iView.setData(string);
    }
}