package com.proyecto.modelo;

import java.util.ArrayList;

public class Alimento {
	public String nombre;
	public String descripcion;
	public String ruta;

	public Alimento(String nombre, String descripcion, String ruta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ruta = ruta;
	}
	
	public static ArrayList<Alimento> comboAlimento(){
		ArrayList<Alimento> combos = new ArrayList<>();
		
		combos.add(new Alimento("COMBO DUO", "74.80 COMBO DUO", "resources/alimentos/combos/15453-1765903024362.png"));
		//TODO: Completar 5 más
		return combos;
	}
	
	public static ArrayList<Alimento> comboSnacks(){
		ArrayList<Alimento> snacks = new ArrayList<>();
		//TODO: Completar 6 más
		//snacks.add(new Alimento("COMBO DUO", "74.80 COMBO DUO", "resources/alimentos/combos/15453-1765903024362.png"));
		
		return snacks;
	}
	
	public static ArrayList<Alimento> comboBebidas(){
		ArrayList<Alimento> bebidas = new ArrayList<>();
		//TODO: Completar 6 más
		//bebidas.add(new Alimento("COMBO DUO", "74.80 COMBO DUO", "resources/alimentos/combos/15453-1765903024362.png"));
		
		return bebidas;
	}
	
}
