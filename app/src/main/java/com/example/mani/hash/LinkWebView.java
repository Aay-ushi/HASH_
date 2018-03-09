package com.example.mani.hash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class LinkWebView extends AppCompatActivity {

    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_web_view);

        mWebView = findViewById(R.id.webview);

        // Getting the Url
        Intent i = getIntent();
        String URL = i.getStringExtra("URL");

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(URL);




    }
}
