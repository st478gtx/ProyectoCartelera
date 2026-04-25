package com.proyecto;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proyecto.modelo.Cartelera;
import com.proyecto.modelo.Funcion;
import com.proyecto.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class SelectorFuncion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImageCartelera;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblFuncionTitulo;
	private JLabel lblDescripcion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblUsuario;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SelectorFuncion frame = new
	 * SelectorFuncion(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public SelectorFuncion(Cartelera pelicula, Usuario usuario) {
		setTitle("Funcion seleccionada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(null);
		panel.setBounds(518, 142, 256, 528);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		generarHorarios(pelicula, usuario);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(null);
		panel_1.setBounds(10, 74, 498, 596);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblImageCartelera = new JLabel(imagenProcesada(pelicula.ruta));
		lblImageCartelera.setBounds(10, 11, 240, 340);
		panel_1.add(lblImageCartelera);

		lblDescripcion = new JLabel(pelicula.descripcion);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(0, 362, 260, 223);
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDescripcion.setForeground(Color.white);
		panel_1.add(lblDescripcion);

		lblNewLabel_1 = new JLabel("DURACIÓN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(260, 11, 103, 41);
		panel_1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("FECHA DE ESTRENO");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2.setBounds(260, 75, 204, 41);
		panel_1.add(lblNewLabel_2);

		lblNewLabel = new JLabel("Horarios");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(518, 96, 256, 34);
		contentPane.add(lblNewLabel);

		lblUsuario = new JLabel(usuario.getUsuarioLogueado());
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblUsuario.setBounds(669, 22, 105, 23);
		contentPane.add(lblUsuario);

		lblFuncionTitulo = new JLabel("   " + pelicula.tituloNormal);
		lblFuncionTitulo.setOpaque(true);
		lblFuncionTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblFuncionTitulo.setBackground(new Color(255, 128, 64));
		lblFuncionTitulo.setBounds(0, 0, 784, 63);
		contentPane.add(lblFuncionTitulo);
	}

	private void generarHorarios(Cartelera pelicula, Usuario usuario) {
		for (var horario : pelicula.funciones) {
			
			panel.add(crearTarjetaHorario(usuario, horario));
		}
	}

	private JPanel crearTarjetaHorario(Usuario usuario, Funcion horario) {
		
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.X_AXIS));
		card.setPreferredSize(new Dimension(220, 100));
		card.setBackground(new Color(40, 40, 40));
		card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));		
		//Sala
		JLabel sala = new JLabel(horario.sala.nombre);
		sala.setForeground(Color.white);
		sala.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		
		//Horario
		JLabel hora = new JLabel(horario.hora);
		hora.setHorizontalAlignment(SwingConstants.CENTER);
		hora.setBackground(new Color(255, 128, 64));
		hora.setPreferredSize(new Dimension(120, 40));
		hora.setOpaque(true);
		hora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		card.add(Box.createVerticalGlue());
		card.add(sala);
		card.add(Box.createVerticalStrut(10));
		card.add(hora);
		card.add(Box.createVerticalGlue());

		hora.addMouseListener(labelClick(horario, usuario));
		
		return card;
	}

	private MouseAdapter labelClick(Funcion horario, Usuario usuario) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (usuario.getUsuarioLogueado().equals("")) {
					mensajeCompra();
				} else {
					abrirSelectorAsientos();
				}
			}
		};
	}

	private ImageIcon imagenProcesada(String ruta) {
		ImageIcon original = new ImageIcon(ruta);
		Image scale = original.getImage().getScaledInstance(240, 340, Image.SCALE_SMOOTH);
		ImageIcon imageScale = new ImageIcon(scale);
		return imageScale;
	}

	public void abrirSelectorAsientos() {
		SelectorAsientos asiento = new SelectorAsientos();
		asiento.setSize(800, 720);
		asiento.setLocationRelativeTo(null);
		asiento.setVisible(true);
	}

	public void usuarioLogueado(String usuario) {
		lblUsuario.setText(usuario);
	}

	public void mensajeCompra() {
		dispose();
		JOptionPane.showMessageDialog(null, "Necesitas loguearte para poder comprar.");
	}
}
