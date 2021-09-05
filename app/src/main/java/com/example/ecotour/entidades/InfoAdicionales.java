package com.example.ecotour.entidades;

import java.io.Serializable;

// Entidad que representa información adicional repetitiva en cada reserva
public class InfoAdicionales implements Serializable
{
    private String nombreRuta;
    private String descripcion;

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
