package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ecotour.entidades.InfoAdicionales;
import com.example.ecotour.utilidades.Utilidades;

import java.util.ArrayList;

public class programarViaje extends AppCompatActivity implements View.OnClickListener {

    static ArrayList<Integer> numeroReservaProgramada = new ArrayList<>();
    private String año, mes, dia1, dia2;

    ArrayList<String> opcionesArray = new ArrayList<String>();
    Switch notificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programar_viaje);
        //Agregar reserva a Fragment Viajes.

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
                año = parent.getItemAtPosition(position).toString();
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
                mes = parent.getItemAtPosition(position).toString();
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
                dia1 = parent.getItemAtPosition(position).toString();
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
                dia2 = parent.getItemAtPosition(position).toString();
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
                break;
            case R.id.programar_btn:
                int numero = (int) getIntent().getSerializableExtra("numeroViaje");
                if(numeroReservaProgramada.contains(numero)){
                    Toast.makeText(programarViaje.this, "Ya se ha programado un viaje con esta reserva. ", Toast.LENGTH_LONG).show();
                }else{
                    numeroReservaProgramada.add(numero);
                    Toast.makeText(programarViaje.this, "Se ha programado su viaje entre los días "+dia1+ " - "+dia2+ " del mes de "+ mes+ " del año "+ año+".", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}