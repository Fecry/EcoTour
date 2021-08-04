package com.example.ecotour;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class BilleteraFragment extends Fragment implements View.OnClickListener {
    ArrayList<String> opcionesArray = new ArrayList<String>();
    String opciones= "";
    public BilleteraFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_billetera, container, false);

        //Seleccionar alguna opcion.
        Spinner spinner_noche = (Spinner) vista.findViewById(R.id.spinner_noches);
        Spinner spinner_habitacion = (Spinner) vista.findViewById(R.id.spinner_habitaciones);
        Spinner spinner_personas = (Spinner) vista.findViewById(R.id.spinner_personas);

        ArrayAdapter<CharSequence> adapterNoche =ArrayAdapter.createFromResource(getActivity(),R.array.noches,
                android.R.layout.simple_list_item_1);

        ArrayAdapter<CharSequence> adapterHabitacion = ArrayAdapter.createFromResource(getActivity(),R.array.habitaciones,
                android.R.layout.simple_list_item_1);

        ArrayAdapter<CharSequence> adapterPersonas =ArrayAdapter.createFromResource(getActivity(),R.array.personas,
                android.R.layout.simple_list_item_1);

        spinner_noche.setAdapter(adapterNoche);
        spinner_habitacion.setAdapter(adapterHabitacion);
        spinner_personas.setAdapter(adapterPersonas);

        //Boton

        Button guardar = vista.findViewById(R.id.billera_btn);
        guardar.setOnClickListener(this);

        //Obtener elemento cantidad noches
        spinner_noche.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String noches = parent.getItemAtPosition(position).toString();
                opcionesArray.add(noches);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //Obtener elemento cantidad habitaciones
        spinner_habitacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String habitaciones = parent.getItemAtPosition(position).toString();
                opcionesArray.add(habitaciones);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //Obtener elemento cantidad personas
        spinner_personas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String personas = parent.getItemAtPosition(position).toString();
                opcionesArray.add(personas);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        return vista;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.billera_btn:
                Toast.makeText(getContext(), opcionesArray.toString(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(getContext(), programarViaje.class));
                break;
        }
    }

}
