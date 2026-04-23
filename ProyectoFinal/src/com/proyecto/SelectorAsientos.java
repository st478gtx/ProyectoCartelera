package com.proyecto;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proyecto.modelo.Asiento;
import com.proyecto.modelo.Cartelera;
import com.proyecto.modelo.Funcion;
import com.proyecto.modelo.Sala;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SelectorAsientos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectorAsientos frame = new SelectorAsientos();
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
	public SelectorAsientos() {
		
		Set<String> seleccionados = new HashSet<>();
		ArrayList<Cartelera> peliculas = Cartelera.listPeliculas();
		
		Sala sala1 = Sala.crearSalaDoblePasillo("Sala normal", 5, 8);
		
		Funcion funcion = new Funcion(peliculas.get(0), "18:00", sala1);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 141, 764, 412);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 8, 0, 0));
		
		lblNewLabel = new JLabel("PANTALLA");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 33, 764, 48);
		contentPane.add(lblNewLabel);
		
		for (List<String> fila : funcion.sala.distribucion) {
		    for (String asientoId : fila) {

		        if (asientoId == null) {
		            panel.add(Box.createHorizontalStrut(20)); // espacio pasillo
		            continue;
		        }
		        
		        Asiento asiento = funcion.asientos.get(asientoId);

		        JCheckBox btn = new JCheckBox(asientoId);
		        
		        if (asiento.ocupado) {
		        	btn.setEnabled(false);
		        }
		        
		        panel.add(btn);
		    }
		}
		
		/*
		 * for (var asiento : funcion.asientos.values()) { JCheckBox btn = new
		 * JCheckBox(asiento.id);
		 * 
		 * if (asiento.ocupado) { btn.setEnabled(false); btn.setBackground(Color.RED); }
		 * 
		 * btn.addActionListener(e -> { if (btn.isSelected()) {
		 * seleccionados.add(asiento.id); } else { seleccionados.remove(asiento.id); }
		 * });
		 * 
		 * panel.add(btn); }
		 */

	}

}
