package com.example.cloud.mypriatice.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cloud.mypriatice.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusOneActivity extends AppCompatActivity {

    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.button10)
    Button button10;
    @BindView(R.id.activity_event_bus_one)
    RelativeLayout activityEventBusOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_one);
        ButterKnife.bind(this);
        textView2.setText("OneActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent) {
        textView2.setText(messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEvent(MessageEvent messageEvent) {
        textView2.setText(messageEvent.getMessage());
    }

    @OnClick({R.id.button8, R.id.button10})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button8:
                startActivity(new Intent(this, EventBusTwoActivity.class));
                break;
            case R.id.button10:
                EventBus.getDefault().register(this);
                break;
        }
    }
}
