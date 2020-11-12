package com.wf.mn.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wf.mn.R;
import com.wf.mn.login.bean.RegiestBean;
import com.wf.mn.login.contract.RegiestContract;
import com.wf.mn.login.presenter.RegiestPresenter;
import com.wf.mvplibrary.base.BaseActivity;

public class RegiestActivity extends BaseActivity<RegiestPresenter> implements RegiestContract.IRegiestView, View.OnClickListener {


    private EditText password;
    private EditText confirmPassword;
    private EditText userName;
    private Button regButton;

    @Override
    public int getLayoutID() {
        return R.layout.activity_regiest;
    }
    @Override
    public void initView() {
          password = findViewById(R.id.reg_password);
          confirmPassword= findViewById(R.id.reg_confirm_password);
          userName= findViewById(R.id.reg_username);
          regButton= findViewById(R.id.reg_regbutton);
          regButton.setOnClickListener(this);
    }
    @Override
    public void initData() {
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg_regbutton:

                if(!TextUtils.isEmpty(getUserName())){

                    if (!TextUtils.isEmpty(getPassWord()) && !TextUtils.isEmpty(getConfirmPassWord())){

                        if(getPassWord().equals(getConfirmPassWord())){
                            //调用P层
                            presenter.getData(getUserName(),getPassWord());

                        }else {
                            Toast.makeText(this,R.string.Password_Dissimilarity,Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(this,R.string.PasswordNoNull,Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(this,R.string.UserNameNoNull,Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    @Override
    public String getUserName() {
        return userName.getText().toString().trim();
    }
    @Override
    public String getPassWord() {
        return password.getText().toString().trim();
    }
    @Override
    public String getConfirmPassWord() {
        return confirmPassword.getText().toString().trim();
    }

    @Override
    public void regiestSeccess(RegiestBean bean) {
        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
    }


}