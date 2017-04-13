package com.example.cloud.mypriatice.mvp.presenter;

import com.example.cloud.mypriatice.mvp.interactor.LoginInteractor;
import com.example.cloud.mypriatice.mvp.interactor.LoginInteractorImpl;
import com.example.cloud.mypriatice.mvp.view.LoginView;

/**
 * Created by Cloud on 2017/4/13.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFisishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void checkInfo(String name, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(name, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.goToHome();
        }
    }
}
