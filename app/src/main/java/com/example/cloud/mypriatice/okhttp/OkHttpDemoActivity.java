package com.example.cloud.mypriatice.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.cloud.mypriatice.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpDemoActivity extends AppCompatActivity {
    private final OkHttpClient okHttpClient = new OkHttpClient();
    @BindView(R.id.textView6)
    TextView mTextView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_demo);
        ButterKnife.bind(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getDemo();
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

    public void method2() throws Exception {
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/square/okhttp/issues")
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        System.out.println("Server: " + response.header("Server"));
        System.out.println("Date: " + response.header("Date"));
        System.out.println("Vary: " + response.headers("Vary"));
    }

    //get方法演示
    private void getDemo() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request builder = new Request.Builder().url("https://github.com/hongyangAndroid").build();
        Call call = okHttpClient.newCall(builder);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //此方法在子线程中运行
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().toString();
                Log.e("TAG", s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextView6.setText(s);
                    }
                });
            }
        });
    }
}
