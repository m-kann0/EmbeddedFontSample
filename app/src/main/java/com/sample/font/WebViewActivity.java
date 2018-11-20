package com.sample.font;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebViewActivity extends AppCompatActivity {

    public static final String EXTRA_URL = "com.sample.font.WebViewActivity.URL";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra(EXTRA_URL);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "Android");
        webView.loadUrl(url);
    }

    @JavascriptInterface
    public void transferFontData(final String[] args) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    String base64 = readAssetString(getAssets(), "rounded-mplus-1c-regular.woff2.base64");
                    String script = "window.setBase64FontData('" + base64 + "');";

                    webView.evaluateJavascript(script, null);
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
    }

    private static String readAssetString(AssetManager asset, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(asset.open(fileName)))) {
            StringBuilder builder = new StringBuilder();

            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }

            return builder.toString();
        }
    }
}
