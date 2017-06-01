package com.example.cloud.mypriatice.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Cloud on 2017/6/1.
 */

public interface GitApi {
    @GET("/users/{user}")
    Call<GitHubBean> getFeed(@Path("user") String user);
}
