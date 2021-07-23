package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button iniciar;
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inicio = findViewById(R.id.IniciarSesion_btn);
        inicio.setOnClickListener(this);

        Button ingresar = findViewById(R.id.Ingreso);
        ingresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.IniciarSesion_btn:
                startActivity(new Intent(this,iniciarSesion.class));
                break;
            case R.id.Ingreso:
                startActivity(new Intent(this,navegacion.class));
                break;
        }
    }
}