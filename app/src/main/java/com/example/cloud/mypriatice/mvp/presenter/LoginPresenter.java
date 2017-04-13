package com.example.cloud.mypriatice.mvp.presenter;

/**
 * Created by Cloud on 2017/4/13.
 */

public interface LoginPresenter {
    void checkInfo(String name, String password);

    void onDestroy();
}
