package com.example.cloud.mypriatice.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.cloud.mypriatice.R;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpDemoActivity extends AppCompatActivity {
    private final OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_demo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    method();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void method() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            Log.e("TAG", responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }
        Log.e("TAG", response.body().string());
    }
}
