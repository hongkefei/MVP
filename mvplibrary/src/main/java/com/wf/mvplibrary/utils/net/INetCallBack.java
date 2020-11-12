package com.wf.mvplibrary.utils.net;

/**
 * @author : wf
 * @time : 2020-11-10-20:44
 */
public interface INetCallBack<T> {

    public void  onSuccess(T t);

    public void onFailed(String error);

}
