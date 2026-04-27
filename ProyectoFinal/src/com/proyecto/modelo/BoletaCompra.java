package com.proyecto.modelo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BoletaCompra {
	public Usuario usuario;
	public Cartelera pelicula;
	public Funcion funcion;
	public Set<String> boletos;
	public Map<Alimento, Integer> carrito = new LinkedHashMap<>();
	public String subTotal;

	public BoletaCompra(Usuario usuario, Cartelera pelicula, Funcion funcion, Set<String> boletos) {
		this.usuario = usuario;
		this.pelicula = pelicula;
		this.funcion = funcion;
		this.boletos = boletos;
	}

}
