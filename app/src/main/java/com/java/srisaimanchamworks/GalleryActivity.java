package com.java.srisaimanchamworks;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    private WebView webViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webViewHome = findViewById(R.id.wv_home);
        webViewHome.loadUrl(getString(R.string.googledriveshareurl));
        webViewHome.setWebViewClient(new client());
        WebSettings webSettings = webViewHome.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewHome.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewHome.clearCache(true);
        webViewHome.clearHistory();

   /*     webViewHome.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                DownloadManager.Request request= new DownloadManager.Request(Uri.parse(url));
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
                Message.toastMessage(getApplicationContext(),"Downloading .....");
            }
    });*/
    }

    private class client extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homemenu:
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.gallerymenu:
                Message.toastMessage(GalleryActivity.this, "Already in Gallery");
                break;
            case R.id.contactusmenu:
                Intent contactUsIntent = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(contactUsIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


