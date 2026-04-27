package com.proyecto;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proyecto.modelo.Alimento;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JButton;

public class SelectorAlimentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JLabel lblAlimentos;

	ArrayList<Alimento> combos;
	ArrayList<Alimento> snacks;
	ArrayList<Alimento> bebidas;

	Map<Alimento, JPanel> agregados;

	private JScrollPane scrollPane;
	private JPanel panelCombo;
	private JPanel panelSnacks;
	private JPanel panelBebidas;

	private JButton btnComprar;
	private JScrollPane scrollPane_1;
	private JPanel panelAgregado;
	private JLabel lblNewLabel;
	private JLabel lblContadorAgregado;

	/**
	 * Launch the application.
	 */
	// TODO: Temporal, quitar al finalizar pruebas
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectorAlimentos frame = new SelectorAlimentos();
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
	public SelectorAlimentos() {

		combos = Alimento.comboAlimento();
		snacks = Alimento.comboSnacks();
		bebidas = Alimento.comboBebidas();
		agregados = new HashMap<>();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(10, 74, 600, 596);

		panelCombo = new JPanel();
		panelCombo.setBackground(Color.DARK_GRAY);
		panelCombo.setBorder(null);
		panelCombo.setLayout(new GridLayout(0, 3, 5, 5));

		panelSnacks = new JPanel();
		panelSnacks.setBackground(Color.DARK_GRAY);
		panelSnacks.setLayout(new GridLayout(0, 3, 5, 5));

		panelBebidas = new JPanel();
		panelBebidas.setBackground(Color.DARK_GRAY);
		panelBebidas.setLayout(new GridLayout(0, 3, 5, 5));

		lblAlimentos = new JLabel("  ALIMENTOS");
		lblAlimentos.setOpaque(true);
		lblAlimentos.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblAlimentos.setBackground(new Color(255, 128, 64));
		lblAlimentos.setBounds(0, 0, 784, 63);
		contentPane.add(lblAlimentos);

		cargarCombos();
		cargarSnacks();
		cargarBebidas();

		panelCombo.setPreferredSize(new Dimension(585, 720));
		panelCombo.revalidate();
		panelCombo.repaint();

		panelSnacks.setPreferredSize(new Dimension(585, 720));
		panelSnacks.revalidate();
		panelSnacks.repaint();

		panelBebidas.setPreferredSize(new Dimension(585, 720));
		panelBebidas.revalidate();
		panelBebidas.repaint();

		JScrollPane scrollPane = new JScrollPane(panelCombo);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane scrollSnacks = new JScrollPane(panelSnacks);
		scrollSnacks.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollSnacks.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JScrollPane scrollBebidas = new JScrollPane(panelBebidas);
		scrollBebidas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBebidas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		tabbedPane.addTab("Combos", null, scrollPane, null);
		tabbedPane.addTab("Snacks", null, scrollSnacks, null);
		tabbedPane.addTab("Bebidas", null, scrollBebidas, null);
		contentPane.add(tabbedPane);

		btnComprar = new JButton("COMPRAR");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnComprar.setFocusPainted(false);
		btnComprar.setBorder(null);
		btnComprar.setBackground(Color.ORANGE);
		btnComprar.setBounds(651, 647, 123, 23);
		contentPane.add(btnComprar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(620, 164, 154, 459);
		contentPane.add(scrollPane_1);

		panelAgregado = new JPanel();
		panelAgregado.setBackground(new Color(51, 51, 51));
		scrollPane_1.setViewportView(panelAgregado);
		panelAgregado.setLayout(new BoxLayout(panelAgregado, BoxLayout.Y_AXIS));

		lblNewLabel = new JLabel("AGREGADOS :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(620, 112, 107, 41);
		contentPane.add(lblNewLabel);

		lblContadorAgregado = new JLabel("0  ");
		lblContadorAgregado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContadorAgregado.setForeground(Color.WHITE);
		lblContadorAgregado.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblContadorAgregado.setBounds(725, 112, 49, 41);
		contentPane.add(lblContadorAgregado);

		disposeAlimentos();

	}

	private void disposeAlimentos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				resetAlimentos();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				resetAlimentos();
			}
		});
	}

	public void cargarCombos() {
		for (var combo : combos) {
			panelCombo.add(cardAlimento(combo));
		}
	}

	public void cargarSnacks() {
		for (var snack : snacks) {
			panelSnacks.add(cardAlimento(snack));
		}
	}

	public void cargarBebidas() {
		for (var bebida : bebidas) {
			panelBebidas.add(cardAlimento(bebida));
		}
	}

	public JPanel cardAgregado(Alimento alimento) {
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setPreferredSize(new Dimension(100, 180));
		card.setBackground(new Color(40, 40, 40));
		card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Imagen de la cartelera
		ImageIcon original = new ImageIcon(alimento.ruta);
		Image scale = original.getImage().getScaledInstance(90, 130, Image.SCALE_SMOOTH);
		JLabel img = new JLabel(new ImageIcon(scale));
		img.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton agregar = new JButton(" - Quitar ");
		agregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		agregar.setPreferredSize(new Dimension(123, 23));
		agregar.setFocusPainted(false);
		agregar.setBorder(null);
		agregar.setBackground(Color.ORANGE);
		agregar.setAlignmentX(Component.CENTER_ALIGNMENT);
		agregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		agregar.addActionListener(e -> {
			removerAlimento(alimento, card);
		});

		card.add(Box.createVerticalGlue());
		card.add(img);
		card.add(Box.createVerticalStrut(5));
		card.add(agregar);
		card.add(Box.createVerticalGlue());

		return card;
	}

	public JPanel cardAlimento(Alimento alimento) {
		JPanel card = new JPanel();
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setPreferredSize(new Dimension(220, 380));
		card.setBackground(new Color(40, 40, 40));
		card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Imagen de la cartelera
		ImageIcon original = new ImageIcon(alimento.ruta);
		Image scale = original.getImage().getScaledInstance(160, 200, Image.SCALE_SMOOTH);
		JLabel img = new JLabel(new ImageIcon(scale));
		img.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Nombre
		JLabel titulo = new JLabel(alimento.nombre);
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titulo.setPreferredSize(new Dimension(220, 55));
		titulo.setMinimumSize(new Dimension(200, 55));
		titulo.setMaximumSize(new Dimension(200, 55));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Descripción
		JLabel duracion = new JLabel(alimento.descripcion);
		duracion.setForeground(Color.LIGHT_GRAY);
		duracion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		duracion.setPreferredSize(new Dimension(220, 55));
		duracion.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Agregar
		JButton agregar = new JButton(" + AGREGAR ");
		agregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		agregar.setPreferredSize(new Dimension(123, 23));
		agregar.setFocusPainted(false);
		agregar.setBorder(null);
		agregar.setBackground(Color.ORANGE);
		agregar.setAlignmentX(Component.CENTER_ALIGNMENT);
		agregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		agregar.addActionListener(e -> {
			agregarAlimento(alimento);
		});

		card.add(Box.createVerticalGlue());
		card.add(img);
		card.add(Box.createVerticalStrut(5));
		card.add(titulo);
		card.add(Box.createVerticalStrut(5));
		card.add(duracion);
		card.add(Box.createVerticalStrut(5));
		card.add(agregar);
		card.add(Box.createVerticalGlue());

		return card;
	}

	public void agregarAlimento(Alimento alimento) {
		JPanel card = cardAgregado(alimento);
		agregados.put(alimento, card);

		panelAgregado.add(card);
		updateAgregados();

	}

	public void removerAlimento(Alimento alimento, JPanel agregado) {
		agregados.remove(alimento);
		panelAgregado.remove(agregado);

		updateAgregados();
	}

	public void updateAgregados() {
		Integer contador = agregados.size();
		lblContadorAgregado.setText(contador.toString()+ "  ");
		panelAgregado.revalidate();
		panelAgregado.repaint();
	}

	private void resetAlimentos() {
		agregados.clear();
	}
}
