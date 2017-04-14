package com.example.cloud.mypriatice.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.cloud.mypriatice.R;
import com.example.cloud.mypriatice.mvp.presenter.LoginPresenterImpl;
import com.example.cloud.mypriatice.mvp.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVPLoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.progress)
    ProgressBar progress;
    private LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvplogin);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        loginPresenter.checkInfo(username.getText().toString(), password.getText().toString());
    }


    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void goToHome() {
        hideProgress();
        startActivity(new Intent(this, MVPListViewActivity.class));
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }
}
