package com.yhealthinfo.yhealthinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivityWebWiew extends AppCompatActivity {

    WebView webView;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_web_wiew);
        webView = (WebView) findViewById(R.id.webwiew);
        Intent intent = getIntent();

        if (intent != null){
            bundle = intent.getExtras();
            if (bundle != null){
                webView.loadUrl(bundle.getString("url"));
            }
        }
    }


}