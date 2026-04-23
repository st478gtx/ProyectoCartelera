package com.proyecto.modelo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Funcion {

	Cartelera pelicula;
	public String hora;
	public Sala sala;
	public Map<String, Asiento> asientos;

	public Funcion(Cartelera pelicula, String hora, Sala sala) {
		this.pelicula = pelicula;
		this.hora = hora;
		this.sala = sala;
		this.asientos = generarAsientosDesdeSala(sala);
	}	
	
	private Map<String, Asiento> generarAsientosDesdeSala(Sala sala) {

        Map<String, Asiento> mapa = new LinkedHashMap<>();

        for (List<String> fila : sala.distribucion) {
            for (String asientoId : fila) {

                if (asientoId == null) continue; // ignorar pasillos

                mapa.put(asientoId, new Asiento(asientoId));
            }
        }

        return mapa;
    }
}
