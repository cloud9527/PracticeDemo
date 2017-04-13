package com.example.cloud.mypriatice.mvp.view;

/**
 * Created by Cloud on 2017/4/13.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void goToHome();
}
