package com.proyecto;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proyecto.modelo.Cartelera;
import com.proyecto.modelo.Funcion;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class SelectorFuncion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImageCartelera;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;

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
	public SelectorFuncion(Cartelera pelicula) {
		setTitle("Funcion seleccionada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(539, 124, 235, 247);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		for (var horario : pelicula.funciones) {
			JLabel hora = new JLabel(horario.hora);
			hora.setHorizontalAlignment(SwingConstants.CENTER);
			hora.setBackground(new Color(255, 128, 64));
			hora.setOpaque(true);
			hora.setFont(new Font("Tahoma", Font.PLAIN, 20));
			panel.add(hora);
		}
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 39, 397, 420);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblImageCartelera = new JLabel(imagenProcesada(pelicula.ruta));
		lblImageCartelera.setBounds(10, 11, 240, 340);
		panel_1.add(lblImageCartelera);
		
		lblNewLabel = new JLabel("Horarios");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(556, 75, 190, 34);
		contentPane.add(lblNewLabel);

	}
	
	private ImageIcon imagenProcesada(String ruta) {
		ImageIcon original = new ImageIcon(ruta);
		Image scale = original.getImage().getScaledInstance(240, 340, Image.SCALE_SMOOTH);
		ImageIcon imageScale = new ImageIcon(scale);
		return imageScale;
	}
}
