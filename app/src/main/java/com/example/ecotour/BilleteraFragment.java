package com.example.ecotour;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class BilleteraFragment extends Fragment implements View.OnClickListener {

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

        ArrayAdapter<String> adapterNoche =new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.noches));

        ArrayAdapter<String> adapterHabitacion =new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.habitaciones));

        ArrayAdapter<String> adapterPersonas =new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.personas));

        adapterNoche.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_noche.setAdapter(adapterNoche);
        spinner_habitacion.setAdapter(adapterHabitacion);
        spinner_personas.setAdapter(adapterPersonas);

        //Boton guardar preferencias.

        Button guardar = (Button) vista.findViewById(R.id.billera_btn);
        guardar.setOnClickListener(this);

        return vista;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.billera_btn:
                startActivity(new Intent(getContext(), programarViaje.class));
                break;
        }
    }

}
