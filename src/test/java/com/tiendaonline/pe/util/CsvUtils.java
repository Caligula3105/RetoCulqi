package com.tiendaonline.pe.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CsvUtils {

    public static Map<String, String> leerCSV(String rutaArchivo) {
        try (InputStream input = CsvUtils.class.getClassLoader().getResourceAsStream(rutaArchivo);
             BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String linea;
            Map<String, String> datosUsuario = new HashMap<>();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",", 2);
                if (partes.length == 2) {
                    datosUsuario.put(partes[0].trim().toLowerCase(), partes[1].trim());
                }
            }
            return datosUsuario;
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public static Map<String, String> leerCSVPorTipoYEstado(String rutaArchivo, String tipo, String estado) {
        try (InputStream input = CsvUtils.class.getClassLoader().getResourceAsStream(rutaArchivo);
             BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String headerLine = br.readLine();
            if (headerLine == null) throw new RuntimeException("CSV vacío");
            String[] headers = headerLine.split(",");
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                if (valores.length != headers.length) continue;
                Map<String, String> fila = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    fila.put(headers[i].trim().toLowerCase(), valores[i].trim());
                }
                if (fila.get("tipo").equalsIgnoreCase(tipo) && fila.get("estado").equalsIgnoreCase(estado)) {
                    return fila;
                }
            }
            throw new RuntimeException("No se encontró usuario con tipo=" + tipo + " y estado=" + estado);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
