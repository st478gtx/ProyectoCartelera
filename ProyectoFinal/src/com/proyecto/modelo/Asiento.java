package com.proyecto.modelo;

public class Asiento {
	public String id;
	public boolean ocupado;

	public Asiento(String id, boolean ocupado) {
		this.id = id;
		this.ocupado = ocupado;
	}
	
	public Asiento(String id) {
        this.id = id;
        this.ocupado = false;
    }
}
