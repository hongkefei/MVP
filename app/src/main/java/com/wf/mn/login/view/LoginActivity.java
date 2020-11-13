package com.wf.mn.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wf.mn.R;
import com.wf.mn.home.view.MainActivity;
import com.wf.mn.login.bean.RegiestBean;
import com.wf.mn.login.contract.LoginContract;
import com.wf.mn.login.presenter.LoginPresenter;
import com.wf.mvplibrary.base.BaseActivity;

import org.w3c.dom.Text;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView , View.OnClickListener {


    private EditText login_username;
    private EditText login_password;
    private Button login_button;
    private Button reg_button;




    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
          login_username = findViewById(R.id.login_username);
          login_password = findViewById(R.id.login_password);
          login_button = findViewById(R.id.login_loginbutton);
          reg_button = findViewById(R.id.login_regbutton);

        login_button.setOnClickListener(this);
        reg_button.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public String getUserName() {
        return login_username.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return login_password.getText().toString().trim();
    }

    @Override
    public void loginSeccess(RegiestBean bean) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    @Override
    public void showErrorMessage(String errorString) {
        Intent it = new Intent(this, RegiestActivity.class);
        startActivity(it);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_loginbutton:
                
                if (!TextUtils.isEmpty(getUserName())){
                    if(!TextUtils.isEmpty(getPassWord())){
                        presenter.getLoginData(getUserName(),getPassWord());
                    }else {
                        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                
                
                
                break;
            case R.id.login_regbutton:
                Intent it = new Intent(this,RegiestActivity.class);
                startActivity(it);
                break;
        }
        
    }
}