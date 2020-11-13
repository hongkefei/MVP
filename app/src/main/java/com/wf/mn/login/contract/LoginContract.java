package com.wf.mn.login.contract;

import com.wf.mn.login.bean.RegiestBean;
import com.wf.mvplibrary.base.BaseIView;
import com.wf.mvplibrary.base.BaseModel;
import com.wf.mvplibrary.utils.net.INetCallBack;

import java.util.HashMap;

/**
 * @author : wf
 * @time : 2020-11-13-10:07
 */
public class LoginContract {

    public interface ILoginView extends BaseIView {
        public String getUserName();
        public String getPassWord();
        public void loginSeccess(RegiestBean bean);

        public void showErrorMessage(String errorString);

    }
    public interface ILoginModel extends BaseModel {
        public <T> void getLoginResult(String url, HashMap<String,String> hashMap, INetCallBack<T> callBack);
    }
    public interface ILoginPresenter{
        public void getLoginData(String userName,String password);
    }

}
