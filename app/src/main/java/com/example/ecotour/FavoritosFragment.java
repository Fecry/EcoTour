package com.example.ecotour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ecotour.adaptadores.AdapterListaReservas;
import com.example.ecotour.entidades.InfoAdicionales;
import com.example.ecotour.entidades.Reserva;
import com.example.ecotour.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;


public class FavoritosFragment extends Fragment {

    ArrayList<Integer> numReservasFav = InformaciónDeslizableActivity.numeroReservas;

    public FavoritosFragment() {
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

        View vista = inflater.inflate(R.layout.fragment_favoritos, container, false);

        //crea lista de favoritos
        ListView listFavoritos = vista.findViewById(R.id.listaFavoritos);
        List<Reserva> reservasFav = new ArrayList<Reserva>();

        if(numReservasFav.isEmpty()){
        }
        else{

            //Bucle que crea la lista con la info de cada reserva de Favoritos.
            for(int i: numReservasFav){

                Reserva unaReserva = new Reserva();
                unaReserva.setLaImagen(listFavoritos.getContext().getResources().getIdentifier(Utilidades.IMAGENES[i],
                        "drawable", listFavoritos.getContext().getPackageName()));
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
                reservasFav.add(unaReserva);
            }

            AdapterListaReservas elAdaptador = new AdapterListaReservas(getActivity(), reservasFav);
            listFavoritos.setAdapter(elAdaptador);
        }

        return vista;
    }
}