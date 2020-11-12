package com.wf.mvplibrary.utils.net;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.wf.mvplibrary.app.BaseApplition;
import com.wf.mvplibrary.utils.ISNetUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author : wf
 * @time : 2020-11-10-15:22
 */
public class RetrofitUtils implements INetUtils {

    private static volatile RetrofitUtils retrofitUtils;


   private HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();


   //缓存拦截器
    private Interceptor cacheInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
//修改响应头，让ok帮助去做缓存
            Request request = chain.request();
//判断当前请求，网络是否可用，如果不可用，就使用缓存
            if(!ISNetUtils.isNetworkAvailable(BaseApplition.baseApplition.getApplicationContext())){
//如果没有网络，需要修改你的网络请求方向----直接return   表示网络请求以当前方式继续继续
                request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
//            让请求继续
            Response response = chain.proceed(request);

//            有网络的请求下，和无网络情况下，进行分别设置，
            if(ISNetUtils.isNetworkAvailable(BaseApplition.baseApplition.getApplicationContext())){
//有网络的情况下，设置缓存时间未300秒
                String cachecontrol = request.cacheControl().toString();
                if(TextUtils.isEmpty(cachecontrol)){
                    cachecontrol = "public, max-age=300";
                }
//            重新构建请求头部，修改header，添加缓存头信息，让ok帮缓存
                return response
                        .newBuilder()
                        .header("Cache-Control",cachecontrol)
                        .removeHeader("Pragma")
                        .build();
            }else{
//无网络情况下，设置  ，缓存时间为100天
                String cachecontrol = request.cacheControl().toString();
                if(TextUtils.isEmpty(cachecontrol)){
                    cachecontrol = "public,only-if-cached, max-stale="+(60*60*24*100);
                }
//            重新构建请求头部，修改header，添加缓存头信息，让ok帮缓存
                return response
                        .newBuilder()
                        .header("Cache-Control",cachecontrol)
                        .removeHeader("Pragma")
                        .build();
            }

        }
    };
    private final MyApiService myApiService;


    private RetrofitUtils() {
//        日志拦截器
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        设置缓存目录
        File file = new File(BaseApplition.baseApplition.getApplicationContext().getCacheDir(),"res");
//          设置缓存大小
        Cache cache = new Cache(file,1020*10240);

        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstant.BASEURL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        myApiService = retrofit.create(MyApiService.class);

    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils == null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

//文件下载  ，上传
    @Override
    public <T> void get(String url, HashMap<String, String> map, final INetCallBack<T> callBack) {

        if (null == map){
            map = new HashMap<>();
        }
        myApiService.getGet(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
//                转换
                .map(new Function<ResponseBody, ResponseBody>() {
                    @Override
                    public ResponseBody apply(ResponseBody body) throws Exception {
//                        类型转换
//                        此处将你的结果，进行修改，修改完以后，返回你想要的最终结果，String类型，也可能是别的类型
                        return body;
                    }
                }).subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseBody body) {
                        try {
                            String result = body.string();

                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                           Type type =  actualTypeArguments[0];

                            Gson gson = new Gson();

                            T t = gson.fromJson(result,type);

                            callBack.onSuccess(t);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailed(e.toString());
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, final INetCallBack<T> callBack) {

        if (null == map){
            map = new HashMap<>();
        }

        myApiService.getPost(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
//                转换
                .map(new Function<ResponseBody, ResponseBody>() {
                    @Override
                    public ResponseBody apply(ResponseBody body) throws Exception {
//                        类型转换
//                        此处将你的结果，进行修改，修改完以后，返回你想要的最终结果，String类型，也可能是别的类型
                        return body;
                    }
                }).subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(ResponseBody body) {
                try {
                    String result = body.string();

                    Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                    Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                    Type type =  actualTypeArguments[0];

                    Gson gson = new Gson();

                    T t = gson.fromJson(result,type);

                    callBack.onSuccess(t);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(Throwable e) {
                callBack.onFailed(e.toString());
            }
            @Override
            public void onComplete() {
            }
        });
    }



    @Override
    public <T> void postFromData(String url, HashMap<String, String> map, final INetCallBack<T> callBack) {

        if (null == map){
            map = new HashMap<>();
        }

        myApiService.getPostFromData(url,generateRequestBody(map))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
//                转换
                .map(new Function<ResponseBody, ResponseBody>() {
                    @Override
                    public ResponseBody apply(ResponseBody body) throws Exception {
//                        类型转换
//                        此处将你的结果，进行修改，修改完以后，返回你想要的最终结果，String类型，也可能是别的类型
                        return body;
                    }
                }).subscribe(new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(ResponseBody body) {
                try {
                    String result = body.string();

                    Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();

                    Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                    Type type =  actualTypeArguments[0];

                    Gson gson = new Gson();

                    T t = gson.fromJson(result,type);

                    callBack.onSuccess(t);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(Throwable e) {
                callBack.onFailed(e.toString());
            }
            @Override
            public void onComplete() {
            }
        });
    }



    /**
     * 转换为 form-data
     * @param requestDataMap
     * @return
     */
    public static HashMap<String, RequestBody> generateRequestBody(Map<String, String> requestDataMap) {
        HashMap<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : requestDataMap.keySet()) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),
                    requestDataMap.get(key) == null ? "" : requestDataMap.get(key));
            requestBodyMap.put(key, requestBody);
        }
        return requestBodyMap;
    }

}
