package com.wf.mn.login.model;

import com.wf.mn.login.contract.RegiestContract;
import com.wf.mvplibrary.utils.net.INetCallBack;
import com.wf.mvplibrary.utils.net.RetrofitUtils;

import java.util.HashMap;

/**
 * @author : wf
 * @time : 2020-11-12-9:17
 */
public class RegiestModel implements RegiestContract.IRegiestModel {
    @Override
    public <T> void getRegiestResult(String url, HashMap<String, String> hashMap, INetCallBack<T> callBack) {

        RetrofitUtils.getInstance().postFromData(url,hashMap,callBack);

    }
}
