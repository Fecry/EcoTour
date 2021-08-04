package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class programarViaje extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> opcionesArray = new ArrayList<String>();
    Switch notificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programar_viaje);

        //Boton
        Button guardar = findViewById(R.id.programar_btn);
        guardar.setOnClickListener(this);

        //Switch

        notificacion = (Switch) findViewById(R.id.switch_notificacion);
        notificacion.setOnClickListener(this);

        //Spinner, seleccionar opciones

        Spinner spinner_año = (Spinner) findViewById(R.id.spinner_año);
        Spinner spinner_mes = (Spinner) findViewById(R.id.spinner_mes);
        Spinner spinner_dia1 = (Spinner) findViewById(R.id.spinner_dia1);
        Spinner spinner_dia2 = (Spinner) findViewById(R.id.spinner_dia2);

        ArrayAdapter<CharSequence> adapterAño = ArrayAdapter.createFromResource(this,R.array.año,
                android.R.layout.simple_list_item_1);
        ArrayAdapter<CharSequence> adapterMes =ArrayAdapter.createFromResource(this,R.array.mes,
                android.R.layout.simple_list_item_1);
        ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this, R.array.dia_inicial,
                android.R.layout.simple_list_item_1);

        spinner_año.setAdapter(adapterAño);
        spinner_mes.setAdapter(adapterMes);
        spinner_dia1.setAdapter(adapterDia);
        spinner_dia2.setAdapter(adapterDia);

        //Obtener elemento de Año
        spinner_año.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String año = parent.getItemAtPosition(position).toString();
                opcionesArray.add(año);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Obtener elemento de Mes
        spinner_mes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mes = parent.getItemAtPosition(position).toString();
                opcionesArray.add(mes);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //Obtener elemento de Dia en que empieza
        spinner_dia1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String dia1 = parent.getItemAtPosition(position).toString();
                opcionesArray.add(dia1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //Obtener elemento de Dia en que termina
        spinner_dia2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String dia2 = parent.getItemAtPosition(position).toString();
                opcionesArray.add(dia2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.switch_notificacion:
                if(notificacion.isChecked()){
                    opcionesArray.add("Activado");
                }
                else{
                    opcionesArray.add("Desactivado");
                }

            case R.id.programar_btn:
                Toast.makeText(programarViaje.this, "Viaje programado. ", Toast.LENGTH_LONG).show();
                Toast.makeText(programarViaje.this, opcionesArray.toString(), Toast.LENGTH_LONG).show();
                break;
        }
    }
}