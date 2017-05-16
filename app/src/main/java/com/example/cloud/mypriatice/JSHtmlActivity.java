package com.example.cloud.mypriatice;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JSHtmlActivity extends AppCompatActivity {

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
        mWebview.setWebChromeClient(new MyWebChromeClient());
        mWebview.loadUrl("file:///android_asset/test.html");
        mWebview.addJavascriptInterface(new DemoJavaScriptInterface(), "demo");
    }


    /**
     * Provides a hook for calling "alert" from javascript. Useful for
     * debugging your javascript.
     */
    final class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            result.confirm();
            return true;
        }
    }


    final class DemoJavaScriptInterface {
        DemoJavaScriptInterface() {
            Log.i("aaaa", "create DemoJavaScriptInterface");
        }

        /**
         * This is not called on the UI thread. Post a runnable to invoke
         * loadUrl on the UI thread.
         */
        @JavascriptInterface
        public void clickOnAndroid() {
            Toast.makeText(JSHtmlActivity.this, "clickOnAndroid", Toast.LENGTH_SHORT).show();


//            mHandler.post(new Runnable() {
//                public void run() {
//                    mWebview.loadUrl("javascript:wave()");
//                }
//            });
        }
    }
}
