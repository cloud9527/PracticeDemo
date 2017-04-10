package com.example.cloud.mypriatice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.cloud.mypriatice.customerview.CircleProgressViewActivity;
import com.example.cloud.mypriatice.customerview.MyScrollActivity;
import com.example.cloud.mypriatice.customerview.TextSwitcherActivity;
import com.example.cloud.mypriatice.customerview.TopBarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomerViewActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.activity_customer_view)
    RelativeLayout activityCustomerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(new Intent(this, CircleProgressViewActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, TopBarActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, MyScrollActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, TextSwitcherActivity.class));
                break;
            case R.id.button5:
                break;
        }
    }
}
