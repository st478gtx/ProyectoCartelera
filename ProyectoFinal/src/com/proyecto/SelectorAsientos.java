package com.proyecto;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import com.proyecto.modelo.Usuario;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SelectorAsientos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblFuncionTitulo;
	private JButton btnContinuar;
	private JLabel lblNewLabel_1;

	private static Set<String> selectedAsientos = new LinkedHashSet<>();
	ArrayList<JCheckBox> todosAsientos = new ArrayList<>();
	int limiteAsientos = 0;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SelectorAsientos frame = new
	 * SelectorAsientos(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public SelectorAsientos(Usuario usuario, int nroAsiento, Funcion horario, Cartelera pelicula) {
		setTitle(horario.sala.nombre);

		limiteAsientos = nroAsiento;

		Funcion funcion = horario;

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
		btnContinuar.addActionListener(this);
		btnContinuar.setEnabled(false);
		btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnContinuar.setFocusPainted(false);
		btnContinuar.setBorder(null);
		btnContinuar.setBackground(Color.ORANGE);
		btnContinuar.setBounds(651, 615, 123, 23);
		contentPane.add(btnContinuar);

		lblNewLabel_1 = new JLabel("LIMITE DE ASIENTOS : " + nroAsiento);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 605, 206, 41);
		contentPane.add(lblNewLabel_1);

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

				todosAsientos.add(btn);

				if (asiento.ocupado) {
					btn.setEnabled(false);
				}

				btn.addActionListener(e -> manejarSeleccion(e, asientoId));

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

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				resetAsientos();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				resetAsientos();
			}
		});

	}

	private void manejarSeleccion(ActionEvent e, String asientoId) {
		JCheckBox asiento = (JCheckBox) e.getSource();
		// if (asientosOcupados.contains(asientoId)) {
		// asiento.setSelected(true);
		// return;
		// }

		if (asiento.isSelected()) {
			if (selectedAsientos.size() >= limiteAsientos) {
				asiento.setSelected(false);
				return;
			}
			selectedAsientos.add(asientoId);
			asiento.setBackground(new Color(0, 128, 128));
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

				// if (!asientosOcupados.contains(id) && !asiento.isSelected()) {
				// asiento.setEnabled(false);
				// }
				if (!asiento.isSelected()) {
					asiento.setEnabled(false);
				}
			}

		} else {

			for (JCheckBox asiento : todosAsientos) {

				String id = asiento.getText();

				// if (!asientosOcupados.contains(id)) {

				asiento.setEnabled(true);
				// }
			}
		}

		if (selectedAsientos.size() == limiteAsientos) {
			btnContinuar.setEnabled(true);
		}
	}

	void irAlimentos() {
		SelectorAlimentos alimentos = new SelectorAlimentos();
		alimentos.setSize(800, 720);
		alimentos.setLocationRelativeTo(null);
		alimentos.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnContinuar) {
			actionPerformedBtnContinuar(e);
		}
	}

	protected void actionPerformedBtnContinuar(ActionEvent e) {
		irAlimentos();
	}

	private void resetAsientos() {
		limiteAsientos = 0;
		selectedAsientos.clear();
		todosAsientos.clear();
	}
}
