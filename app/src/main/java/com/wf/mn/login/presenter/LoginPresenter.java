package com.wf.mn.login.presenter;

import com.tencent.mmkv.MMKV;
import com.wf.mn.login.bean.RegiestBean;
import com.wf.mn.login.contract.LoginContract;
import com.wf.mvplibrary.base.BasePresenter;
import com.wf.mvplibrary.utils.MD5Utils;
import com.wf.mvplibrary.utils.net.INetCallBack;

import java.util.HashMap;

/**
 * @author : wf
 * @time : 2020-11-13-10:07
 */
public class LoginPresenter extends BasePresenter<LoginContract.ILoginView, LoginContract.ILoginModel> implements LoginContract.ILoginPresenter {
    @Override
    public void getLoginData(String userName, String password) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("username",userName);
        hashMap.put("password", MD5Utils.md5(password));

        iModel.getLoginResult("auth/login", hashMap, new INetCallBack<RegiestBean>() {
            @Override
            public void onSuccess(RegiestBean bean) {
                if(bean.getData().getCode() ==200){
                    iView.loginSeccess(bean);
                    MMKV mmkv = MMKV.defaultMMKV();
                    mmkv.encode("token",bean.getData().getToken());
                    mmkv.encode("uid",bean.getData().getUserInfo().getUid());
                    mmkv.encode("username",bean.getData().getUserInfo().getUsername());
                    mmkv.encode("nickname",bean.getData().getUserInfo().getNickname());
                }else{
                    iView.showErrorMessage(bean.getErrmsg());
                }
            }
            @Override
            public void onFailed(String error) {

            }
        });


    }

    @Override
    public LoginContract.ILoginModel setModel() {
        return null;
    }
}
