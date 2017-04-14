package com.example.cloud.mypriatice.mvp.interactor;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cloud on 2017/4/14.
 */

public class FindItemsInteractorImpl implements FindItemsInteractor {
    @Override
    public void findItems(final OnFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onFinished(createArrayList());
            }
        }, 1000);
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10",
                "Item 8",
                "Item 9",
                "Item 10",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}
