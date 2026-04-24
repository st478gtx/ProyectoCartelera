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
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(null);
		panel.setBounds(518, 142, 256, 247);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		generarHorarios(pelicula);		
		
		
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
		
		lblFuncionTitulo = new JLabel("   " + pelicula.tituloNormal);
		lblFuncionTitulo.setOpaque(true);
		lblFuncionTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblFuncionTitulo.setBackground(new Color(255, 128, 64));
		lblFuncionTitulo.setBounds(0, 0, 784, 63);
		contentPane.add(lblFuncionTitulo);

	}

	private void generarHorarios(Cartelera pelicula) {
		for (var horario : pelicula.funciones) {
			JLabel hora = new JLabel(horario.hora);
			hora.setHorizontalAlignment(SwingConstants.CENTER);
			hora.setBackground(new Color(255, 128, 64));
			hora.setPreferredSize(new Dimension(120,40));
			hora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			hora.setOpaque(true);
			hora.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			hora.addMouseListener(
					labelClick(horario)
			);
			
			panel.add(hora);
		}
	}

	private MouseAdapter labelClick(Funcion horario) {
		return new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	SelectorAsientos asiento = new SelectorAsientos();
		        asiento.setSize(800, 720);
				asiento.setLocationRelativeTo(null);
		        asiento.setVisible(true);
		    }

		    @Override
		    public void mouseEntered(MouseEvent e) {
		        
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        
		    }
		};
	}
	
	private ImageIcon imagenProcesada(String ruta) {
		ImageIcon original = new ImageIcon(ruta);
		Image scale = original.getImage().getScaledInstance(240, 340, Image.SCALE_SMOOTH);
		ImageIcon imageScale = new ImageIcon(scale);
		return imageScale;
	}
}
