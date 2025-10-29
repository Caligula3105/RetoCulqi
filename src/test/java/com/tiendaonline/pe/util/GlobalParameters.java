package com.tiendaonline.pe.util;

public class GlobalParameters {
    private static String nombreUsuario;

    public static void setNombreUsuario(String nombre) {
        nombreUsuario = nombre;
    }
    public static String getNombreUsuario() {
        return nombreUsuario;
    }
}
