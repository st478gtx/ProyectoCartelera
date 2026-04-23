package com.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sala {

	public String nombre;
	public List<List<String>> distribucion;

	public Sala(String nombre, List<List<String>> distribucion) {
		this.nombre = nombre;
		this.distribucion = distribucion;
	}	
	
	public static Sala crearSalaSimple(String nombre, int filas, int columnas) {
        List<List<String>> grid = new ArrayList<>();

        for (int f = 0; f < filas; f++) {
            char letra = (char) ('A' + f);
            List<String> row = new ArrayList<>();

            for (int c = 1; c <= columnas; c++) {
                row.add(letra + String.valueOf(c));
            }

            grid.add(row);
        }

        return new Sala(nombre, grid);
    }
	
	public static Sala crearSalaConPasillo(String nombre, int filas, int columnas) {
        List<List<String>> grid = new ArrayList<>();

        int mitad = columnas / 2;

        for (int f = 0; f < filas; f++) {
            char letra = (char) ('A' + f);
            List<String> row = new ArrayList<>();

            for (int c = 1; c <= columnas; c++) {
                if (c == mitad + 1) {
                    row.add(null); // pasillo
                }
                row.add(letra + String.valueOf(c));
            }

            grid.add(row);
        }

        return new Sala(nombre, grid);
    }
	
	public static Sala crearSalaDoblePasillo(String nombre, int filas, int columnas) {
        List<List<String>> grid = new ArrayList<>();

        int tercio = columnas / 3;

        for (int f = 0; f < filas; f++) {
            char letra = (char) ('A' + f);
            List<String> row = new ArrayList<>();

            for (int c = 1; c <= columnas; c++) {
                if (c == tercio + 1 || c == (2 * tercio) + 1) {
                    row.add(null); // pasillos
                }
                row.add(letra + String.valueOf(c));
            }

            grid.add(row);
        }

        return new Sala(nombre, grid);
    }
	
	public static boolean esPasillo(String asientoId) {
	    return asientoId == null;
	}
}