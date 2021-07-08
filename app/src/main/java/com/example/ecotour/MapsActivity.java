package com.example.ecotour;


import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.example.ecotour.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    protected GoogleMap mMap;
    protected ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    public void createMarker(LatLng position, String title){
        mMap.addMarker(new MarkerOptions().position(position).title(title).icon(BitmapDescriptorFactory.fromResource(R.drawable.arbolp)));
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
        //mMap.setOnInfoWindowClickListener(this);
        //mMap.setOnInfoWindowCloseListener(this);

        int contador = 0;
        String jsonFileContent = null;
        try {
            jsonFileContent = ReadJson.readJson(getApplicationContext(), "Reservas Naturales.json");
            JSONArray jsonArray = new JSONArray(jsonFileContent);

            for (int i=0;i<jsonArray.length();i++)
            {
                contador++;
                System.out.println(contador);

                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String title = jsonObj.getString("name");
                double latitude = jsonObj.getDouble("latitude");
                double longitude = jsonObj.getDouble("longitude");

                //Log.d("NOMBRE: ", title);
                System.out.println(longitude);
                System.out.println(latitude);

                LatLng marker = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(marker).title(title).icon(BitmapDescriptorFactory.fromResource(R.drawable.arbolp)));

                //persons.add(new Person(id , name , phone));
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        //List<Person> persons = new ArrayList<>();


        LatLng colombia = new LatLng(4.289789505201945, -74.20874620109208);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(colombia, 5.5f));



    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Toast.makeText(this,"Tero Covid" + marker.getPosition().latitude, Toast.LENGTH_LONG).show();

        //mMap.animateCamera(CameraUpdateFactory.zoomIn());
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 10));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(),9),1000, null);

        marker.showInfoWindow();
        //mMap.animateCamera(CameraUpdateFactory.zoomBy(10),3000, null);

        //mMap.animateCamera(CameraUpdateFactory.zoomBy(20),3000, null);

        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.0810,80.2740), 15.5f), 4000, null);

        return true;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5.5f),1000, null);
    }
}
