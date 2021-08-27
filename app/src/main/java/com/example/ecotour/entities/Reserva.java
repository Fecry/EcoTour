package com.example.ecotour.entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Reserva
{
    private int laImagen;
    private String nombre;
    private String calificacion;
    private String cantidadCalificaciones;
    private String ubicacionGeografica;
    private String descripción;
    private ArrayList<String> ubicacionesCercanas;
    private String floraYFauna;
    private String recomendaciones;
    private ArrayList<Ruta> rutas;

    public int getLaImagen() {
        return laImagen;
    }

    public void setLaImagen(int laImagen) {
        this.laImagen = laImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(String cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public ArrayList<String> getUbicacionesCercanas() {
        return ubicacionesCercanas;
    }

    public void setUbicacionesCercanas(ArrayList<String> ubicacionesCercanas) {
        this.ubicacionesCercanas = ubicacionesCercanas;
    }

    public String getFloraYFauna() {
        return floraYFauna;
    }

    public void setFloraYFauna(String floraYFauna) {
        this.floraYFauna = floraYFauna;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }
}
