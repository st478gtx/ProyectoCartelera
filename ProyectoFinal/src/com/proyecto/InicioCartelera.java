package com.proyecto;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.proyecto.modelo.Cartelera;
import com.proyecto.modelo.Usuario;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioCartelera extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogin;

	ArrayList<Cartelera> peliculas;
	private JLabel lblCabecera;
	private JScrollPane scrollPane;
	private JPanel panel_content;

	Usuario usuario;
	private JLabel lblUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioCartelera frame = new InicioCartelera();
					frame.setSize(800, 720);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioCartelera() {

		peliculas = Cartelera.listPeliculas();
		
		// Crea el usuario y carga los usuarios del sistema
		usuario = new Usuario();
		usuario.usuariosIniciales();

		setTitle("Seleccionar Película");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnLogin = new JButton("Ingresar");
		btnLogin.addActionListener(this);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setBounds(685, 11, 89, 23);
		contentPane.add(btnLogin);

		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 92, 784, 519);
		scrollPane.setBackground(null);
		contentPane.add(scrollPane);

		panel_content = new JPanel();
		panel_content.setBorder(null);
		scrollPane.setViewportView(panel_content);
		panel_content.setBackground(Color.DARK_GRAY);
		panel_content.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

		lblUsuario = new JLabel("");
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblUsuario.setBounds(571, 11, 105, 23);
		contentPane.add(lblUsuario);

		lblCabecera = new JLabel("  CARTELERA");
		lblCabecera.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblCabecera.setBackground(new Color(255, 128, 64));
		lblCabecera.setOpaque(true);
		lblCabecera.setBounds(0, 0, 784, 63);
		contentPane.add(lblCabecera);

		cargarPeliculas();

	}

	private void cargarPeliculas() {
		// Recorre la lista y crea una tarjeta visual por cada pelicula
		for (int i = 0; i < peliculas.size(); i++) {
			Cartelera pelicula = peliculas.get(i);
			panel_content.add(crearTarjeta(pelicula));
		}
	}

	private JPanel crearTarjeta(Cartelera pelicula) {

		// Panel principal de la tarjeta
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setPreferredSize(new Dimension(220, 390));
		card.setBackground(new Color(40, 40, 40));
		card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Carga y escala la imagen de la pelicula
		ImageIcon original = new ImageIcon(pelicula.ruta);
		Image scale = original.getImage().getScaledInstance(200, 280, Image.SCALE_SMOOTH);
		JLabel img = new JLabel(new ImageIcon(scale));
		img.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Label con el titulo de la pelicula
		JLabel titulo = new JLabel(pelicula.titulo);
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titulo.setPreferredSize(new Dimension(250, 55));
		titulo.setMinimumSize(new Dimension(200, 55));
		titulo.setMaximumSize(new Dimension(200, 55));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Label con la duracion de la pelicula
		JLabel duracion = new JLabel(pelicula.duracion);
		duracion.setForeground(Color.LIGHT_GRAY);
		duracion.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Agrega los componentes a la tarjeta
		card.add(Box.createVerticalGlue());
		card.add(img);
		card.add(Box.createVerticalStrut(10));
		card.add(titulo);
		card.add(Box.createVerticalStrut(5));
		card.add(duracion);
		card.add(Box.createVerticalGlue());

		// Evento: al hacer clic en la tarjeta abre la ventana de horarios
		card.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				SelectorFuncion funcion = new SelectorFuncion(pelicula, usuario);
				funcion.setSize(800, 720);
				funcion.setLocationRelativeTo(null);
				funcion.setVisible(true);
			}
		});

		return card;
	}

	public void actionPerformed(ActionEvent e) {
		// Detecta cual boton fue presionado
		if (e.getSource() == btnLogin) {
			actionPerformedBtnLogin(e);
		}
	}

	protected void actionPerformedBtnLogin(ActionEvent e) {
		// Crea la ventana de login pasando esta ventana y el usuario
		Login login = new Login(this, usuario);

		// Si ya esta logueado cierra sesion, si no abre el login
		if (btnLogin.getText().equals("Salir")) {
			buttomLogin();
		} else {
			login.setVisible(true);
		}
	}

	public void usuarioLogueado() {
		lblUsuario.setText("Hola " + usuario.getUsuarioLogueado());
	}
	
	public void buttomLogout() {
		btnLogin.setText("Salir");
	}
	
	public void buttomLogin() {
		lblUsuario.setText("");
		btnLogin.setText("Ingresar");
		usuario.logout();
	}
}
