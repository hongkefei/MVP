package com.wf.mn.home.view;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wf.mn.R;
import com.wf.mn.home.contract.MainContract;
import com.wf.mn.home.presenter.MainPresenter;
import com.wf.mvplibrary.base.BaseActivity;
import com.wf.mvplibrary.utils.net.INetCallBack;
import com.wf.mvplibrary.utils.net.RetrofitUtils;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView {

    private Button myb ;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        myb = findViewById(R.id.mybt);

        myb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDate();
            }
        });
    }
    @Override
    public void initData() {

    }

    @Override
    public void setData(String string) {
        myb.setText(string);
        Toast.makeText(this,"当前请求结束:"+string,Toast.LENGTH_LONG).show();
    }
}