package com.example.cloud.mypriatice.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cloud.mypriatice.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusTwoActivity extends AppCompatActivity {

    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.button11)
    Button button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_two);
        ButterKnife.bind(this);
        textView3.setText("TwoActivtiy");
        button9.setText("发送事件");
    }


    @OnClick({R.id.button9, R.id.button11})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button9:
                EventBus.getDefault().post(new MessageEvent("粘性小小"));
                finish();
                break;
            case R.id.button11:
                EventBus.getDefault().postSticky(new MessageEvent("粘性小小"));
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
