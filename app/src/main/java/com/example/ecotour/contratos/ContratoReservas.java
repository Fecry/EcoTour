package com.example.ecotour.contratos;

import android.provider.BaseColumns;

import java.util.ArrayList;

public class ContratoReservas
{
    public static class RegistrosReservas implements BaseColumns
    {
        public static final String TABLE_NAME = "reservas";

        public static final String IMAGEN = "imagen";
        public static final String NOMBRE = "nombre";
        public static final String CALIFICACION = "calificacion";
        public static final String CANTIDAD_CALIFICACIONES = "cantidadCalificaciones";
        public static final String UBICACION_GEOGRAFICA = "ubicacionGeografica";
        public static final String DESCRIPCION = "descripción";
        public static final String FLORA_FAUNA = "floraYFauna";
        public static final String RECOMENDACIONES = "recomendaciones";
        public static final String UBICACIONES_CERCANAS = "ubicacionesCercanas";
    }
}
