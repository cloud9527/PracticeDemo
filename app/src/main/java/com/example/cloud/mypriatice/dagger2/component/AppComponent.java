package com.example.cloud.mypriatice.dagger2.component;

import com.example.cloud.mypriatice.dagger2.module.ApiModule;
import com.example.cloud.mypriatice.dagger2.bean.User;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Cloud on 2017/5/25.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface AppComponent {

    OkHttpClient getOkHttpClient();

    Retrofit getRetroFit();

    User getUser();
}
