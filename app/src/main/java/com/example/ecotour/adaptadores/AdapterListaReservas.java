package com.example.ecotour.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.ecotour.R;
import com.example.ecotour.InformaciónDeslizableActivity;
import com.example.ecotour.entidades.Reserva;

import java.io.Serializable;
import java.util.List;

public class AdapterListaReservas extends BaseAdapter
{
    protected Activity theActivity;
    protected List<Reserva> lasReservas;

    //Se cargan las reservas en le segundo parámetro
    public AdapterListaReservas(Activity theActivity, List<Reserva> lasReservas)
    {
        this.theActivity = theActivity;
        this.lasReservas = lasReservas;
    }

    public void limpiarLista()
    {
        lasReservas.clear();
    }

    @Override
    public int getCount() {
        return lasReservas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //El recorrido del array asignado, es decir el de las reservas
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = view;

        //Si la vista aún no se ha creado, aquí se crea
        if (view == null)
        {
            LayoutInflater informacion = (LayoutInflater) theActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = informacion.inflate(R.layout.vista_lista_reservas, null);
        }

        //Se obtiene cada una de las reservas, el recorrido se encarga de hacer el adaptador
        Reserva cadaReserva = lasReservas.get(i);

        // Se le asigna una imagen con texto, además de un evento escuchador a cada tarjeta que
        // representa una tarjeta
        LinearLayout imagen = (LinearLayout) v.findViewById(R.id.imagenReserva);
        imagen.setBackground(v.getContext().getDrawable(cadaReserva.getLaImagen()));
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se lanza el activity 'InformaciónDeslizableActivity' cada vez que el usuario oprime
                // en una de las tarjetas
                Intent intent = new Intent(theActivity.getBaseContext(), InformaciónDeslizableActivity.class);
                //Se le manda como parámetro la reserva perteneciente a la tarjeta
                intent.putExtra("reserva", (Serializable) cadaReserva);
                theActivity.startActivity(intent);
            }
        });
        TextView textoImagen = (TextView) v.findViewById(R.id.textoSobreImagen);
        textoImagen.setText(cadaReserva.getNombre() + " - " + cadaReserva.getUbicacionGeografica());

        return v;
    }
}
