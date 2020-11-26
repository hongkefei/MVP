package com.wf.mn.home.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.wf.mn.R;
import com.wf.mn.home.contract.MainContract;
import com.wf.mn.home.presenter.MainPresenter;
import com.wf.mvplibrary.base.BaseActivity;
import com.wf.mvplibrary.utils.net.INetCallBack;
import com.wf.mvplibrary.utils.net.RetrofitUtils;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView {

    private Button myb ;

    private RecyclerView recyclerView;


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);


//        int
//Integer

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

//        第一步骤，先和VirtualLayoutManager绑定
//        控件
        recyclerView = findViewById(R.id.testrecy);
//          布局管理器
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);


//        第二步骤：
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0,10);



//      管理器有了，并设置属性---第一行
        SingleLayoutHelper helper = new SingleLayoutHelper();
        helper.setItemCount(1);
        helper.setPadding(10,10,10,10);
        helper.setMargin(10,10,10,10);
        helper.setBgColor(R.color.colorPrimary);
        MyAdapter myAdapter = new MyAdapter(helper);
//创建适配器，具体布局适配器


//第二行
        SingleLayoutHelper bannerHelper = new SingleLayoutHelper();
//        bannerHelper.setItemCount(1);
        bannerHelper.setPadding(10,10,10,10);
        bannerHelper    .setMargin(10,10,10,10);
        bannerHelper.setBgColor(R.color.colorAccent);
        BannerAdapter bannerAdapter = new BannerAdapter(bannerHelper);

//        第三行
        ColumnLayoutHelper  typehelper = new ColumnLayoutHelper();
        typehelper.setItemCount(5);
        typehelper.setWeights(new float[]{100});
        typehelper.setMargin(10,10,10,10);
        typehelper.setPadding(10,0,10,0);
        TypeColumnAdapter typeColumnAdapter = new TypeColumnAdapter(typehelper);





//将适配器装入到集合里面
        List<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        adapters.add(myAdapter);
        adapters.add(bannerAdapter);
        adapters.add(typeColumnAdapter);

        DelegateAdapter adapter = new DelegateAdapter(layoutManager);
        adapter.setAdapters(adapters);


        recyclerView.setAdapter(adapter);









//        helper.setDividerHeight(10);







        /*myb = findViewById(R.id.mybt);

        myb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDate();
            }
        });*/
    }
    @Override
    public void initData() {

    }

    @Override
    public void setData(String string) {
      /*  myb.setText(string);
        Toast.makeText(this,"当前请求结束:"+string,Toast.LENGTH_LONG).show();*/
    }
}