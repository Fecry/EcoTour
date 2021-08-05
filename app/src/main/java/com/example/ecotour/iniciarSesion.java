package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class iniciarSesion extends AppCompatActivity implements View.OnClickListener{
    private TextView registra;
    private TextView contra_olvidada;
    private Button inicio;
    private Button continuar;

    private EditText textCorreo, textContra;
    private FirebaseAuth mAuth;

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        mAuth = FirebaseAuth.getInstance();

        Button inicio = findViewById(R.id.iniciar_btn2);
        inicio.setOnClickListener(this);

        TextView registra = findViewById(R.id.registrarse_btn1);
        registra.setOnClickListener(this);

        TextView contra_olvidada = findViewById(R.id.contraseña_btn);
        contra_olvidada.setOnClickListener(this);

        Button continuar = findViewById(R.id.continuar_btn);
        continuar.setOnClickListener(this);

        textCorreo = findViewById(R.id.correo_);
        textContra = findViewById(R.id.contraseña_);

        progressBar = findViewById(R.id.progressBar2);

    }

    @Override

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iniciar_btn2:
                iniciar();
                break;
            case R.id.registrarse_btn1:
                startActivity(new Intent(this,Registrarse.class));
                break;
            case R.id.continuar_btn:
                startActivity(new Intent(this, navegacion.class));
                break;
            case R.id.contraseña_btn:
                startActivity(new Intent(this, contra_olvidada.class));
                break;
        }
    }
    public void iniciar(){
        String email = textCorreo.getText().toString().trim();
        String password = textContra.getText().toString().trim();


        if(email.isEmpty()){
            textCorreo.setError("Ingrese correo, por favor");
            textCorreo.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            textCorreo.setError("Correo no válido");
            textCorreo.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            textContra.setError("Ingrese contraseña, por favor");
            textContra.requestFocus();
            return;
        }
        if(password.length()<6){
            textContra.setError("Mínimo 6 caracteres.");
            textContra.requestFocus();
            return;

        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                startActivity(new Intent(iniciarSesion.this, navegacion.class));

            }
            else{
                Toast.makeText(iniciarSesion.this,"Datos incorrectos, inténtalo de nuevo", Toast.LENGTH_LONG).show();
            }
        });
    }
}