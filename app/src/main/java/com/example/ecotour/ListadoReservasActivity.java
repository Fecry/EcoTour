package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ecotour.adaptadores.AdapterListaReservas;
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

        // Se recorren las 20 reservas guardadas en la interfaz 'Utilidades' y se crea un objeto tipo
        // 'Reserva' por cada una de ellas
        for (int i = 0; i < 20; i++)
        {
            // 'unaReserva' representa cada una de las reservas
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

            //Se recorren las rutas disponibles por cada reserva
            for (int j = 0; j < Utilidades.NOMBRES_RUTAS[i].length; j++)
            {
                InfoAdicionales cadaInfo = new InfoAdicionales();
                cadaInfo.setNombreRuta(Utilidades.NOMBRES_RUTAS[i][j]);
                cadaInfo.setDescripcion(Utilidades.RUTAS[i][j]);

                //Se almacenan las rutas que son encapsuladas en un objeto 'InfoAdicional'
                unaReserva.getRutas().add(cadaInfo);
            }
            //Se a??ade la reserva al array para posteriormente envi??rsela al adaptador que se
            // encargar?? de dibujar cada reserva
            lasReservas.add(unaReserva);
        }

        //Se arma el adaptador y se le pasan las reservas a ser dibujadas
        AdapterListaReservas elAdaptador = new AdapterListaReservas(this, lasReservas);

        //Se le asigna a la lista scrolleable el adaptador con las reservas
        laListaGraf.setAdapter(elAdaptador);
    }
}