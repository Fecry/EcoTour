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

import com.example.ecotour.utilidades.Utilidades;

import java.util.ArrayList;

public class BilleteraFragment extends Fragment implements View.OnClickListener {
    ArrayList<String> opcionesArray = new ArrayList<String>();
    static ArrayList<Integer> reservasBilletera = new ArrayList<Integer>();
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
        Spinner spinner_habitaciones = (Spinner) vista.findViewById(R.id.spinner_habitaciones);
        Spinner spinner_personas = (Spinner) vista.findViewById(R.id.spinner_personas);

        ArrayAdapter<CharSequence> adapterNoche =ArrayAdapter.createFromResource(getActivity(),R.array.noches,
                android.R.layout.simple_list_item_1);
        ArrayAdapter<CharSequence> adapterHabitaciones =ArrayAdapter.createFromResource(getActivity(),R.array.habitaciones,
                android.R.layout.simple_list_item_1);
        ArrayAdapter<CharSequence> adapterPersonas =ArrayAdapter.createFromResource(getActivity(),R.array.personas,
                android.R.layout.simple_list_item_1);


        spinner_noche.setAdapter(adapterNoche);
        spinner_habitaciones.setAdapter(adapterHabitaciones);
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

        return vista;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.billera_btn:
                if(!(opcionesArray.size()==1)){
                    for(int i=0; i<20;i++){
                        int presUser = Integer.parseInt(opcionesArray.get(opcionesArray.size()-1));
                        int reservaPrecio = Utilidades.billeteraPresupuesto[i][0];
                        if(reservaPrecio<= presUser) {
                            reservasBilletera.add(Utilidades.billeteraPresupuesto[i][1]);
                        }
                    }
                    startActivity(new Intent(getContext(), sugerenciasBilletera.class));
                }else{
                    Toast.makeText(getContext(),"Por favor, seleccione todas las preferencias.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

}
