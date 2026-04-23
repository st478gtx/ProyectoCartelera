package com.proyecto;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Cursor;

public class Secundario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextArea txtrComboFrankfurter;
	private JTextArea txtrComboFrankfurter_1;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextArea txtrComboFrankfurter_2;
	private JPanel panel_3;
	private JTextArea txtrComboFrankfurter_3;
	private JPanel panel_4;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secundario frame = new Secundario();
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
	public Secundario() {
		setTitle("Alimentos y bebidas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(42, 28, 554, 502);
		contentPane.add(tabbedPane);
		
		//TODO: AGREGAR PARA PANEL DINAMICO
		//CREAR CARD DE COMBOS
		//JPanel panel = new JPanel(new GridLayout(0, 3, 20, 20));

		panel = new JPanel();
		tabbedPane.addTab("Combos", null, panel, null);
		panel.setLayout(null);

		ArrayList<ImageIcon> imageScales = new ArrayList<>();
		imageScales.add(imagenProcesada("resources/14588-1752610832530.png"));
		imageScales.add(imagenProcesada("resources/15453-1765903024362.png"));
		imageScales.add(imagenProcesada("resources/528-1755100170631.png"));			

		lblNewLabel = new JLabel(imageScales.get(0));
		lblNewLabel.setBounds(10, 11, 160, 200);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.RED)); // temporal
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(imageScales.get(1));
		lblNewLabel_1.setBounds(187, 11, 160, 200);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(imageScales.get(2));
		lblNewLabel_2.setBounds(357, 11, 160, 200);
		panel.add(lblNewLabel_2);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 209, 160, 114);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtrComboFrankfurter_1 = new JTextArea();
		txtrComboFrankfurter_1.setBounds(10, 44, 140, 35);
		panel_1.add(txtrComboFrankfurter_1);
		txtrComboFrankfurter_1.setForeground(Color.DARK_GRAY);
		txtrComboFrankfurter_1.setWrapStyleWord(true);
		txtrComboFrankfurter_1.setText("S/ 74.40 * COMBO\r\nDUO");
		txtrComboFrankfurter_1.setOpaque(false);
		txtrComboFrankfurter_1.setLineWrap(true);
		txtrComboFrankfurter_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrComboFrankfurter_1.setEditable(false);
		
		btnNewButton = new JButton("", iconoProcesada("resources/add_24dp_000000_FILL1_wght400_GRAD0_opsz24.png"));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(118, 69, 32, 32);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		lblNewLabel_3 = new JLabel("COMBO DUO");
		lblNewLabel_3.setBounds(0, 11, 160, 22);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(187, 209, 160, 114);
		panel.add(panel_2);
		
		txtrComboFrankfurter_2 = new JTextArea();
		txtrComboFrankfurter_2.setWrapStyleWord(true);
		txtrComboFrankfurter_2.setText("S/ 74.40 * COMBO\r\nDUO");
		txtrComboFrankfurter_2.setOpaque(false);
		txtrComboFrankfurter_2.setLineWrap(true);
		txtrComboFrankfurter_2.setForeground(Color.DARK_GRAY);
		txtrComboFrankfurter_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrComboFrankfurter_2.setEditable(false);
		txtrComboFrankfurter_2.setBounds(10, 44, 140, 35);
		panel_2.add(txtrComboFrankfurter_2);
		
		lblNewLabel_4 = new JLabel("COMBO TRIO");
		lblNewLabel_4.setBounds(10, 11, 150, 22);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		btnNewButton_1 = new JButton("", iconoProcesada("resources/add_24dp_000000_FILL1_wght400_GRAD0_opsz24.png"));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(118, 71, 32, 32);
		panel_2.add(btnNewButton_1);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(357, 209, 160, 114);
		panel.add(panel_3);
		
		txtrComboFrankfurter_3 = new JTextArea();
		txtrComboFrankfurter_3.setWrapStyleWord(true);
		txtrComboFrankfurter_3.setText("S/ 31.80 * FRANKFURTER\r\nGASEOSA MEDIANA(P)\r\n");
		txtrComboFrankfurter_3.setOpaque(false);
		txtrComboFrankfurter_3.setLineWrap(true);
		txtrComboFrankfurter_3.setForeground(Color.DARK_GRAY);
		txtrComboFrankfurter_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrComboFrankfurter_3.setEditable(false);
		txtrComboFrankfurter_3.setBounds(10, 31, 105, 83);
		panel_3.add(txtrComboFrankfurter_3);
		
		txtrComboFrankfurter = new JTextArea();
		txtrComboFrankfurter.setBounds(10, 11, 150, 32);
		panel_3.add(txtrComboFrankfurter);
		txtrComboFrankfurter.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtrComboFrankfurter.setText("COMBO FRANKFURTER");
		txtrComboFrankfurter.setLineWrap(true);
		txtrComboFrankfurter.setWrapStyleWord(true);
		txtrComboFrankfurter.setEditable(false);
		txtrComboFrankfurter.setOpaque(false);
		
		btnNewButton_2 = new JButton("", iconoProcesada("resources/add_24dp_000000_FILL1_wght400_GRAD0_opsz24.png"));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(118, 71, 32, 32);
		panel_3.add(btnNewButton_2);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("Snacks", null, panel_4, null);

	}

	private ImageIcon imagenProcesada(String ruta) {
		ImageIcon original = new ImageIcon(ruta);
		Image scale = original.getImage().getScaledInstance(160, 200, Image.SCALE_SMOOTH);
		ImageIcon imageScale = new ImageIcon(scale);
		return imageScale;
	}
	
	private ImageIcon iconoProcesada(String ruta) {
		ImageIcon original = new ImageIcon(ruta);
		Image scale = original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon imageScale = new ImageIcon(scale);
		return imageScale;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
