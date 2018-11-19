package com.sample.font;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "Android");
        webView.loadUrl("file:///android_asset/content.html");
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
