package com.example.cloud.mypriatice;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JSHtmlTwoActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebview;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jshtml);
        ButterKnife.bind(this);

        WebSettings settings = mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebview.setWebChromeClient(new WebChromeClient());
        mWebview.loadUrl("file:///android_asset/testTwo.html");
        mWebview.addJavascriptInterface(new JsInteration(), "control");

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                testMethod(mWebview);
            }
        });
    }

    private void testMethod(WebView webView) {
        String call = "javascript:sayHello()";
//        call = "javascript:alertMessage(\"" + "六级考试都放假" + "\")";
        call = "javascript:toastMessage(\"" + "content" + "\")";
//        call = "javascript:sumToJava(1,2)";
        webView.loadUrl(call);
    }


    public class JsInteration {
        @JavascriptInterface
        public void toastMessage(String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }

        @JavascriptInterface
        public void onSumResult(int result) {
            Toast.makeText(getApplicationContext(), "onSumResult" + result, Toast.LENGTH_LONG).show();
        }
    }
}
