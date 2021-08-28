package com.example.ecotour.contratos;

import android.provider.BaseColumns;

public class ContratoRutas
{
    public static class RegistrosRutas implements BaseColumns
    {
        public static final String TABLE_NAME = "rutas";

        public static final String NOMBRE_RUTA = "nombreRuta";
        public static final String DESCRIPCION = "descripcion";
    }
}
