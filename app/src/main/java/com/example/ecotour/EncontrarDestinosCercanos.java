package com.example.ecotour;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public abstract class EncontrarDestinosCercanos extends Context implements ActivityCompat.OnRequestPermissionsResultCallback{

    double userLatitude = 0.0;
    double userLongitude = 0.0;



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
