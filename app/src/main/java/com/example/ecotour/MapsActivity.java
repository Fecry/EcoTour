package com.example.ecotour;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ecotour.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener, GoogleMap.OnMyLocationButtonClickListener, ActivityCompat.OnRequestPermissionsResultCallback {

    protected GoogleMap mMap;
    protected ActivityMapsBinding binding;

    double userLatitude = 0.0;
    double userLongitude = 0.0;
    double lastMarkerLatitude = 0.0;
    double lastMarkerLongitude = 0.0;
    String distance = "";
    String duration = "";

    Polyline ruta = null;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    JsonObjectRequest jsonObjectRequest;
    RequestQueue request;


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


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;


        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
        mMap.setOnMyLocationButtonClickListener(this);

        //mMap.setOnInfoWindowClickListener(this);
        //mMap.setOnInfoWindowCloseListener(this);


        int contador = 0;
        String jsonFileContent = null;
        try {
            jsonFileContent = ReadJson.readJson(getApplicationContext(), "Reservas Naturales.json");
            JSONArray jsonArray = new JSONArray(jsonFileContent);

            for (int i = 0; i < jsonArray.length(); i++) {
                contador++;
                System.out.println(contador);

                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String title = jsonObj.getString("name");
                //String snipet = jsonObj.getString("snipet");
                double latitude = jsonObj.getDouble("latitude");
                double longitude = jsonObj.getDouble("longitude");


                //Log.d("NOMBRE: ", title);
                System.out.println(longitude);
                System.out.println(latitude);

                LatLng marker = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(marker).title(title).icon(BitmapDescriptorFactory.fromResource(R.drawable.arbol)));


            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }


        LatLng colombia = new LatLng(4.289789505201945, -74.20874620109208);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(colombia, 5.5f));

        enableMyLocation();


    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);

                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                userLatitude = location.getLatitude();
                userLongitude = location.getLongitude();
            }
        } else {
            // Permission to access the location is missing. Show rationale and request permission
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE, Manifest.permission.ACCESS_FINE_LOCATION, true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
            LatLng marker = new LatLng(userLatitude, userLongitude);
            //mMap.addMarker(new MarkerOptions().position(marker).title("Mi Posición Actual"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 8), 1000, null);

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




    private void webServiceObtenerRuta(String latitudInicial, String longitudInicial, String latitudFinal, String longitudFinal) {

        //String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + latitudInicial + "," + longitudInicial+ "&destination=" + latitudFinal + "," + longitudFinal;

        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + latitudInicial + "," + longitudInicial + "&destination=" + latitudFinal + "," + longitudFinal + "+&key=AIzaSyDrxuUQyR0gCYzbwZ0he7qD70aPAv5YqIM";

        System.out.println("URL " + url);

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Este método PARSEA el JSONObject que retorna del API de Rutas de Google devolviendo
                //una lista del lista de HashMap Strings con el listado de Coordenadas de Lat y Long,
                //con la cual se podrá dibujar pollinas que describan la ruta entre 2 puntos.
                JSONArray jRoutes = null;
                JSONArray jLegs = null;
                JSONArray jSteps = null;
                JSONArray jDistance = null;
                JSONArray jDuration = null;

                System.out.println("Resultado " + response);

                try {

                    jRoutes = response.getJSONArray("routes");

                    /** Traversing all routes */
                    for (int i = 0; i < jRoutes.length(); i++) {
                        jLegs = ((JSONObject) jRoutes.get(i)).getJSONArray("legs");
                        List<HashMap<String, String>> path = new ArrayList<HashMap<String, String>>();

                        distance = (String) ((JSONObject) ((JSONObject) jLegs.get(0)).get("distance")).get("text");
                        duration = (String) ((JSONObject) ((JSONObject) jLegs.get(0)).get("duration")).get("text");


                        /** Traversing all legs */
                        for (int j = 0; j < jLegs.length(); j++) {
                            jSteps = ((JSONObject) jLegs.get(j)).getJSONArray("steps");


                            /** Traversing all steps */
                            for (int k = 0; k < jSteps.length(); k++) {
                                String polyline = "";
                                polyline = (String) ((JSONObject) ((JSONObject) jSteps.get(k)).get("polyline")).get("points");
                                List<LatLng> list = decodePoly(polyline);

                                /** Traversing all points */
                                for (int l = 0; l < list.size(); l++) {
                                    HashMap<String, String> hm = new HashMap<String, String>();
                                    hm.put("lat", Double.toString(((LatLng) list.get(l)).latitude));
                                    hm.put("lng", Double.toString(((LatLng) list.get(l)).longitude));
                                    path.add(hm);
                                }
                            }
                            ReadJson.routes.add(path);
                        }
                    }
                    System.out.println("Llego aca la primera");
                    cosasdeeso();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println();
                Log.d("ERROR: ", error.toString());
            }
        }
        );


        request.add(jsonObjectRequest);

    }

    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }


    public void cosasdeeso() {

        System.out.println("Si llego2");

        ArrayList<LatLng> points = new ArrayList<LatLng>();;
        PolylineOptions lineOptions = new PolylineOptions();;
        if(ruta != null){
            ruta.remove();
        }
        LatLng center = new LatLng(0, 0);

        // setUpMapIfNeeded();

        // recorriendo todas las rutas
        for (int i = 0; i < ReadJson.routes.size(); i++) {
            points = new ArrayList<LatLng>();
            lineOptions = new PolylineOptions();

            // Obteniendo el detalle de la ruta
            List<HashMap<String, String>> path = ReadJson.routes.get(i);

            // Obteniendo todos los puntos y/o coordenadas de la ruta
            for (int j = 0; j < path.size(); j++) {
                HashMap<String, String> point = path.get(j);

                double lat = Double.parseDouble(point.get("lat"));
                double lng = Double.parseDouble(point.get("lng"));
                LatLng position = new LatLng(lat, lng);


                center = new LatLng(lat, lng);

                points.add(position);
            }

            // Agregamos todos los puntos en la ruta al objeto LineOptions
            lineOptions.addAll(points);
            //Definimos el grosor de las Polilíneas
            lineOptions.width(10);
            //Definimos el color de la Polilíneas
            lineOptions.color(Color.rgb(102, 157, 246));
        }

        // Dibujamos las Polilineas en el Google Map para cada ruta
        ruta = mMap.addPolyline(lineOptions);

        if(center.longitude != 0 && center.latitude != 0) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(center, 7));
        }
        System.out.println(duration);
        duration = duration.replaceAll("hours", "horas");
        duration = duration.replaceAll("mins", "minutos");
        System.out.println(duration);
        if(distance != "" || duration != "") {
            Toast.makeText(getApplicationContext(), distance + ". Tu llegada aproximada es en: " + duration + ".", Toast.LENGTH_LONG).show();
        }
        /////////////

    }


    public void mapsIndicator(View view) {
        //userUbication();
        System.out.println("SIIIII");
        webServiceObtenerRuta(Double.toString(userLatitude), Double.toString(userLongitude), Double.toString(lastMarkerLatitude), Double.toString(lastMarkerLongitude));

    }


    @Override
    public boolean onMarkerClick(Marker marker) {


        //mMap.animateCamera(CameraUpdateFactory.zoomIn());
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 10));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 8), 1000, null);
        mMap.setInfoWindowAdapter(new CustomWindowInfo(getApplicationContext()));

        marker.showInfoWindow();
        //mMap.animateCamera(CameraUpdateFactory.zoomBy(10),3000, null);

        //mMap.animateCamera(CameraUpdateFactory.zoomBy(20),3000, null);

        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.0810,80.2740), 15.5f), 4000, null);

        lastMarkerLatitude = marker.getPosition().latitude;
        lastMarkerLongitude = marker.getPosition().longitude;






        return true;
    }




    @Override
    public void onMapClick(LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5.5f), 1000, null);
    }


    @Override
    public boolean onMyLocationButtonClick() {

        userUbication();

        return true;
    }

}
