package com.example.cloud.mypriatice.dagger2_test;

import dagger.Component;

/**
 * Created by Cloud on 2017/5/26.
 */
@Component (modules = InjectBeanModule.class)
public interface InjectBeanComponet {

    void inject(MyDagger2TestActivity activity);

}
