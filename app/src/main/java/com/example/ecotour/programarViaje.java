package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class programarViaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programar_viaje);

        Spinner spinner_año = (Spinner) findViewById(R.id.spinner_año);
        Spinner spinner_mes = (Spinner) findViewById(R.id.spinner_mes);
        Spinner spinner_dia1 = (Spinner) findViewById(R.id.spinner_dia1);
        Spinner spinner_dia2 = (Spinner) findViewById(R.id.spinner_dia2);

        ArrayAdapter<String> adapterAño =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.año));
        ArrayAdapter<String> adapterMes =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.mes));
        ArrayAdapter<String> adapterDia =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dia_inicial));

        adapterAño.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_año.setAdapter(adapterAño);
        adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_mes.setAdapter(adapterMes);
        adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_dia1.setAdapter(adapterDia);
        spinner_dia2.setAdapter(adapterDia);

    }
}