package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ecotour.adaptadores.AdapterListaReservas;
import com.example.ecotour.datos.ManejadorBD;
import com.example.ecotour.entidades.InfoAdicionales;
import com.example.ecotour.entidades.Reserva;
import com.example.ecotour.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListadoReservasActivity extends AppCompatActivity
{
    static HashMap<String,Integer> diccionario= new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_reservas);

        ListView laListaGraf = (ListView) findViewById(R.id.listaReservas);
        List<Reserva> lasReservas = new ArrayList<Reserva>();

        for (int i = 0; i < 20; i++)
        {
            Reserva unaReserva = new Reserva();
            unaReserva.setLaImagen(laListaGraf.getContext().getResources().getIdentifier(Utilidades.IMAGENES[i],
                    "drawable", laListaGraf.getContext().getPackageName()));
            unaReserva.setNombre(Utilidades.NOMBRE_PARQUES[i]);
            //Guardar en diccionario.
            diccionario.put(Utilidades.NOMBRE_PARQUES[i],i);

            unaReserva.setUbicacionGeografica(Utilidades.UBICACIONES_GEOGRAFICAS[i]);
            unaReserva.setCalificacion(Utilidades.CALIFICACIONES[i]);
            unaReserva.setCantidadCalificaciones(Utilidades.CANTIDAD_CALIFICACIONES[i] != "" ? Integer.parseInt(Utilidades.CANTIDAD_CALIFICACIONES[i]) : 0);
            unaReserva.setDescripcion(Utilidades.DESCRIPCIONES[i]);
            unaReserva.setUbicacionesCercanas(Utilidades.POBLACIONES_CERCANAS[i]);
            unaReserva.setFloraYFauna(Utilidades.FLORA_FAUNA[i]);
            unaReserva.setRecomendaciones(Utilidades.RECOMENDACIONES[i]);
            for (int j = 0; j < Utilidades.NOMBRES_RUTAS[i].length; j++)
            {
                InfoAdicionales cadaInfo = new InfoAdicionales();
                cadaInfo.setNombreRuta(Utilidades.NOMBRES_RUTAS[i][j]);
                cadaInfo.setDescripcion(Utilidades.RUTAS[i][j]);

                unaReserva.getRutas().add(cadaInfo);
            }
            lasReservas.add(unaReserva);
        }

        AdapterListaReservas elAdaptador = new AdapterListaReservas(this, lasReservas);

        laListaGraf.setAdapter(elAdaptador);
    }
}