package com.example.cloud.mypriatice.dagger2.module;

import com.example.cloud.mypriatice.dagger2.DaggerActivity;
import com.example.cloud.mypriatice.dagger2.DaggerPresenter;
import com.example.cloud.mypriatice.dagger2.bean.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Cloud on 2017/5/25.
 * <p>
 * 编写Module有以下几个注意点：
 * 类需要用@Module来标明注解
 * 这里有一点规则，用@Provides注解的函数需要以provide开头，然后后面接什么内容都可以，
 * 看自己喜欢，事实上，经过我的测试，我把provideActivity()改成provideA()同样是可以注入成功的，
 * 所以大家可以知道，这里是根据返回值类型来标识的，方法名并不重要，只需要保证以provide开头即可。
 */
@Module
//提供生成依赖对象 比如我要注入DaggerPresenter，那么这个Module的作用就是需要生成一个DaggerPresenter的对象，来让Dagger2注入到DaggerActivity中。
public class ActivityModule {
    private DaggerActivity activity;

    public ActivityModule(DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    public DaggerActivity provideActivity() {
        return activity;
    }

    @Provides
    public User provideUser() {
        return new User("user form ActivityModule ActivityModule ActivityModule");
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}
