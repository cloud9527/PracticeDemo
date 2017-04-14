package com.example.cloud.mypriatice.mvp.presenter;

import com.example.cloud.mypriatice.mvp.interactor.FindItemsInteractor;
import com.example.cloud.mypriatice.mvp.view.ListActivityView;

import java.util.List;

/**
 * Created by Cloud on 2017/4/14.
 */

public class ListViewPresenterImpl implements ListViewPresenter, FindItemsInteractor.OnFinishedListener {
    private ListActivityView listActivityView;
    private FindItemsInteractor findItemsInteractor;

    public ListViewPresenterImpl(ListActivityView listActivityView, FindItemsInteractor findItemsInteractor) {
        this.listActivityView = listActivityView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {
        if (listActivityView != null) {
            listActivityView.showProgress();
        }
        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (listActivityView != null) {
            listActivityView.showMsg(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        listActivityView = null;
    }

    @Override
    public void onFinished(List<String> item) {
        if (listActivityView != null) {
            listActivityView.setItems(item);
            listActivityView.hideProgress();
        }
    }

    public ListActivityView getListActivityView() {
        return listActivityView;
    }
}
