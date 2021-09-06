package com.example.ecotour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class navegacion extends AppCompatActivity implements View.OnClickListener{

    private Button iniciar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegacion);

        Button inicio = findViewById(R.id.registrarse_btn3);
        inicio.setOnClickListener(this);

        BottomNavigationView botonNavega =findViewById(R.id.NavigationView);
        botonNavega.setOnNavigationItemSelectedListener(navListener);

        if(getIntent().getSerializableExtra("nombre")!=null){
            String cambio = (String) getIntent().getSerializableExtra("nombre");
            inicio.setText(cambio);
        }
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.dashboardFragment:
                        selectedFragment = new DashboardFragment();
                        break;
                    case R.id.favoritosFragment:
                        selectedFragment = new FavoritosFragment();
                        break;
                    case R.id.billeteraFragment:
                        selectedFragment = new BilleteraFragment();
                        break;
                    case R.id.viajesFragment:
                        selectedFragment = new viajesFragment();
                        break;

                }
                assert selectedFragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selectedFragment).commit();
                return true;

            };

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.registrarse_btn3:
                    startActivity(new Intent(this,iniciarSesion.class));
                    break;
            }
    }
}
