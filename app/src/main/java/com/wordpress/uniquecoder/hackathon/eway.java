package com.wordpress.uniquecoder.hackathon;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class eway extends AppCompatActivity {

    public WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eway);
        setUIviews();
        WebSettings webSettings = web.getSettings();

        web.getSettings().setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new MyWebviewClient());
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        web.loadUrl("https://ewaybillgst.gov.in/login.aspx");

    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }
    private void setUIviews()
    {
        web=(WebView)findViewById(R.id.web);
    }

}