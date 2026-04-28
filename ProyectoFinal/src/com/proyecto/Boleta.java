package com.proyecto;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.proyecto.modelo.Alimento;
import com.proyecto.modelo.BoletaCompra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boleta extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JPanel panelContenido;
    private JFrame ventanaAnterior;
    private JLabel proyeccionLbl;
    private JLabel horaLbl;
    private JLabel numSalaLbl;
    private JLabel asientosLbl;
    private JLabel entradasLbl;
    private JLabel lblValorSubtotal;
    private JLabel lblDescuento;
    private JLabel lblValorDescuento;
    private JLabel lblValorTotal;
    private JButton btnAtras;
    private JButton btnConfirmar;
    
    

    // Colores
    private static final Color FONDO = new Color(30, 30, 30);
    private static final Color PANEL = new Color(45, 45, 45);
    private static final Color NARANJA = new Color(255, 128, 0);
    private static final Color TEXTO = new Color(220, 220, 220);
    private static final Color TEXTO_GRIS = new Color(150, 150, 150);

    public Boleta(BoletaCompra boleta, JFrame anterior) {
    	// Guarda la ventana anterior para poder volver a ella
        this.ventanaAnterior = anterior;
        anterior.setVisible(false);
        
        //Configuracion de la ventana
        setTitle("Boleta de compra");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(489, 624);
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(FONDO);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Cabecera naranja
        JPanel cabecera = new JPanel();
        cabecera.setBackground(NARANJA);
        cabecera.setLayout(null);
        cabecera.setBounds(0, 0, 480, 55);
        contentPane.add(cabecera);

        JLabel tituloLbl = new JLabel("BOLETA DE COMPRA");
        tituloLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        tituloLbl.setForeground(Color.WHITE);
        tituloLbl.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLbl.setBounds(0, 0, 480, 55);
        cabecera.add(tituloLbl);

        // Panel con scroll para el contenido
        panelContenido = new JPanel();
        panelContenido.setBackground(PANEL);
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setBorder(new EmptyBorder(15, 20, 15, 20));

        JScrollPane scroll = new JScrollPane(panelContenido);
        scroll.setBounds(20, 65, 435, 470);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60)));
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        contentPane.add(scroll);

        // Botones
        btnAtras = new JButton("← Atrás");
        btnAtras.setBounds(20, 545, 100, 28);
        btnAtras.setBackground(new Color(70, 70, 70));
        btnAtras.setForeground(TEXTO);
        btnAtras.setFocusPainted(false);
        btnAtras.setBorder(null);
        btnAtras.addActionListener(this);
        contentPane.add(btnAtras);

        btnConfirmar = new JButton("Confirmar compra ✓");
        btnConfirmar.setBounds(290, 543, 165, 30);
        btnConfirmar.setBackground(NARANJA);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBorder(null);
        contentPane.add(btnConfirmar);

        cargarDatos(boleta);
    }

    private void cargarDatos(BoletaCompra boleta) {
    	// Limpia el panel antes de cargar los datos
        panelContenido.removeAll();

        //Seccion pelicul
        agregarTituloSeccion("PELÍCULA");
        agregarFila("Película:", boleta.pelicula.tituloNormal);
        agregarFila("Horario:", boleta.funcion.hora + " hrs");
        agregarFila("Sala:", boleta.funcion.sala.nombre);
        agregarSeparador();

        // Seccion asientos
        agregarTituloSeccion("ASIENTOS");
        // Muestra todos los asientos en una línea, si son muchos se wrappea
        JLabel lblAsientos = new JLabel(String.join(", ", boleta.boletos));
        lblAsientos.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblAsientos.setForeground(TEXTO);
        lblAsientos.setBorder(new EmptyBorder(2, 10, 2, 0));
        panelContenido.add(lblAsientos);

        agregarFila("Entradas:", boleta.boletos.size() + "  x  S/ 30.00  =  S/ " +
            String.format("%.2f", boleta.boletos.size() * 30.00));
        agregarSeparador();

        //snacks
        agregarTituloSeccion("SNACKS Y COMBOS");

        double totalSnacks = 0;
        for (Map.Entry<Alimento, Integer> entry : boleta.carrito.entrySet()) {
            Alimento alimento = entry.getKey();
            int cantidad = entry.getValue();
            double precioItem = alimento.precio * cantidad;
            totalSnacks += precioItem;
            agregarFilaItem(cantidad + "  x  " + alimento.nombre,
                "S/ " + String.format("%.2f", precioItem));
        }
        //Si no agrego snacks muestra un mensaje
        if (boleta.carrito.isEmpty()) {
            JLabel sinSnacks = new JLabel("Sin snacks agregados");
            sinSnacks.setFont(new Font("Tahoma", Font.ITALIC, 12));
            sinSnacks.setForeground(TEXTO_GRIS);
            sinSnacks.setBorder(new EmptyBorder(2, 10, 2, 0));
            panelContenido.add(sinSnacks);
        }

        agregarSeparador();

        //Calcula los totales
        double subtotal = (boleta.boletos.size() * 30.00) + totalSnacks;
        double descuento = calcularDescuento(boleta.boletos.size(), subtotal);
        double total = subtotal - descuento;

        agregarFilaItem("Subtotal:", "S/ " + String.format("%.2f", subtotal));

        // Fila del descuento en rojo
        JPanel filaDesc = new JPanel(null);
        filaDesc.setBackground(PANEL);
        filaDesc.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 25));

        JLabel lblDesc = new JLabel("Descuento (" + calcularPorcentaje(boleta.boletos.size()) + "%):");
        lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDesc.setForeground(TEXTO_GRIS);
        lblDesc.setBounds(10, 3, 220, 20);
        filaDesc.add(lblDesc);

        JLabel lblValDesc = new JLabel("- S/ " + String.format("%.2f", descuento));
        lblValDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblValDesc.setForeground(new Color(220, 80, 80));
        lblValDesc.setHorizontalAlignment(SwingConstants.RIGHT);
        lblValDesc.setBounds(220, 3, 170, 20);
        filaDesc.add(lblValDesc);

        panelContenido.add(filaDesc);

        agregarSeparador();

        //Fila del total final en naranja
        JPanel filaTotal = new JPanel(null);
        filaTotal.setBackground(PANEL);
        filaTotal.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 30));

        JLabel lblTotalTxt = new JLabel("TOTAL A PAGAR:");
        lblTotalTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotalTxt.setForeground(TEXTO);
        lblTotalTxt.setBounds(10, 3, 200, 25);
        filaTotal.add(lblTotalTxt);

        JLabel lblTotalVal = new JLabel("S/ " + String.format("%.2f", total));
        lblTotalVal.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotalVal.setForeground(NARANJA);
        lblTotalVal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotalVal.setBounds(200, 3, 190, 25);
        filaTotal.add(lblTotalVal);

        panelContenido.add(filaTotal);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    // Agrega un título de sección naranja
    private void agregarTituloSeccion(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl.setForeground(NARANJA);
        lbl.setBorder(new EmptyBorder(8, 0, 4, 0));
        panelContenido.add(lbl);
    }

    // Agrega una fila clave-valor
    private void agregarFila(String clave, String valor) {
        JPanel fila = new JPanel(null);
        fila.setBackground(PANEL);
        fila.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 25));

        JLabel lblClave = new JLabel(clave);
        lblClave.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblClave.setForeground(TEXTO_GRIS);
        lblClave.setBounds(0, 3, 120, 20);
        fila.add(lblClave);

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblValor.setForeground(TEXTO);
        lblValor.setBounds(125, 3, 265, 20);
        fila.add(lblValor);

        panelContenido.add(fila);
    }

    // Agrega una fila de item con precio alineado a la derecha
    private void agregarFilaItem(String nombre, String precio) {
        JPanel fila = new JPanel(null);
        fila.setBackground(PANEL);
        fila.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 25));

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNombre.setForeground(TEXTO);
        lblNombre.setBounds(10, 3, 220, 20);
        fila.add(lblNombre);

        JLabel lblPrecio = new JLabel(precio);
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPrecio.setForeground(TEXTO);
        lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrecio.setBounds(220, 3, 170, 20);
        fila.add(lblPrecio);

        panelContenido.add(fila);
    }

    // Agrega un separador
    private void agregarSeparador() {
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(70, 70, 70));
        sep.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 10));
        panelContenido.add(sep);
    }

    private double calcularDescuento(int cantidad, double subtotal) {
        if (cantidad == 1)
        	return subtotal * 0.075;
        else if (cantidad <= 4)
        	return subtotal * 0.10;
        else if (cantidad <= 7)
        	return subtotal * 0.125;
        else
        	return subtotal * 0.15;
    }

    private double calcularPorcentaje(int cantidad) {
        if (cantidad == 1)
        	return 7.5;
        else if (cantidad <= 4)
        	return 10.0;
        else if (cantidad <= 7)
        	return 12.5;
        else
        	return 15.0;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAtras) {
            actionPerformedBtnAtras(e);
        }
    }
    
    protected void actionPerformedBtnAtras(ActionEvent e) {
        ventanaAnterior.setVisible(true);
        dispose();
    	}
	}
