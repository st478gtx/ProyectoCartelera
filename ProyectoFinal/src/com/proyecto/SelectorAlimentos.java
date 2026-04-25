package com.proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class SelectorAlimentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblAlimentos;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { SelectorAlimentos frame = new
	 * SelectorAlimentos(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public SelectorAlimentos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBounds(10, 81, 553, 539);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("New tab", null, panel, null);
		
		lblAlimentos = new JLabel("  ALIMENTOS");
		lblAlimentos.setOpaque(true);
		lblAlimentos.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblAlimentos.setBackground(new Color(255, 128, 64));
		lblAlimentos.setBounds(0, 0, 784, 63);
		contentPane.add(lblAlimentos);

	}
}
