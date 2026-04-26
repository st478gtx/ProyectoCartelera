package com.proyecto.modelo;

import java.util.ArrayList;

public class Alimento {
	public String nombre;
	public String descripcion;
	public String ruta;

	public Alimento(String nombre, String descripcion, String ruta, double d) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ruta = ruta;
	}
	
	public static ArrayList<Alimento> comboAlimento(){
		ArrayList<Alimento> combos = new ArrayList<>();
		
		combos.add(new Alimento("COMBO DUO", "74.80 COMBO DUO", "resources/alimentos/combos/15453-1765903024362.png", 0));
		combos.add(new Alimento("COMBO TRIO", "3 Popcorn grande + 3 gaseosas", "resources/alimentos/combos/14588-1752610832530.png", 89.90));
        combos.add(new Alimento("COMBO FRANKFURTER", "Frankfurter + gaseosa mediana", "resources/alimentos/combos/528-1755100170631.png", 31.80));
        combos.add(new Alimento("COMBO DUO", "74.80 COMBO DUO", "resources/alimentos/combos/15453-1765903024362.png", 0));
		//TODO: Completar 5 más
		return combos;
	}
	
	public static ArrayList<Alimento> comboSnacks(){
		ArrayList<Alimento> snacks = new ArrayList<>();
		snacks.add(new Alimento("POPCORN PEQUEÑO", "Popcorn tamaño pequeño", "resources/alimentos/combos/528-1755100170631.png", 15.90));
        snacks.add(new Alimento("POPCORN MEDIANO", "Popcorn tamaño mediano", "resources/alimentos/combos/14588-1752610832530.png", 22.90));
        snacks.add(new Alimento("POPCORN GRANDE", "Popcorn tamaño grande", "resources/alimentos/combos/15453-1765903024362.png", 29.90));
		//TODO: Completar 6 más
		//snacks.add(new Alimento("COMBO DUO", "74.80 COMBO DUO", "resources/alimentos/combos/15453-1765903024362.png"));
		
		return snacks;
	}
	
	public static ArrayList<Alimento> comboBebidas(){
		ArrayList<Alimento> bebidas = new ArrayList<>();	
        bebidas.add(new Alimento("GASEOSA PEQUEÑA", "Gaseosa 300ml", "resources/alimentos/combos/528-1755100170631.png", 10.00));
        bebidas.add(new Alimento("GASEOSA MEDIANA", "Gaseosa 500ml", "resources/alimentos/combos/14588-1752610832530.png", 14.00));
        bebidas.add(new Alimento("GASEOSA GRANDE", "Gaseosa 700ml", "resources/alimentos/combos/15453-1765903024362.png", 18.00));
		//TODO: Completar 6 más
		//bebidas.add(new Alimento("COMBO DUO", "74.80 COMBO DUO", "resources/alimentos/combos/15453-1765903024362.png"));
		
		return bebidas;
	}
	
}
