package com.example.cloud.mypriatice.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.cloud.mypriatice.R;
import com.example.cloud.mypriatice.dagger2.component.DaggerActivityComponent;
import com.example.cloud.mypriatice.dagger2.module.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaggerActivity extends AppCompatActivity {
    private static final String TAG = "DaggerActivity";
    @BindView(R.id.textView5)
    TextView mTextView5;

    @Inject
    DaggerPresenter mDaggerPresenter;

//    @Inject
//    OkHttpClient mOkHttpClient;
//
//    @Inject
//    Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ButterKnife.bind(this);
        inject();
        mDaggerPresenter.showUserName();
//        Log.e(TAG, "client = " + (mOkHttpClient == null ? "null" : mOkHttpClient));
//        Log.e(TAG, "retrofit = " + (mRetrofit == null ? "null" : mRetrofit));
    }

    private void inject() {
//        MyApplication myApplication = (MyApplication) getApplication();
//        AppComponent appComponent = myApplication.getAppComponent();
//
//        DaggerActivityComponent.builder().appComponent(appComponent).activityModule(new ActivityModule(this)).build().inject(this);

        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);

    }

    public void showUserName(String name) {
        mTextView5.setText(name);
    }
}
