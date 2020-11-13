package com.wf.mn.login.contract;

import com.wf.mn.login.bean.RegiestBean;
import com.wf.mvplibrary.base.BaseIView;
import com.wf.mvplibrary.base.BaseModel;
import com.wf.mvplibrary.utils.net.INetCallBack;

import java.util.HashMap;

/**
 * @author : wf
 * @time : 2020-11-12-9:08
 */
public class RegiestContract {

    public interface IRegiestView extends BaseIView {
        public String getUserName();
        public String getPassWord();
        public String getConfirmPassWord();
        public void regiestSeccess(RegiestBean bean);

        public void showErrorMessage(String errorString);

    }
    public interface IRegiestModel extends BaseModel {
        public <T> void getRegiestResult(String url, HashMap<String,String> hashMap, INetCallBack<T> callBack);
    }
    public interface IRegiestPresenter{
        public void getData(String userName,String password);
    }
}
