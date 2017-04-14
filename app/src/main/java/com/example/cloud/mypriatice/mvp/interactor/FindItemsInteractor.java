package com.example.cloud.mypriatice.mvp.interactor;

import java.util.List;

/**
 * Created by Cloud on 2017/4/14.
 */

public interface FindItemsInteractor {
    interface OnFinishedListener {
        void onFinished(List<String> item);
    }

    void findItems(OnFinishedListener onFinishedListener);
}
