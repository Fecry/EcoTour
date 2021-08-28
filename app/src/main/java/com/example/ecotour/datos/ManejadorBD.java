package com.example.ecotour.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ecotour.contratos.ContratoReservas;
import com.example.ecotour.contratos.ContratoRutas;

public class ManejadorBD extends SQLiteOpenHelper
{
    public static final int VERSION_BD = 1;
    public static final String NOMBRE_BD = "EcoTour.db";
    private static ManejadorBD driverBD = null;

    public static ManejadorBD getInstance(Context context)
    {
        if(driverBD == null)
        {
            try
            {
                driverBD = new ManejadorBD(context, NOMBRE_BD, null, VERSION_BD);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return driverBD;
    }

    private ManejadorBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE TABLE " + ContratoReservas.RegistrosReservas.TABLE_NAME + " (" +
                ContratoReservas.RegistrosReservas.NOMBRE + " VARCHAR(200)," +
                ContratoReservas.RegistrosReservas.IMAGEN + " INTEGER," +
                ContratoReservas.RegistrosReservas.CALIFICACION + " VARCHAR(200)," +
                ContratoReservas.RegistrosReservas.CANTIDAD_CALIFICACIONES + " INTEGER," +
                ContratoReservas.RegistrosReservas.UBICACION_GEOGRAFICA + " VARCHAR(200)," +
                ContratoReservas.RegistrosReservas.DESCRIPCION + " VARCHAR(200)," +
                ContratoReservas.RegistrosReservas.UBICACIONES_CERCANAS + " VARCHAR(200)," +
                ContratoReservas.RegistrosReservas.FLORA_FAUNA + " VARCHAR(200)," +
                ContratoReservas.RegistrosReservas.RECOMENDACIONES + " VARCHAR(200))");

        sqLiteDatabase.execSQL("CREATE TABLE " + ContratoRutas.RegistrosRutas.TABLE_NAME + " (" +
                ContratoRutas.RegistrosRutas.NOMBRE_RUTA + " VARCHAR(200)," +
                ContratoRutas.RegistrosRutas.DESCRIPCION + " VARCHAR(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContratoReservas.RegistrosReservas.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContratoRutas.RegistrosRutas.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
