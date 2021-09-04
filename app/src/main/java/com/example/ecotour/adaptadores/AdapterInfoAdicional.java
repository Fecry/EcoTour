package com.example.ecotour.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ecotour.R;
import com.example.ecotour.entidades.InfoAdicionales;

import java.util.List;

public class AdapterInfoAdicional extends BaseAdapter
{
    protected Activity activity;
    protected List<InfoAdicionales> adicionales;

    public AdapterInfoAdicional(Activity activity, List<InfoAdicionales> infoAdicionales)
    {
        this.activity = activity;
        this.adicionales = infoAdicionales;
    }

    @Override
    public int getCount() {
        return adicionales.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if (view == null)
        {
            LayoutInflater informacion = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = informacion.inflate(R.layout.vista_lista_adicionales, null);
        }

        //Seteo de la infiormación en la ventana de adicionales
        InfoAdicionales cadaAdicional = adicionales.get(i);

        TextView sub = (TextView) v.findViewById(R.id.subtitulo);
        sub.setText(cadaAdicional.getNombreRuta());

        TextView cont = (TextView) v.findViewById(R.id.contenido);
        cont.setText(cadaAdicional.getDescripcion());

        return v;
    }
}
