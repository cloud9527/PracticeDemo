package com.example.cloud.mypriatice.dagger2;

import com.example.cloud.mypriatice.dagger2.bean.User;

/**
 * Created by Cloud on 2017/5/25.
 */

public class DaggerPresenter {
    DaggerActivity activity;
    User user;

    public DaggerPresenter(DaggerActivity activity, User user) {
        this.user = user;
        this.activity = activity;
    }

    public void showUserName() {
        activity.showUserName(user.name);
    }
}