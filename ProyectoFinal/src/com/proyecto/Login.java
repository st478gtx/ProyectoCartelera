package com.proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.proyecto.modelo.Usuario;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField userTxtF;
	private JPasswordField passwordPwF;
	private JButton ingresarBtn;
	private JLabel tituloLbl;
	private JLabel subtituloLbl;
	private JLabel userLbl;
	private JLabel passwordLbl;
	private JLabel errorLbl;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(() -> { try {
	 * Login frame = new Login(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } }); }
	 */

	public Login(InicioCartelera ventanaCartelera, Usuario usuarioBD) {
		cardLoginInicio(ventanaCartelera, usuarioBD);
	}

	private void cardLoginInicio(InicioCartelera ventanaCartelera, Usuario usuarioBD) {
		setTitle("Iniciar sesión");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(398, 408);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 30, 30));
		contentPane.setBorder(new EmptyBorder(20, 40, 20, 40));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Título
		tituloLbl = new JLabel("CINEMARK");
		tituloLbl.setFont(new Font("Segoe UI", Font.BOLD, 36));
		tituloLbl.setForeground(new Color(255, 128, 0));
		tituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLbl.setBounds(0, 30, 400, 50);
		contentPane.add(tituloLbl);

		subtituloLbl = new JLabel("Bienvenido, inicia sesión para continuar");
		subtituloLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		subtituloLbl.setForeground(Color.LIGHT_GRAY);
		subtituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
		subtituloLbl.setBounds(0, 85, 400, 20);
		contentPane.add(subtituloLbl);

		// Label usuario
		userLbl = new JLabel("Usuario");
		userLbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		userLbl.setForeground(Color.WHITE);
		userLbl.setBounds(40, 130, 100, 20);
		contentPane.add(userLbl);

		// Campo usuario
		userTxtF = new JTextField();
		userTxtF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		userTxtF.setBounds(40, 152, 300, 38);
		userTxtF.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(new Color(255, 128, 0)),
				javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		contentPane.add(userTxtF);

		// Label password
		passwordLbl = new JLabel("Contraseña");
		passwordLbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		passwordLbl.setForeground(Color.WHITE);
		passwordLbl.setBounds(40, 205, 100, 20);
		contentPane.add(passwordLbl);

		// Campo password
		passwordPwF = new JPasswordField();
		passwordPwF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordPwF.setBounds(40, 227, 300, 38);
		passwordPwF.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(new Color(255, 128, 0)),
				javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		// También ingresar con Enter desde el campo password
		passwordPwF.addActionListener(e -> validarLogin(usuarioBD, ventanaCartelera));
		contentPane.add(passwordPwF);

		// Label error (oculto por defecto)
		errorLbl = new JLabel("");
		errorLbl.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		errorLbl.setForeground(new Color(220, 50, 50));
		errorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		errorLbl.setBounds(0, 272, 400, 20);
		contentPane.add(errorLbl);

		// Botón ingresar
		ingresarBtn = new JButton("INGRESAR");
		ingresarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ingresarBtn.setBackground(new Color(255, 128, 0));
		ingresarBtn.setForeground(Color.WHITE);
		ingresarBtn.setBounds(40, 298, 300, 42);
		ingresarBtn.setFocusPainted(false);
		ingresarBtn.setBorder(null);
		ingresarBtn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		ingresarBtn.addActionListener(e -> validarLogin(usuarioBD, ventanaCartelera));
		contentPane.add(ingresarBtn);
	}

	private void validarLogin(Usuario usuarioBD, InicioCartelera ventanaCartelera) {
		String usuario = userTxtF.getText().trim();
		String password = new String(passwordPwF.getPassword()).trim();

		if (usuario.isEmpty() || password.isEmpty()) {
			errorLbl.setText("Por favor completa todos los campos.");
			return;
		}

		if (usuarioBD.esUsuarioValido(usuario, password)) {
			// Login exitoso,  abre cartelera y cierra login
			ventanaCartelera.usuarioLogueado();
			ventanaCartelera.buttomLogout();
			dispose();
		} else {
			errorLbl.setText("Usuario o contraseña incorrectos.");
			passwordPwF.setText("");
		}
	}
}
