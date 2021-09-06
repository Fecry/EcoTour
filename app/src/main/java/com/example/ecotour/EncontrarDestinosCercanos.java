package com.example.ecotour;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public abstract class EncontrarDestinosCercanos extends Context implements ActivityCompat.OnRequestPermissionsResultCallback {

    double userLatitude = 0.0;
    double userLongitude = 0.0;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {



        } else {
            // Permission to access the location is missing. Show rationale and request permission
            //PermissionUtils.requestPermission(getApplicationContext(), LOCATION_PERMISSION_REQUEST_CODE, Manifest.permission.ACCESS_FINE_LOCATION, true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults, Manifest.permission.ACCESS_FINE_LOCATION)) {
            enableMyLocation();
        } else {
            // Permission was denied. Display an error message
            // Display the missing permission error dialog when the fragments resume.
            //permissionDenied = true;
        }
    }

    private void updateLocation(Location location) {
        if (location != null) {
            userLatitude = location.getLatitude();
            userLongitude = location.getLongitude();
            LatLng user = new LatLng(userLatitude, userLongitude);


        }
    }

    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            updateLocation(location);
        }
    };

    private void userUbication() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateLocation(location);
    }

    private void destinosCerca(double latitude, double longitude){
        String jsonFileContent = null;



        try {
            jsonFileContent = ReadJson.readJson(getApplicationContext(), "Reservas Naturales.json");
            JSONArray jsonArray = new JSONArray(jsonFileContent);
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String title = jsonObj.getString("name");

                double parqueLatitude = jsonObj.getDouble("latitude");
                double parqueLongitude = jsonObj.getDouble("longitude");



            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        //square((y2-y)^2 + (x2-x1)^2)
    }



}
