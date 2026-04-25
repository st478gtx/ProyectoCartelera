package com.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	public String usuario;
	public String contraseña;

	List<Usuario> usuarios = new ArrayList<>();
	
	String usuarioActual = "";

	public Usuario(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public Usuario() {}

	public boolean esUsuarioValido(String usuario, String contraseña) {
		for (var user : usuarios) {
			if (usuario.equals(user.usuario) && contraseña.equals(user.contraseña)) {
				usuarioActual = user.usuario;
				return true;
			}
		}
		return false;
	}
	
	public String getUsuarioLogueado() {
		return usuarioActual;
	}
	
	public void logout () {
		usuarioActual = "";
	}

	public List<Usuario> usuariosIniciales() {

		Usuario user1 = new Usuario("marco", "1234");
		Usuario user2 = new Usuario("felix", "12345");

		usuarios.add(user1);
		usuarios.add(user2);

		return usuarios;
	}

}
