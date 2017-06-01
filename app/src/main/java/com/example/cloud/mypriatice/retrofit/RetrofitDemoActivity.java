package com.example.cloud.mypriatice.retrofit;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cloud.mypriatice.R;
import com.example.cloud.mypriatice.retrofit.other.Contributor;
import com.example.cloud.mypriatice.retrofit.other.GitHubContributorApi;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDemoActivity extends AppCompatActivity {

    @BindView(R.id.button13)
    Button mButton13;
    @BindView(R.id.textView7)
    TextView mTextView7;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    String API = "https://api.github.com"; //base url
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
//                    Response<List<Contributor>> execute = (Response<List<Contributor>>) msg.obj;
                    Response<GitHubBean> obj = (Response<GitHubBean>) msg.obj;
                    GitHubBean body = obj.body();
                    mTextView7.setText(body.toString());
                    mProgressBar.setVisibility(View.GONE);
                    break;
            }
            return false;
        }
    });
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_demo);
        ButterKnife.bind(this);
        mProgressBar.setVisibility(View.GONE);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
    }

    @OnClick(R.id.button13)
    public void onClick() {
        mProgressBar.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = getGitApi();
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = response;
                    mHandler.sendMessage(obtain);

                } catch (IOException e) {
                    e.printStackTrace();
                }

//                getGitApi();

            }
        }).start();


    }

    private Response getContributor() throws IOException {

        GitHubContributorApi gitHubService = mRetrofit.create(GitHubContributorApi.class);
        Call<List<Contributor>> call = gitHubService.contributors("cloud9527", "PracticeDemo");
        Response<List<Contributor>> execute = call.execute();
        return execute;
    }

    private Response getGitApi() throws IOException {
        GitApi gitApi = mRetrofit.create(GitApi.class);
        Call<GitHubBean> google = gitApi.getFeed("google");
        Response<GitHubBean> execute = google.execute();
        return execute;
    }

}
