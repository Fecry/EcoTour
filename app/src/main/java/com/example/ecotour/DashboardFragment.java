package com.example.ecotour;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    ImageButton mapa;


    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_dashboard, container,false);
        ImageButton mapa = (ImageButton) vista.findViewById(R.id.imageButton12);
        mapa.setOnClickListener(this);

        return vista;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton12:
                startActivity(new Intent(getContext(), MapsActivity.class));
                break;
        }
    }




}