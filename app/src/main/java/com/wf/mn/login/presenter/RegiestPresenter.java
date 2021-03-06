package com.wf.mn.login.presenter;

import android.widget.Toast;

import com.tencent.mmkv.MMKV;
import com.wf.mn.login.bean.RegiestBean;
import com.wf.mn.login.contract.RegiestContract;
import com.wf.mn.login.model.RegiestModel;
import com.wf.mn.url.AppUrlConstant;
import com.wf.mvplibrary.base.BasePresenter;
import com.wf.mvplibrary.utils.MD5Utils;
import com.wf.mvplibrary.utils.net.INetCallBack;

import java.util.HashMap;

/**
 * @author : wf
 * @time : 2020-11-12-9:09
 */
public class RegiestPresenter extends BasePresenter<RegiestContract.IRegiestView, RegiestContract.IRegiestModel> implements RegiestContract.IRegiestPresenter {

    @Override
    public RegiestContract.IRegiestModel setModel() {
        return new RegiestModel();
    }

    @Override
    public void getData(String userName, String password) {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("username",userName);
        hashMap.put("password", MD5Utils.md5(password));

        iModel.getRegiestResult(AppUrlConstant.REGIEST, hashMap, new INetCallBack<RegiestBean>() {
            @Override
            public void onSuccess(RegiestBean s) {
                if(s.getErrno()==0){
                    iView.regiestSeccess(s);

                    MMKV mmkv = MMKV.defaultMMKV();
                    mmkv.encode("token",s.getData().getToken());
                    mmkv.encode("uid",s.getData().getUserInfo().getUid());
                    mmkv.encode("username",s.getData().getUserInfo().getUsername());
                    mmkv.encode("nickname",s.getData().getUserInfo().getNickname());

                }else {
                    iView.showErrorMessage(s.getErrmsg());
                }


//                保存信息。跳转首页
//                  跳转
            }
            @Override
            public void onFailed(String error) {
            }
        });
    }
}