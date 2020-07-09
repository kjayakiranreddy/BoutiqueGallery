package com.java.srisaimanchamworks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button galleryBtn;
    private Button contactUsBtn;
    private ImageButton youtubeBtn;
    private ImageButton websiteBtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        galleryBtn= (Button)findViewById(R.id.gallery_btn);
        contactUsBtn=(Button)findViewById(R.id.contactus_btn);
        youtubeBtn=(ImageButton)findViewById(R.id.youtube_btn);
        websiteBtn=(ImageButton)findViewById(R.id.website_btn);


        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(galleryIntent);
            }
        });
        contactUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactUsIntent = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(contactUsIntent);
            }
        });

        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = "com.google.android.youtube";
                String youtubeUrl = getString(R.string.youtubeurl);
                boolean isYoutubeInstalled = isAppInstalled(packageName);
                if(isYoutubeInstalled){
                    Intent youtubeIntent = new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setData(Uri.parse(youtubeUrl));
                    youtubeIntent.setPackage("com.google.android.youtube");
                    startActivity(youtubeIntent);
                }
                else{
                    Uri youtubeLink = Uri.parse(youtubeUrl);
                    Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, youtubeLink);
                    startActivity(youtubeIntent);
                }

            }

        });

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri websiteLink = Uri.parse(getString(R.string.websiteurl));
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, websiteLink);
                startActivity(websiteIntent);
            }
        });

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
                Message.toastMessage(MainActivity.this, "Already in Home");
                break;
            case R.id.gallerymenu:
                Intent galleryIntent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(galleryIntent);
                break;
            case R.id.contactusmenu:
                Intent contactUsIntent = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(contactUsIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected boolean isAppInstalled(String packageName) {
        Intent mIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (mIntent != null) {
            return true;
        }
        else {
            return false;
        }
    }
}

