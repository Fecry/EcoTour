package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ecotour.adapters.AdapterListaReservas;
import com.example.ecotour.entities.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ListadoReservasActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_reservas);

        ListView laListaGraf = (ListView) findViewById(R.id.listaReservas);;
        List<Reserva> lasReservas = new ArrayList<Reserva>();

        for (int i = 0; i < 10; i++)
        {
            Reserva unaReserva = new Reserva();
            unaReserva.setLaImagen(laListaGraf.getContext().getResources().getIdentifier("pnn_gorgona",
                    "drawable", laListaGraf.getContext().getPackageName()));
            unaReserva.setNombre("Hola" + i);
            lasReservas.add(unaReserva);
        }

        AdapterListaReservas elAdaptador = new AdapterListaReservas(this, lasReservas);

        laListaGraf.setAdapter(elAdaptador);
    }
}