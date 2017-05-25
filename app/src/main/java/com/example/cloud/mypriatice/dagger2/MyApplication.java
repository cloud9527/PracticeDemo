package com.example.cloud.mypriatice.dagger2;

import android.support.multidex.MultiDexApplication;

import com.example.cloud.mypriatice.dagger2.component.AppComponent;
import com.example.cloud.mypriatice.dagger2.component.DaggerAppComponent;
import com.example.cloud.mypriatice.dagger2.module.ApiModule;


/**
 * Created by Cloud on 2017/5/25.
 */

public class MyApplication extends MultiDexApplication {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
