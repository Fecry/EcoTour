package com.example.ecotour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Registrarse extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText nombre, correo;
    private EditText contraseña, verificarContraseña;
    private ProgressBar progressBar;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        Button registrar = findViewById(R.id.registrarse_btn2);
        registrar.setOnClickListener(this);

        nombre = findViewById(R.id.Nombre);
        correo = findViewById(R.id.Correo);
        contraseña = findViewById(R.id.Contraseña);
        verificarContraseña = findViewById(R.id.verificarContraseña);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);


    }

   @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.registrarse_btn2:
                registerUser();

        }

    }

    private <RegisterUser> void registerUser() {
        String name = nombre.getText().toString().trim();
        String email = correo.getText().toString().trim();
        String password = contraseña.getText().toString().trim();
        String password2 = verificarContraseña.getText().toString().trim();

        if(name.isEmpty()){
            nombre.setError("Ingrese nombre, por favor");
            nombre.requestFocus();
            return;
        }
        if(email.isEmpty()){
            correo.setError("Ingrese correo, por favor");
            correo.requestFocus();
            return;
        }
        if(password.isEmpty()){
            contraseña.setError("Ingrese contraseña, por favor");
            contraseña.requestFocus();
            return;
        }
        if(password2.isEmpty()){
            verificarContraseña.setError("Ingrese nuevamente contraseña, por favor");
            verificarContraseña.requestFocus();
            return;
        }

        if(password.length()<6){
            contraseña.setError("Mínimo 6 caracteres.");
            contraseña.requestFocus();
            return;
        }

        if (password.equals(password2)){
        }
        else{
            verificarContraseña.setError("Contraseñas no coinciden");
            verificarContraseña.requestFocus();
            return;
        }



        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            correo.setError("Correo no válido");
            correo.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Usuario user = new Usuario(name, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(Registrarse.this, "El usuario ha sido registrado exitosamente.", Toast.LENGTH_LONG).show();

                                        //Obtener id con el que se registro en Firebase
                                        String id = mAuth.getCurrentUser().getUid();

                                        //crear mapa de datos
                                        HashMap<String, Object> mapaDatos = new HashMap<>();
                                        mapaDatos.put("nombre", name);
                                        //Ingresar datos del user a Firebase
                                        databaseReference.child("Users").child(id).setValue(mapaDatos);

                                        // Mandar nombre a navegacion para poder cambiar String del boton.
                                        Intent intent = new Intent(Registrarse.this, navegacion.class);
                                        intent.putExtra("nombre", (Serializable) name);
                                        startActivity(intent);
                                        progressBar.setVisibility(View.GONE);

                                    } else {
                                        Toast.makeText(Registrarse.this, "No se ha podido registrar, intente de nuevo.", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }

                                }
                            });
                        }else {
                            Toast.makeText(Registrarse.this, "No se ha podido registrar, intente de nuevo.", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                });
    }
}
