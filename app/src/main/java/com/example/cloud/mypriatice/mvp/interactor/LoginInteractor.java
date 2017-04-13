package com.example.cloud.mypriatice.mvp.interactor;

/**
 * Created by Cloud on 2017/4/13.
 */

public interface LoginInteractor {
    interface OnLoginFisishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String name, String password, OnLoginFisishedListener onLoginFisishedListener);
}
