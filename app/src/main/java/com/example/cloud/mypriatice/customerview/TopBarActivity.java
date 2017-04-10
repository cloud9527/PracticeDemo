package com.example.cloud.mypriatice.customerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.cloud.mypriatice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopBarActivity extends AppCompatActivity {

    @BindView(R.id.topbar)
    TopBar topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar);
        ButterKnife.bind(this);
        topbar.setButtonVisable(1, false);
        topbar.setTopBarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(TopBarActivity.this, "left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(TopBarActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
