package com.example.cloud.mypriatice.dagger2_test;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Cloud on 2017/5/26.
 */
@Module
public class InjectBeanModule {

    @Provides
    InjectBean provideInjectBean() {
        return new InjectBean("new InjectBean","adddd");

    }
}
