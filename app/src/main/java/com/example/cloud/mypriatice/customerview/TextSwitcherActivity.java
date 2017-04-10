package com.example.cloud.mypriatice.customerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.cloud.mypriatice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextSwitcherActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.text_switcher)
    TextSwitcher textSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);
        ButterKnife.bind(this);

        textSwitcher.setFactory(viewFactory);
        Animation in = AnimationUtils.loadAnimation(this, R.anim.bottom_in);
        Animation out = AnimationUtils.loadAnimation(this, R.anim.top_out);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);
        textSwitcher.setCurrentText("0");
    }

    int mCount = 1;

    @OnClick(R.id.button)
    public void onViewClicked() {
        mCount++;
        textSwitcher.setText(String.valueOf(mCount));
    }

    ViewSwitcher.ViewFactory viewFactory = new ViewSwitcher.ViewFactory() {
        @Override
        public View makeView() {
            TextView textView = new TextView(TextSwitcherActivity.this);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            textView.setTextSize(50);
            return textView;

        }
    };
}
