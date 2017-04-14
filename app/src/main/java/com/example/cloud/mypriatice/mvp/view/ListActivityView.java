package com.example.cloud.mypriatice.mvp.view;

import java.util.List;

/**
 * Created by Cloud on 2017/4/14.
 */

public interface ListActivityView {
    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMsg(String msg);
}
