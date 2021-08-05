package com.example.ecotour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class contra_olvidada extends AppCompatActivity implements View.OnClickListener{

    private EditText emailText;
    private Button resetContra;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contra_olvidada);

        emailText = (EditText) findViewById(R.id.email);
        resetContra = (Button) findViewById(R.id.restablecer_btn);
        auth = FirebaseAuth.getInstance();

        resetContra.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        resetContra();
    }

    private void resetContra(){
        String email = emailText.getText().toString().trim();
        if(email.isEmpty()){
            emailText.setError("Debe ingresar un correo");
            emailText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailText.setError("Ingrese un correo válido");
            emailText.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(contra_olvidada.this, "Revisa tu email para restablecer tu contraseña",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(contra_olvidada.this, "Intenta de nuevo, algo ha salido mal",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}

