package com.example.cloud.mypriatice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.cloud.mypriatice.eventbus.EventBusOneActivity;
import com.example.cloud.mypriatice.okhttp.OkHttpDemoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button6, R.id.button7, R.id.button8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button6:
                startActivity(new Intent(this, CustomerViewActivity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(this, EventBusOneActivity.class));
                break;
            case R.id.button8:
                startActivity(new Intent(this, OkHttpDemoActivity.class));
                break;

        }
    }

}
