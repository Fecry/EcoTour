package com.example.ecotour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ecotour.adaptadores.AdapterInfoAdicional;
import com.example.ecotour.entidades.InfoAdicionales;
import com.example.ecotour.entidades.Reserva;
import com.example.ecotour.utilidades.Utilidades;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class InfoAdicionalReserva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_reservas);

        //Se recupera la reserva pasada por parámetro
        Reserva reserva = (Reserva) getIntent().getSerializableExtra("reserva");
        ListView laListaGraf = (ListView) findViewById(R.id.listaReservas);

        TextView titulo = (TextView) findViewById(R.id.titulo);
        List<InfoAdicionales> adicionales = new ArrayList<InfoAdicionales>();

        //Decisión para saber si se debe dibujar la ventana de 'rutas' o la de 'cómo llegar'
        if(getIntent().getSerializableExtra("accion").equals("comoLlegar"))
        {
            //Seteo del título
            titulo.setText(Utilidades.TITULO_COMO_LLEGAR);

            //se recorren cada una de las rutas
            for (int i = 0; i < reserva.getRutas().size(); i++)
            {
                adicionales.add(reserva.getRutas().get(i));
            }
        }else
        {
            //Seteo del título
            titulo.setText(Utilidades.TITULO_RECOMENDACIONES);

            InfoAdicionales infoAdicionales = new InfoAdicionales();
            infoAdicionales.setDescripcion(reserva.getRecomendaciones());
            adicionales.add(infoAdicionales);
        }

        //carga del adaptador con la información a dibujar en el scrolleable
        AdapterInfoAdicional elAdapterInfoAdicional = new AdapterInfoAdicional(this, adicionales);

        //Seteo del adaptador a la lista
        laListaGraf.setAdapter(elAdapterInfoAdicional);
    }
}