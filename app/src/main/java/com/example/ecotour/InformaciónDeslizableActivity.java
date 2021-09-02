package com.example.ecotour;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.ecotour.entidades.Reserva;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecotour.databinding.ActivityScrollingBinding;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class InformaciónDeslizableActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;

    static ArrayList<Integer> numeroReservas = new ArrayList<>();
    protected Reserva reserva;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        reserva = (Reserva) getIntent().getSerializableExtra("reserva");

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(this.reserva.getNombre());
        toolBarLayout.setBackground(toolbar.getContext().getDrawable(this.reserva.getLaImagen()));

        TextView nombre = (TextView) binding.componenteScroll.nombre;
        nombre.setText(reserva.getNombre());

        TextView evaluaciones = (TextView) binding.componenteScroll.califacionesUbicacion;
        evaluaciones.setText(reserva.getCalificacion() + " (" + reserva.getCantidadCalificaciones() + " evaluaciones)");

        TextView descripcion = (TextView) binding.componenteScroll.descripcion;
        descripcion.setText(reserva.getDescripcion());

        TextView pobalacionesCercanas = (TextView) binding.componenteScroll.poblacionesCercanas;
        pobalacionesCercanas.setText(reserva.getUbicacionesCercanas());

        TextView floraFauna = (TextView) binding.componenteScroll.floraFauna;
        floraFauna.setText(reserva.getFloraYFauna());

        Button botonComoLlegar = (Button) binding.componenteScroll.botonComoLlegar;
        botonComoLlegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), InfoAdicionalReserva.class);
                intent.putExtra("reserva", (Serializable) reserva);
                intent.putExtra("accion", "comoLlegar");
                startActivity(intent);
            }
        });

        Button botonRecomendaciones = (Button) binding.componenteScroll.botonRecomendaciones;
        botonRecomendaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), InfoAdicionalReserva.class);
                intent.putExtra("reserva", (Serializable) reserva);
                intent.putExtra("accion", "recomendaciones");
                startActivity(intent);
            }
        });
        ImageButton favoritos = findViewById(R.id.favoritos_seleccionar);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoritos.setBackgroundColor(getResources().getColor(R.color.purple_200));
                String nombre = reserva.getNombre();
                int numero = ListadoReservasActivity.diccionario.get(nombre);
                if(numeroReservas.contains(numero)){
                    Toast.makeText(getBaseContext(), "Esta reserva ya ha sido agregada a favoritos.", Toast.LENGTH_LONG).show();
                }
                else{
                    numeroReservas.add(numero);
                    Toast.makeText(getBaseContext(), "Agregada a favoritos.", Toast.LENGTH_LONG).show();
                }

            }
        });
        ImageButton viajes = findViewById(R.id.viajes_seleccionar);
        viajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viajes.setBackgroundColor(getResources().getColor(R.color.purple_200));
                String nombre = reserva.getNombre();
                int numero = ListadoReservasActivity.diccionario.get(nombre);
                Intent intent = new Intent(getBaseContext(), programarViaje.class);
                intent.putExtra("numeroViaje", (Serializable) numero);
                startActivity(intent);
            }
        });

    }
}