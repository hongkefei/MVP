package com.wf.mvplibrary.utils.net;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * @author : wf
 * @time : 2020-11-10-20:39
 */
public interface MyApiService {

    @GET
    Observable<ResponseBody> getGet(@Url String url, @QueryMap HashMap<String,String> hashMap);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> getPost(@Url String url, @FieldMap HashMap<String,String> hashMap);

    @Multipart
    @POST
    Observable<ResponseBody> getPostFromData(@Url String url, @PartMap HashMap<String,RequestBody> hashMap);



}
