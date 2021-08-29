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

        Reserva reserva = (Reserva) getIntent().getSerializableExtra("reserva");
        ListView laListaGraf = (ListView) findViewById(R.id.listaReservas);

        TextView titulo = (TextView) findViewById(R.id.titulo);
        List<InfoAdicionales> adicionales = new ArrayList<InfoAdicionales>();

        if(getIntent().getSerializableExtra("accion").equals("comoLlegar"))
        {
            titulo.setText(Utilidades.TITULO_COMO_LLEGAR);

            for (int i = 0; i < reserva.getRutas().size(); i++)
            {
                adicionales.add(reserva.getRutas().get(i));
            }
        }else
        {
            titulo.setText(Utilidades.TITULO_RECOMENDACIONES);

            InfoAdicionales infoAdicionales = new InfoAdicionales();
            infoAdicionales.setDescripcion(reserva.getRecomendaciones());
            adicionales.add(infoAdicionales);
        }

        AdapterInfoAdicional elAdapterInfoAdicional = new AdapterInfoAdicional(this, adicionales);

        laListaGraf.setAdapter(elAdapterInfoAdicional);
    }
}