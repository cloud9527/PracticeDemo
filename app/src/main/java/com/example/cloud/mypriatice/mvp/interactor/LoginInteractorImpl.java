package com.example.cloud.mypriatice.mvp.interactor;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Cloud on 2017/4/13.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String name, final String password, final OnLoginFisishedListener onLoginFisishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = true;
                if (TextUtils.isEmpty(name)) {
                    onLoginFisishedListener.onUsernameError();
                    error = false;
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    onLoginFisishedListener.onPasswordError();
                    error = false;
                    return;
                }
                if (error) {
                    onLoginFisishedListener.onSuccess();
                }
            }
        }, 2000);
    }
}
