package com.temp.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    WebView myview;
private static final  String PRIVACY_URL="https://apsurvey.herokuapp.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


  initWebView();
    }

void  initWebView(){
    myview = (WebView) findViewById(R.id.webView);
    HashMap<String,String > map=new HashMap<>();
    myview.getSettings().setDomStorageEnabled(true);
    myview.getSettings().setJavaScriptEnabled(true);
    myview.getSettings().setLoadWithOverviewMode(true);
    myview.getSettings().setUseWideViewPort(true);
    myview.getSettings().setAppCacheEnabled(true);
//        startCookie();
    if(!Notify.Link.isEmpty()){
        myview.loadUrl(Notify.Link, map);
    }else{
        myview.loadUrl(PRIVACY_URL, map);
    }



    myview.setWebViewClient(new WebViewClient(){

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    });

}

}