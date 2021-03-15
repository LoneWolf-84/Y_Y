package com.example.yy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class webviewF1 extends AppCompatActivity {
    static String url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(url);
        WebSettings webSettings = myWebView.getSettings();
        myWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new MyWebViewClient());

    }
    private class MyWebViewClient extends WebViewClient {
    }
    }
