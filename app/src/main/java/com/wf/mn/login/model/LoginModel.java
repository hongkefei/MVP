package com.wf.mn.login.model;

import com.wf.mn.login.contract.LoginContract;
import com.wf.mvplibrary.utils.net.INetCallBack;

import java.util.HashMap;

/**
 * @author : wf
 * @time : 2020-11-13-10:07
 */
public class LoginModel implements LoginContract.ILoginModel {
    @Override
    public <T> void getLoginResult(String url, HashMap<String, String> hashMap, INetCallBack<T> callBack) {

    }
}
