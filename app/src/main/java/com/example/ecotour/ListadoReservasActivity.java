package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ecotour.adaptadores.AdapterListaReservas;
import com.example.ecotour.datos.ManejadorBD;
import com.example.ecotour.entidades.Reserva;
import com.example.ecotour.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class ListadoReservasActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_reservas);

        ListView laListaGraf = (ListView) findViewById(R.id.listaReservas);
        List<Reserva> lasReservas = new ArrayList<Reserva>();

        ManejadorBD manejadorBD = ManejadorBD.getInstance(this);

        for (int i = 0; i < 20; i++)
        {
            Reserva unaReserva = new Reserva();
            unaReserva.setLaImagen(laListaGraf.getContext().getResources().getIdentifier(Utilidades.IMAGENES[i],
                    "drawable", laListaGraf.getContext().getPackageName()));
            unaReserva.setNombre(Utilidades.NOMBRE_PARQUES[i]);
            unaReserva.setUbicacionGeografica(Utilidades.UBICACIONES_GEOGRAFICAS[i]);
            lasReservas.add(unaReserva);
        }

        AdapterListaReservas elAdaptador = new AdapterListaReservas(this, lasReservas);

        laListaGraf.setAdapter(elAdaptador);
    }
}