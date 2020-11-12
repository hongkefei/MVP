package com.wf.mvplibrary.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;

/**
 * @author : wf
 * @time : 2020-11-10-9:09
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseIView{

    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initPs();
        initView();
        initData();
    }
//    模板模式
    public abstract int getLayoutID();
    public abstract void  initView();
    public abstract void initData();


    public void initPs(){
//通过反射获取泛型对象，并直接转成Class对象                               获取实体对象得携带参数       获取携带参数化类型得实际类型。得到class
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Log.e("TAG","当前type类型：");
        try {
//         通过反射得形式，直接创建对象
            presenter =    clazz.newInstance();
            Log.e("TAG","当前type类型："+presenter.getClass().getName());
            presenter.initViewModel(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }



}
