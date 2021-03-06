package com.example.cloud.mypriatice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cloud.mypriatice.algorithm.AlgorithmActivity;
import com.example.cloud.mypriatice.dagger2.DaggerActivity;
import com.example.cloud.mypriatice.eventbus.EventBusOneActivity;
import com.example.cloud.mypriatice.mvp.MVPLoginActivity;
import com.example.cloud.mypriatice.okhttp.OkHttpDemoActivity;
import com.example.cloud.mypriatice.retrofit.RetrofitDemoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.button10)
    Button mButton10;
    @BindView(R.id.button11)
    Button mButton11;
    @BindView(R.id.button12)
    Button mButton12;
    @BindView(R.id.button13)
    Button mButton13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textView4.setText(Html.fromHtml(getString(R.string.html_text)));
    }

    @OnClick({R.id.button6, R.id.button7, R.id.button8, R.id.button9
            , R.id.button10, R.id.button11, R.id.button12, R.id.button13})
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
            case R.id.button9:
                startActivity(new Intent(this, MVPLoginActivity.class));
                break;
            case R.id.button10:
                startActivity(new Intent(this, JSHtmlTwoActivity.class));
                break;
            case R.id.button11:
                startActivity(new Intent(this, DaggerActivity.class));
                break;
            case R.id.button12:
                startActivity(new Intent(this, AlgorithmActivity.class));
                break;
            case R.id.button13:
                startActivity(new Intent(this, RetrofitDemoActivity.class));
                break;

        }
    }

}
