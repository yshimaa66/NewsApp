package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.Model.ArticlesItem;

import java.util.List;

public class ArticleBody extends AppCompatActivity {

    public ProgressBar progressBar;

    public WebView webView;

    public String url = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_article_body);




        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progress_bar);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progressBar.setVisibility(View.VISIBLE);
                view.loadUrl(url);

                return true;
            }

            @Override
            public void onPageFinished(WebView view, final String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        webView.loadUrl(url);

        // Toast.makeText(this, position, Toast.LENGTH_SHORT).show();



    }






}
