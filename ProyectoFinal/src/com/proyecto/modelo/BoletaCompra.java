package com.proyecto.modelo;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;



public class BoletaCompra {
	public Usuario usuario;
	public Cartelera pelicula;
	public Funcion funcion;
	public Set<String> boletos;
	public Map<Alimento, Integer> carrito = new LinkedHashMap<>();
	public double subTotal;

	public BoletaCompra(Usuario usuario, Cartelera pelicula, Funcion funcion, Set<String> boletos) {
		this.usuario = usuario;
		this.pelicula = pelicula;
		this.funcion = funcion;
		this.boletos = boletos;
	}
	
	public double calcularDescuento(int cantidad, double subtotal) {		
        if (cantidad == 1)
        	return subtotal * 0.075;
        else if (cantidad <= 4)
        	return subtotal * 0.10;
        else if (cantidad <= 7)
        	return subtotal * 0.125;
        else
        	return subtotal * 0.15;
    }

    public double calcularPorcentaje(int cantidad) {
        if (cantidad == 1)
        	return 7.5;
        else if (cantidad <= 4)
        	return 10.0;
        else if (cantidad <= 7)
        	return 12.5;
        else
        	return 15.0;
    }
    
    public String formatoPrecio(Double price) {
		Locale peru = new Locale.Builder()
	            .setLanguage("es")
	            .setRegion("PE")
	            .build();
		
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(peru);
		return currencyFormatter.format(price);
	}
}
