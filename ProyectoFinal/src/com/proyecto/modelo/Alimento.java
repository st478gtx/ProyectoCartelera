package com.proyecto.modelo;

import java.util.ArrayList;

public class Alimento {
	public String nombre;
	public String descripcion;
	public String ruta;
	public double precio;

	public Alimento(String nombre, String descripcion, String ruta, double d) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ruta = ruta;
		this.precio = d;
	}
	
	public static ArrayList<Alimento> comboAlimento(){
		ArrayList<Alimento> combos = new ArrayList<>();
		combos.add(new Alimento("COMBO DUO", "S/ 74.80 - 2 Popcorn grandes + 2 gaseosas", "resources/alimentos/combos/15453-1765903024362.png", 74.80));
	    combos.add(new Alimento("COMBO TRIO", "S/ 89.90 - 3 Popcorn grandes + 3 gaseosas", "resources/alimentos/combos/14588-1752610832530.png", 89.90));
	    combos.add(new Alimento("COMBO FRANKFURTER", "S/ 31.80 - Hot Dog + gaseosa mediana", "resources/alimentos/combos/528-1755100170631.png", 31.80));
	 	combos.add(new Alimento("COMBO PERSONAL", "S/ 36.20 - 1 Canchita Mediana Salada + 1 Gaseosa Mediana", "resources/alimentos/combos/combo_personal", 36.20));
	    combos.add(new Alimento("COMBO GIGANTE", "S/ 67.90 - 2 Gaseosas medianas + 1 Cancha gigante salada", "resources/alimentos/combos/combo_gigantee", 67.90));
	    combos.add(new Alimento("COMBO PAREJA", "S/ 55.30 - 1 Canchita Grande Salada + 2 Gaseosas Medianas", "resources/alimentos/combos/combo_pareja", 55.30));
       	
		return combos;
	}
	
	public static ArrayList<Alimento> comboSnacks(){
		ArrayList<Alimento> snacks = new ArrayList<>();
	
		snacks.add(new Alimento("CANCHITA MEDIANA SALADA", "S/ 18.10 - Canchita Mediana Salada", "resources/alimentos/snacks/mediana_salada.png", 18.10));
		snacks.add(new Alimento("CANCHITA MEDIANA DULCE", "S/ 22.10 - Canchita Mediana Dulce", "resources/alimentos/snacks/mediana_dulce.png", 22.10));
		snacks.add(new Alimento("CANCHITA MEDIANA MIXTA", "S/ 22.10 - Canchita Mediana Mixta", "resources/alimentos/snacks/mediana_mixta.png", 22.10));
		snacks.add(new Alimento("CANCHITA GRANDE SALADA", "S/ 19.10 - Canchita Grande Salada", "resources/alimentos/snacks/grande_salada.png", 19.10));
		snacks.add(new Alimento("CANCHITA GRANDE DULCE", "S/ 23.10 - Canchita Grande Dulce", "resources/alimentos/snacks/grande_dulce.png", 23.10));
		snacks.add(new Alimento("CANCHITA GRANDE MIXTA", "S/ 23.10 - Canchita Grande Mixta", "resources/alimentos/snacks/grande_mixta.png", 23.10));
		return snacks;
	}
	
	public static ArrayList<Alimento> comboBebidas(){
		ArrayList<Alimento> bebidas = new ArrayList<>();	
		
		bebidas.add(new Alimento("GASEOSA GRANDE", "S/ 19.10 - Gaseosa sabor original", "resources/alimentos/bebidas/gaseosa_grande.png", 19.10));
		bebidas.add(new Alimento("GASEOSA MEDIANA", "S/ 12.60 - Gaseosa sabor original", "resources/alimentos/bebidas/gaseosa_mediana.png", 12.60));
		bebidas.add(new Alimento("AGUA SIN GAS", "S/ 6.00 - Agua San Luis mineral", "resources/alimentos/bebidas/agua_sin_gas.png", 6.00));
		bebidas.add(new Alimento("FRUGOS X 300ML", "S/ 7.00 - Del Valle néctar de fruta", "resources/alimentos/bebidas/frugos.png", 7.00));
		bebidas.add(new Alimento("CHICHA MEDIANA", "S/ 18.10 *Chicha mediana", "resources/alimentos/bebidas/chicha_mediana.png", 18.10));
		bebidas.add(new Alimento("CHICHA GRANDE", "S/ 19.10 *Chicha grande", "resources/alimentos/bebidas/chicha_grande.png", 19.10));
		return bebidas;
	}
	
}
