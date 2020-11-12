package com.wf.mvplibrary.utils.net;

import com.wf.mvplibrary.utils.net.INetCallBack;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * @author : wf
 * @time : 2020-11-10-15:22
 */
public interface INetUtils {
    /**
     *
     * @param url
     * @param map  有值就传，无就空
     * @param callBack
     * @param <T>
     */
    <T> void get(String url, HashMap<String,String> map, INetCallBack<T> callBack);
    <T> void post(String url, HashMap<String,String> map,INetCallBack<T> callBack);
    <T> void postFromData(String url, HashMap<String, String> map, INetCallBack<T> callBack);
}
