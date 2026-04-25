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
import javax.swing.JButton;

public class SelectorAsientos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblFuncionTitulo;
	private JButton btnContinuar;

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
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 141, 764, 412);
		panel.setBackground(null);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 8, 0, 0));
		
		lblNewLabel = new JLabel("PANTALLA");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(196, 196, 196));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(new Color(96, 96, 96));
		lblNewLabel.setBounds(10, 32, 764, 80);
		contentPane.add(lblNewLabel);
		
		btnContinuar = new JButton("CONTINUAR");
		btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnContinuar.setFocusPainted(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.ORANGE);
		btnContinuar.setBounds(651, 615, 123, 23);
		contentPane.add(btnContinuar);
		
		lblFuncionTitulo = new JLabel("");
		lblFuncionTitulo.setOpaque(true);
		lblFuncionTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblFuncionTitulo.setBackground(new Color(255, 128, 64));
		lblFuncionTitulo.setBounds(0, 598, 784, 63);
		contentPane.add(lblFuncionTitulo);
		
		for (List<String> fila : funcion.sala.distribucion) {
		    for (String asientoId : fila) {

		        if (asientoId == null) {
		            panel.add(Box.createHorizontalStrut(20)); // espacio pasillo
		            continue;
		        }
		        
		        Asiento asiento = funcion.asientos.get(asientoId);

		        JCheckBox btn = new JCheckBox(asientoId);
		        btn.setBackground(null);
		        btn.setForeground(Color.white);
		        
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
