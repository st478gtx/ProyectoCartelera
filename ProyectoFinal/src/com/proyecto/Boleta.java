package com.proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Boleta extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JLabel tituloLbl;
    private JLabel proyeccionLbl;
    private JLabel horaLbl;
    private JLabel numSalaLbl;
    private JLabel asientosLbl;
    private JLabel entradasLbl;
    private JLabel snacksLbl;
    private JLabel lblItem1;
    private JLabel lblSubtotal;
    private JLabel lblDescuento;
    private JLabel lblTotal;
    private JLabel peliculaLbl;
    private JLabel horarioLbl;
    private JLabel salaLbl;
    private JLabel tituloAsientosLbl;
    private JLabel tituloEntradasLbl;
    private JLabel lblPrecioItem1;
    
    private JSeparator sep1;
    private JSeparator sep2;
    private JSeparator sep3;
    private JSeparator sep4;
    private JButton btnAtras;
    private JButton btnConfirmar;
    private JLabel lblItem2;
    private JLabel lblPrecioItem2;
    private JLabel lblValorSubtotal;
    private JLabel lblValorDescuento;
    private JSeparator sep5;
    private JLabel lblValorTotal;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Boleta frame = new Boleta();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Boleta() {
        setTitle("Boleta de compra");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(479, 611);
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        // Titulo
        tituloLbl = new JLabel("BOLETA DE COMPRA");
        tituloLbl.setFont(new Font("Tahoma", Font.BOLD, 24));
        tituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLbl.setForeground(new Color(255, 128, 0));
        tituloLbl.setBounds(0, 20, 468, 35);
        contentPane.add(tituloLbl);

        sep1 = new JSeparator();
        sep1.setForeground(new Color(0, 0, 0));
        sep1.setBounds(40, 66, 382, 1);
        contentPane.add(sep1);

        // Peli
        peliculaLbl = new JLabel("Película:");
        peliculaLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        peliculaLbl.setBounds(40, 80, 100, 20);
        contentPane.add(peliculaLbl);

        proyeccionLbl = new JLabel("Proyecto Fin del Mundo");
        proyeccionLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
        proyeccionLbl.setBounds(160, 80, 262, 20);
        contentPane.add(proyeccionLbl);

        horarioLbl = new JLabel("Horario:");
        horarioLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        horarioLbl.setBounds(40, 110, 100, 20);
        contentPane.add(horarioLbl);

        horaLbl = new JLabel("18:00 hrs");
        horaLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
        horaLbl.setBounds(160, 110, 200, 20);
        contentPane.add(horaLbl);

        salaLbl = new JLabel("Sala:");
        salaLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        salaLbl.setBounds(40, 135, 100, 20);
        contentPane.add(salaLbl);

        numSalaLbl = new JLabel("1");
        numSalaLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
        numSalaLbl.setBounds(160, 135, 200, 20);
        contentPane.add(numSalaLbl);

        sep2 = new JSeparator();
        sep2.setForeground(new Color(0, 0, 0));
        sep2.setBounds(40, 168, 382, 2);
        contentPane.add(sep2);

        // Asientos
        tituloAsientosLbl = new JLabel("Asientos:");
        tituloAsientosLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        tituloAsientosLbl.setBounds(40, 180, 100, 20);
        contentPane.add(tituloAsientosLbl);

        asientosLbl = new JLabel("B4, C4, D4");
        asientosLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
        asientosLbl.setBounds(160, 180, 150, 20);
        contentPane.add(asientosLbl);

        tituloEntradasLbl = new JLabel("Entradas:");
        tituloEntradasLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        tituloEntradasLbl.setBounds(40, 205, 100, 20);
        contentPane.add(tituloEntradasLbl);

        entradasLbl = new JLabel("3  x  S/ 30.00  =  S/ 90.00");
        entradasLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
        entradasLbl.setBounds(160, 205, 180, 20);
        contentPane.add(entradasLbl);

        sep3 = new JSeparator();
        sep3.setForeground(new Color(0, 0, 0));
        sep3.setBounds(40, 239, 382, 1);
        contentPane.add(sep3);

        // Snacks
        snacksLbl = new JLabel("Snacks y Combos:");
        snacksLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        snacksLbl.setBounds(40, 250, 200, 20);
        contentPane.add(snacksLbl);

        lblItem1 = new JLabel("1  x  Combo Duo");
        lblItem1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblItem1.setBounds(60, 275, 180, 20);
        contentPane.add(lblItem1);

        lblPrecioItem1 = new JLabel("S/ 74.40");
        lblPrecioItem1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPrecioItem1.setBounds(276, 275, 100, 20);
        contentPane.add(lblPrecioItem1);

        lblItem2 = new JLabel("2  x  Popcorn Mediano");
        lblItem2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblItem2.setBounds(60, 300, 180, 20);
        contentPane.add(lblItem2);

        lblPrecioItem2 = new JLabel("S/ 45.80");
        lblPrecioItem2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPrecioItem2.setBounds(276, 300, 100, 20);
        contentPane.add(lblPrecioItem2);

        sep4 = new JSeparator();
        sep4.setForeground(new Color(0, 0, 0));
        sep4.setBounds(40, 341, 382, 1);
        contentPane.add(sep4);

        // Totales
        lblSubtotal = new JLabel("Subtotal:");
        lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSubtotal.setBounds(40, 353, 200, 20);
        contentPane.add(lblSubtotal);

        lblValorSubtotal = new JLabel("S/ 210.20");
        lblValorSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblValorSubtotal.setBounds(276, 353, 100, 20);
        contentPane.add(lblValorSubtotal);

        lblDescuento = new JLabel("Descuento (7.5%):");
        lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDescuento.setBounds(40, 384, 200, 20);
        contentPane.add(lblDescuento);

        lblValorDescuento = new JLabel("- S/ 15.76");
        lblValorDescuento.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblValorDescuento.setForeground(Color.RED);
        lblValorDescuento.setBounds(276, 384, 100, 20);
        contentPane.add(lblValorDescuento);

        sep5 = new JSeparator();
        sep5.setForeground(new Color(0, 0, 0));
        sep5.setBounds(40, 426, 382, 1);
        contentPane.add(sep5);

        lblTotal = new JLabel("TOTAL A PAGAR:");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotal.setBounds(40, 438, 250, 25);
        contentPane.add(lblTotal);

        lblValorTotal = new JLabel("S/ 194.44");
        lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblValorTotal.setForeground(new Color(255, 128, 0));
        lblValorTotal.setBounds(276, 438, 146, 25);
        contentPane.add(lblValorTotal);

        // Botones
        btnAtras = new JButton("Atrás");
        btnAtras.setBounds(40, 495, 89, 23);
        contentPane.add(btnAtras);

        btnConfirmar = new JButton("Confirmar compra");
        btnConfirmar.setForeground(new Color(0, 0, 0));
        btnConfirmar.setBounds(276, 493, 141, 27);
        contentPane.add(btnConfirmar);
    }
}