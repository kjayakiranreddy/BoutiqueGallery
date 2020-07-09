package com.java.srisaimanchamworks;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactUsActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap myMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus_layout);
        SupportMapFragment supportMapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.location_frag);
        supportMapFragment.getMapAsync(ContactUsActivity.this);
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
                Intent galleryIntent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(galleryIntent);
                break;
            case R.id.contactusmenu:
                Message.toastMessage(ContactUsActivity.this, "Already in Contact Us");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;
        LatLng MyStoreLocation= new LatLng(13.572151, 78.498538);
        myMap.addMarker(new MarkerOptions().position(MyStoreLocation).title("Lakshmi Mancham Work"));
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MyStoreLocation, 19));
    }
}

