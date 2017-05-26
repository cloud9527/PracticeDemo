package com.example.cloud.mypriatice.dagger2_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.cloud.mypriatice.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDagger2TestActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView mTextView;
    @Inject
    InjectBean mInjectBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dagger2_test);
        ButterKnife.bind(this);
        inject();
        mTextView.setText(mInjectBean.getName() + mInjectBean.getAddress());
    }

    private void inject() {
        DaggerInjectBeanComponet.builder().build().inject(this);
    }
}
