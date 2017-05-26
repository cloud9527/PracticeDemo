package com.example.cloud.mypriatice.dagger2.component;

import com.example.cloud.mypriatice.dagger2.DaggerActivity;
import com.example.cloud.mypriatice.dagger2.module.ActivityModule;

import dagger.Component;

/**
 * Created by Cloud on 2017/5/25.
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}