package com.proyecto;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JPanel PanelAsientos;

	ArrayList<JCheckBox> todosAsientos = new ArrayList<>();
	private static Set<String> selectedAsientos = new HashSet<>();
	private JButton btnConfirm;
	private JButton btnNewButton_2;

	private JCheckBox asiento;
	private String asientoId = "";

	// Cambiar dinamico
	int limiteAsientos = 3;
	Set<String> asientosOcupados = Set.of("A3", "B5", "C2");
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Elige asientos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(685, 11, 89, 23);
		contentPane.add(btnNewButton);

		int filas = 5;
		int columnas = 8;
		int columnaPasillo = 4;

		PanelAsientos = new JPanel();
		PanelAsientos.setBounds(51, 112, 662, 413);
		contentPane.add(PanelAsientos);
		PanelAsientos.setLayout(new GridLayout(filas, columnas + 1, 5, 5));

		btnConfirm = new JButton("Confirmar asientos");
		btnConfirm.addActionListener(this);
		btnConfirm.setBounds(556, 582, 137, 23);
		contentPane.add(btnConfirm);

		btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(51, 582, 89, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("PANTALLA");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(51, 38, 662, 48);
		contentPane.add(lblNewLabel);

		generarAsientos(filas, columnas, columnaPasillo);

	}

	private void generarAsientos(int filas, int columnas, int columnaPasillo) {
		/*
		 * A1 A2 * A3
		 * 
		 * B1 B2 * B3
		 * 
		 * C1 C2 * C3
		 * 
		 * D1 D2 * D3
		 * 
		 * 
		 */

		for (int fila = 0; fila < filas; fila++) {

			for (int col = 0; col < columnas + 1; col++) {

				if (col == columnaPasillo) {
					JLabel espacio = new JLabel();
					espacio.setOpaque(true);
					espacio.setBackground(Color.BLACK);
					PanelAsientos.add(espacio);
					continue;
				}

				int columnaReal = encontrarColumnaReal(col, columnaPasillo);

				crearAsientos(fila, columnaReal);
			}

		}
	}

	private void crearAsientos(int fila, int columnaReal) {
		asientoId = (char) ('A' + fila) + String.valueOf(columnaReal + 1);
		asiento = new JCheckBox(asientoId);
		
		if (asientosOcupados.contains(asientoId)) {
		    asiento.setEnabled(false);
		    asiento.setSelected(true);
		    asiento.setBackground(Color.RED);
		    asiento.setOpaque(true);
		}

		todosAsientos.add(asiento);

		String idFinal = asientoId;

		asiento.addActionListener(e -> manejarSeleccion(e, idFinal));

		PanelAsientos.add(asiento);
	}

	/*
	 * Ingresar columna actual y ubicacion de columna pasillo
	 */

	int encontrarColumnaReal(int col, int colPasillo) {
		int colFinal = 0;

		// para controlar el pasillo
		// si columna es mayor a la ubicacion del pasillo resta 1 para numerar el salto
		// sino se mantiene la numeracion normal

		if (col > colPasillo) {
			colFinal = col - 1;
		} else {
			colFinal = col;
		}

		return colFinal;
	}

	private void manejarSeleccion(ActionEvent e, String asientoId) {
		JCheckBox asiento = (JCheckBox) e.getSource();
		
		 if (asientosOcupados.contains(asientoId)) {
	            asiento.setSelected(true);
	            return;
	        }

		if (asiento.isSelected()) {
			if (selectedAsientos.size() >= limiteAsientos) {
				asiento.setSelected(false);
				return;
			}
			selectedAsientos.add(asientoId);
			asiento.setBackground(Color.GREEN);
			asiento.setOpaque(true);
		} else {
			selectedAsientos.remove(asientoId);
			asiento.setOpaque(false);
            asiento.setBackground(null);
		}
		actualizarEstadoAsientos();
	}

	// habilitar asientos
	private void actualizarEstadoAsientos() {

		if (selectedAsientos.size() >= limiteAsientos) {

			for (JCheckBox asiento : todosAsientos) {

				String id = asiento.getText();

				if (!asientosOcupados.contains(id) && !asiento.isSelected()) {
					asiento.setEnabled(false);
				}
			}

		} else {

			for (JCheckBox asiento : todosAsientos) {

				String id = asiento.getText();

				if (!asientosOcupados.contains(id)) {

					asiento.setEnabled(true);
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(e);
		}
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		Secundario second = new Secundario();
		second.setSize(800, 720);
		second.setLocationRelativeTo(null);
		second.setVisible(true);
	}

	protected void actionPerformedBtnConfirm(ActionEvent e) {

		ArrayList<String> lista = new ArrayList<>(selectedAsientos);
		Collections.sort(lista);
		String asientos = String.join(", ", lista);

		JOptionPane.showMessageDialog(PanelAsientos, "numero de asientos elegidos " + asientos, "Elegidos",
				JOptionPane.INFORMATION_MESSAGE);

	}
	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		dispose();
	}
}
