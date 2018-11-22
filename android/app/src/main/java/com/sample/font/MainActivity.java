package com.sample.font;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOCAL_CONTENT_URL = "file:///android_asset/content.html";
    private static final String REMOTE_CONTENT_URL = "https://m-kann0.github.io/EmbeddedFontSample/index.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editUrl = findViewById(R.id.editUrl);

        findViewById(R.id.btnSetLocalUrl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUrl.setText(LOCAL_CONTENT_URL);
            }
        });

        findViewById(R.id.btnSetRemoteUrl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUrl.setText(REMOTE_CONTENT_URL);
            }
        });

        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editUrl.getText().toString();

                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.EXTRA_URL, url);
                startActivity(intent);
            }
        });
    }
}
