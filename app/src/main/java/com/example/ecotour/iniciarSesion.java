package com.example.ecotour;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.io.Serializable;
import java.util.zip.Inflater;

public class iniciarSesion extends AppCompatActivity implements View.OnClickListener {
    private TextView registra;
    private TextView contra_olvidada;
    private Button inicio;
    private Button continuar;
    private ImageButton google;
    static String cambio;

    private EditText textCorreo, textContra;
    private FirebaseAuth mAuth;

    private ProgressBar progressBar;
    private GoogleSignInClient mGoogleSignInClient;

    @SuppressLint("ResourceType")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        mAuth = FirebaseAuth.getInstance();

        inicio = findViewById(R.id.iniciar_btn2);
        inicio.setOnClickListener(this);

        registra = findViewById(R.id.registrarse_btn1);
        registra.setOnClickListener(this);

        contra_olvidada = findViewById(R.id.contraseña_btn);
        contra_olvidada.setOnClickListener(this);

        continuar = findViewById(R.id.continuar_btn);
        continuar.setOnClickListener(this);

        textCorreo = findViewById(R.id.correo_);
        textContra = findViewById(R.id.contraseña_);

        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.INVISIBLE);

        crearSolicitudGoogle();
        // Google
        google = findViewById(R.id.google_btn);
        google.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuario = mAuth.getCurrentUser();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iniciar_btn2:
                iniciar();
                break;
            case R.id.registrarse_btn1:
                startActivity(new Intent(this, Registrarse.class));
                break;
            case R.id.continuar_btn:
                startActivity(new Intent(this, navegacion.class));
                break;
            case R.id.contraseña_btn:
                startActivity(new Intent(this, contra_olvidada.class));
                break;
            case R.id.google_btn:
                progressBar.setVisibility(View.VISIBLE);
                resultLauncher.launch(new Intent(mGoogleSignInClient.getSignInIntent()));

                GoogleSignInOptions gso = new GoogleSignInOptions.
                        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                        build();

                GoogleSignInClient googleSignInClient=GoogleSignIn.getClient(this,gso);
                googleSignInClient.signOut();
                break;
        }
    }
    //INGRESO CON GOOGLE
    private void crearSolicitudGoogle() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        mGoogleSignInClient = GoogleSignIn.getClient(iniciarSesion.this, gso);
    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()== Activity.RESULT_OK){
                        Intent intent = result.getData();
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(intent);
                        try {
                            // Google Sign In was successful, authenticate with Firebase
                            GoogleSignInAccount account = task.getResult(ApiException.class);
                            assert account != null;
                            firebaseAuthWithGoogle(account);
                        } catch (ApiException e) {
                            // Google Sign In failed, update UI appropriately
                            Toast.makeText(iniciarSesion.this,e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            });


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent intent = new Intent(iniciarSesion.this, navegacion.class);
                        Toast.makeText(iniciarSesion.this, "Ingreso exitoso.", Toast.LENGTH_LONG).show();
                        intent.putExtra("nombre", (Serializable) user.getDisplayName());
                        startActivity(intent);
                        progressBar.setVisibility(View.INVISIBLE);


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(iniciarSesion.this, "Lo sentimos, error en la autenticación.", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
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
                Intent intent = new Intent(iniciarSesion.this, navegacion.class);
                Toast.makeText(iniciarSesion.this, "Ingreso exitoso.", Toast.LENGTH_LONG).show();

                int arroba = email.indexOf("@");
                intent.putExtra("email", (Serializable) email.substring(0,arroba));
                startActivity(intent);
                progressBar.setVisibility(View.INVISIBLE);
            }
            else{
                Toast.makeText(iniciarSesion.this,"Datos incorrectos, inténtalo de nuevo", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}