package com.sample.font;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    public static final String EXTRA_URL = "com.sample.font.WebViewActivity.URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra(EXTRA_URL);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl(url);
    }
}
