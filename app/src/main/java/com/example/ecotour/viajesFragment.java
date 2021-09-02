package com.example.ecotour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.ecotour.adaptadores.AdapterListaReservas;
import com.example.ecotour.entidades.InfoAdicionales;
import com.example.ecotour.entidades.Reserva;
import com.example.ecotour.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class viajesFragment extends Fragment {

    public viajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_viajes, container, false);

        //crea lista de viajes programados
        ListView listViajesP = vista.findViewById(R.id.listaViajesP);
        List<Reserva> reservasViajes = new ArrayList<Reserva>();

        if(programarViaje.numeroReservaProgramada.isEmpty()){
        }
        else{

            //Bucle que crea la lista con la info de cada reserva de Favoritos.
            for(int i: programarViaje.numeroReservaProgramada){

                Reserva unaReserva = new Reserva();
                unaReserva.setLaImagen(listViajesP.getContext().getResources().getIdentifier(Utilidades.IMAGENES[i],
                        "drawable", listViajesP.getContext().getPackageName()));
                unaReserva.setNombre(Utilidades.NOMBRE_PARQUES[i]);
                unaReserva.setUbicacionGeografica(Utilidades.UBICACIONES_GEOGRAFICAS[i]);
                unaReserva.setCalificacion(Utilidades.CALIFICACIONES[i]);
                unaReserva.setCantidadCalificaciones(Utilidades.CANTIDAD_CALIFICACIONES[i] != "" ? Integer.parseInt(Utilidades.CANTIDAD_CALIFICACIONES[i]) : 0);
                unaReserva.setDescripcion(Utilidades.DESCRIPCIONES[i]);
                unaReserva.setUbicacionesCercanas(Utilidades.POBLACIONES_CERCANAS[i]);
                unaReserva.setFloraYFauna(Utilidades.FLORA_FAUNA[i]);
                unaReserva.setRecomendaciones(Utilidades.RECOMENDACIONES[i]);

                for (int j = 0; j < Utilidades.NOMBRES_RUTAS[i].length; j++) {
                    InfoAdicionales cadaInfo = new InfoAdicionales();
                    cadaInfo.setNombreRuta(Utilidades.NOMBRES_RUTAS[i][j]);
                    cadaInfo.setDescripcion(Utilidades.RUTAS[i][j]);

                    unaReserva.getRutas().add(cadaInfo);
                }
                reservasViajes.add(unaReserva);
            }

            AdapterListaReservas elAdaptador = new AdapterListaReservas(getActivity(), reservasViajes);
            listViajesP.setAdapter(elAdaptador);
        }

        return vista;
    }
}