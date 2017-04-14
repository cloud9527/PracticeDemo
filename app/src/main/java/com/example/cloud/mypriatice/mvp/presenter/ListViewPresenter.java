package com.example.cloud.mypriatice.mvp.presenter;

/**
 * Created by Cloud on 2017/4/14.
 */

public interface ListViewPresenter {
    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
