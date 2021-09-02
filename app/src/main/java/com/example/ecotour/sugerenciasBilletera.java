package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ecotour.adaptadores.AdapterListaReservas;
import com.example.ecotour.entidades.InfoAdicionales;
import com.example.ecotour.entidades.Reserva;
import com.example.ecotour.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class sugerenciasBilletera extends AppCompatActivity {
    ArrayList<Integer> numReservasSug = BilleteraFragment.reservasBilletera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias_billetera);

        ListView listaSugerencias = (ListView) findViewById(R.id.listaBilletera);
        List<Reserva> lasReservas = new ArrayList<Reserva>();

        for (int i: numReservasSug)
        {
            Reserva unaReserva = new Reserva();
            unaReserva.setLaImagen(listaSugerencias.getContext().getResources().getIdentifier(Utilidades.IMAGENES[i],
                    "drawable", listaSugerencias.getContext().getPackageName()));
            unaReserva.setNombre(Utilidades.NOMBRE_PARQUES[i]);
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

        listaSugerencias.setAdapter(elAdaptador);
    }
}