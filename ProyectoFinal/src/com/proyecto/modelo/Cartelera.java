package com.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cartelera {

	public String titulo;
	public String tituloNormal = "";
	public String descripcion;
	public String ruta;
	public String duracion;
	
	public List<Funcion> funciones; 

	public Cartelera(String titulo, String descripcion, String ruta, String duracion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.ruta = ruta;
		this.duracion = duracion;
		this.funciones = new ArrayList<>();
	}

	public static ArrayList<Cartelera> listPeliculas() {
		ArrayList<Cartelera> peliculas = new ArrayList<>();
		
		Sala sala1 = Sala.crearSalaSimple("Sala 1", 5, 6);
	    Sala sala2 = Sala.crearSalaConPasillo("Sala 2", 5, 8);
	    Sala sala3 = Sala.crearSalaSimple("Sala SD", 5, 8);
	    Sala sala4 = Sala.crearSalaConPasillo("Sala 3 3D", 5, 8);
	    Sala sala5 = Sala.crearSalaConPasillo("Sala 4 3D", 5, 8);
	    Sala sala6 = Sala.crearSalaConPasillo("Sala 5 3D", 5, 8);
	    Sala salaXD = Sala.crearSalaDoblePasillo("Sala XD", 5, 10);
		
	    
	    Cartelera peli1 = new Cartelera("<html><div style='text-align:center;'>PROYECTO FIN DEL<br> MUNDO</div><html>",
				"<html><div style='text-align:justify;'>Un astronauta intenta salvar la Tierra estando solo en el espacio exterior.</div></html>",
				"resources/peliculas/HO00008354.jpg", "2h 36m");	    
	    
	    peli1.tituloNormal = "PROYECTO FIN DEL MUNDO";
	    peli1.funciones.add(new Funcion(peli1, "16:00", sala1));
	    peli1.funciones.add(new Funcion(peli1, "18:30", sala2));
	    peli1.funciones.add(new Funcion(peli1, "19:00", sala3));
	    peli1.funciones.add(new Funcion(peli1, "21:00", salaXD));
	    
	    peliculas.add(peli1);
	    
	    Cartelera peli2 = new Cartelera("<html><div style='text-align:center;'>CHAO LA SIRENA</div><html>",
				"<html><div style='text-align:justify;'>Ambientada en un mundo futurista donde humanos y sirenas coexisten,"
				+ " esta alocada comedia romántica con toques de fantasía sigue a un tranquilo "
				+ "oficinista llamado Stephan, cuya rutina se ve alterada cuando la princesa sirena "
				+ "ChaO le propone matrimonio inesperadamente. Un amor inesperado y genuino comenzará a forjarse.</div></html>",
				"resources/peliculas/HO00009113.jpg", "1h 30m");
	    
	    peli2.tituloNormal = "CHAO LA SIRENA";
	    peli2.funciones.add(new Funcion(peli2, "11:00", sala1));
	    peli2.funciones.add(new Funcion(peli2, "13:30", sala2));
	    peli2.funciones.add(new Funcion(peli2, "16:00", salaXD));
		
		peliculas.add(peli2);
		
		
		//MODIFICAR PELICULAS 3 - 6
		
		Cartelera peli3 = new Cartelera("<html><div style='text-align:center;'>MICHAEL</div><html>",
				"<html><div style='text-align:justify;'>Película biográfica sobre el rey del pop, Michael Jackson. Retratará al cantante desde sus inicios hasta su trágico fallecimiento en 2009.</div></html>",
				"resources/peliculas/HO00008584.jpg", "2h 10m");
	    
		peli3.tituloNormal = "MICHAEL";
	    peli3.funciones.add(new Funcion(peli3, "13:00", sala1));
	    peli3.funciones.add(new Funcion(peli3, "14:30", sala2));
	    peli3.funciones.add(new Funcion(peli3, "17:00", salaXD));
	    peli3.funciones.add(new Funcion(peli3, "17:10", sala3));
		
		peliculas.add(peli3);
		
		Cartelera peli4 = new Cartelera("<html><div style='text-align:center;'>MORTAL KOMBAT 2</div><html>",
				"<html><div style='text-align:justify;'>Los guerreros más queridos, incluyendo a Johnny Cage, luchan juntos en un combate definitivo contra el malvado Shao Kahn, cuyo reino amenaza con destruir la Tierra y a quienes la protegen.</div></html>",
				"resources/peliculas/HO00008691.jpg", "1h 56m");
	    
		peli4.tituloNormal = "MORTAL KOMBAT 2";
	    peli4.funciones.add(new Funcion(peli4, "17:00", sala4));
	    peli4.funciones.add(new Funcion(peli4, "15:30", sala5));
	    peli4.funciones.add(new Funcion(peli4, "19:00", sala6));
		
		peliculas.add(peli4);
		
		Cartelera peli5 = new Cartelera("<html><div style='text-align:center;'>JUGADA MAESTRA</div><html>",
				"<html><div style='text-align:justify;'>Becket Redfellow, el heredero de una fortuna multimillonaria que no se detendrá ante nada para conseguir lo que se merece o lo que él cree que se merece.</div></html>",
				"resources/peliculas/HO00008858.jpg", "1h 45m");
	    
		peli5.tituloNormal = "JUGADA MAESTRA";
	    peli5.funciones.add(new Funcion(peli5, "13:00", sala4));
	    peli5.funciones.add(new Funcion(peli5, "13:30", sala5));
	    peli5.funciones.add(new Funcion(peli5, "14:00", sala6));
		
		peliculas.add(peli5);
		
		Cartelera peli6 = new Cartelera("<html><div style='text-align:center;'>BOULEVARD</div><html>",
				"<html><div style='text-align:justify;'>Hasley, una chica con una lista de sueños sin cumplir, y Luke, un chico complejo y vulnerable marcado por un pasado trágico, encuentran en el boulevard un refugio donde descubrir si el amor puede vencerlo todo.</html>",
				"resources/peliculas/HO00009005.jpg", "1h 54m");
	    
		peli6.tituloNormal = "BOULEVARD";
	    peli6.funciones.add(new Funcion(peli6, "21:00", sala4));
	    peli6.funciones.add(new Funcion(peli6, "21:30", sala5));
	    peli6.funciones.add(new Funcion(peli6, "22:00", sala6));
		
		peliculas.add(peli6);
		
		

		return peliculas;
	}

}
