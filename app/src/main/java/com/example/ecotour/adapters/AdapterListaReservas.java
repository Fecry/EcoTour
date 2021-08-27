package com.example.ecotour.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.ecotour.R;
import com.example.ecotour.entities.Reserva;

import java.util.List;

public class AdapterListaReservas extends BaseAdapter
{
    protected Activity theActivity;
    protected List<Reserva> lasReservas;


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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = view;

        if (view == null)
        {
            LayoutInflater informacion = (LayoutInflater) theActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = informacion.inflate(R.layout.vista_lista_reservas, null);
        }

        Reserva cadaReserva = lasReservas.get(i);

        LinearLayout imagen = (LinearLayout) v.findViewById(R.id.imagenReserva);
        imagen.setBackground(v.getContext().getDrawable(cadaReserva.getLaImagen()));
        TextView textoImagen = (TextView) v.findViewById(R.id.textoSobreImagen);
        textoImagen.setText(cadaReserva.getNombre());

        return v;
    }
}
