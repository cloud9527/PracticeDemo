package com.example.cloud.mypriatice.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cloud.mypriatice.R;
import com.example.cloud.mypriatice.mvp.interactor.FindItemsInteractorImpl;
import com.example.cloud.mypriatice.mvp.presenter.ListViewPresenterImpl;
import com.example.cloud.mypriatice.mvp.view.ListActivityView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVPListViewActivity extends AppCompatActivity implements ListActivityView, AdapterView.OnItemClickListener {

    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.progress)
    ProgressBar progress;
    private ListViewPresenterImpl listViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvplist_view);
        ButterKnife.bind(this);
        listViewPresenter = new ListViewPresenterImpl(this, new FindItemsInteractorImpl());
        list.setOnItemClickListener(this);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listViewPresenter.onItemClicked(position);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listViewPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listViewPresenter.onDestroy();
    }
}
