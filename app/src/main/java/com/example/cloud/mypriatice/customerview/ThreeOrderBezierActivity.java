package com.example.cloud.mypriatice.customerview;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.cloud.mypriatice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThreeOrderBezierActivity extends AppCompatActivity {

    @BindView(R.id.three_bezier_view)
    ThreeOrderBezierView mThreeBezierView;
    @BindView(R.id.radio1)
    RadioButton mRadio1;
    @BindView(R.id.radio2)
    RadioButton mRadio2;
    @BindView(R.id.rg)
    RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_order_bezier);
        ButterKnife.bind(this);
        mRadio1.setChecked(true);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (mRadio1.isChecked()) {
                    mThreeBezierView.setMode(true);
                }else{
                    mThreeBezierView.setMode(false);
                }
            }
        });
    }
}
