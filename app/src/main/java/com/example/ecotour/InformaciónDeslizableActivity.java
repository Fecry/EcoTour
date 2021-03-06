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

        //Se recupera la reserva enviada como parámetro
        reserva = (Reserva) getIntent().getSerializableExtra("reserva");

        // Se crea el scroll de la información de la reserva
        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Se carga el título y la imagen
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(" ");
        toolBarLayout.setBackground(toolbar.getContext().getDrawable(this.reserva.getLaImagen()));

        //Seteo de las múltiples informaciones de cada reserva
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

        //Boton de información adicional
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

        //Boton de información adicional
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
                String nombre = reserva.getNombre();
                int numero = ListadoReservasActivity.diccionario.get(nombre);
                if(numeroReservas.contains(numero)){
                    numeroReservas.remove(new Integer(numero));

                    Toast.makeText(getBaseContext(), "Esta reserva se ha eliminado de favoritos.", Toast.LENGTH_LONG).show();
                    favoritos.setBackgroundColor(getResources().getColor(R.color.white));
                }
                else{
                    favoritos.setBackgroundColor(getResources().getColor(R.color.purple_200));
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