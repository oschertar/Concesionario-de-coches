package concesionarioGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Button;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import concesionarioCoches.Coche;
import concesionarioCoches.Marca;
import concesionarioCoches.Modelo;

import javax.swing.ImageIcon;

public class MostrarConcesionario extends JDialog {
	private final JPanel contentPanel = new JPanel();
    private JTextField txtMatricula;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rdbtnRojo;
    private JRadioButton rdbtnAzul;
    private JRadioButton rdbtnPlata;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxModelo;
    private int indice = 0;
    private JButton botonAnterior;
    private JButton botonSiguiente;
    private JButton btnMostrar;
	private JLabel capaPlata;
	private JLabel capaAzul;
	private JLabel capaRojo;
	private JLabel capaBmw;
	private JLabel capaSeat;

    /**
     * Create the dialog.
     */
    public MostrarConcesionario() {
            setTitle("Mostrar concesionario");
            setBounds(100, 100, 528, 356);
            getContentPane().setLayout(new BorderLayout());
            contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
            getContentPane().add(contentPanel, BorderLayout.CENTER);
            contentPanel.setLayout(null);
            {
                    JLabel lblMatricula = new JLabel("Matricula");
                    lblMatricula.setBounds(23, 36, 75, 14);
                    contentPanel.add(lblMatricula);
            }

            txtMatricula = new JTextField();
            txtMatricula.setBackground(new Color(0, 0, 153));
            txtMatricula.setEnabled(false);
            txtMatricula.setEditable(false);
            txtMatricula.setBounds(100, 33, 86, 20);
            contentPanel.add(txtMatricula);
            txtMatricula.setColumns(10);

            JPanel Colores = new JPanel();
            Colores.setToolTipText("");
            Colores.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Colores",
                            TitledBorder.LEADING, TitledBorder.TOP, null,
                            null));
            Colores.setBounds(39, 88, 121, 97);
            contentPanel.add(Colores);
            Colores.setLayout(null);

            rdbtnRojo = new JRadioButton("Rojo");
            rdbtnRojo.setEnabled(false);
            rdbtnRojo.setBounds(6, 16, 109, 23);
            Colores.add(rdbtnRojo);
            buttonGroup.add(rdbtnRojo);

            rdbtnAzul = new JRadioButton("Azul");
            rdbtnAzul.setEnabled(false);
            rdbtnAzul.setBounds(6, 42, 109, 23);
            Colores.add(rdbtnAzul);
            buttonGroup.add(rdbtnAzul);

            rdbtnPlata = new JRadioButton("Plata");
            rdbtnPlata.setEnabled(false);
            rdbtnPlata.setBounds(6, 68, 109, 23);
            Colores.add(rdbtnPlata);
            buttonGroup.add(rdbtnPlata);

            JList list = new JList();
            list.setBounds(90, 155, -57, -63);
            contentPanel.add(list);

            comboBoxMarca = new JComboBox();
            comboBoxMarca.setBackground(Color.WHITE);
            comboBoxMarca.setBounds(294, 84, 105, 22);
            contentPanel.add(comboBoxMarca);

            comboBoxModelo = new JComboBox();
            comboBoxModelo.setBackground(Color.WHITE);
            comboBoxModelo.setBounds(294, 132, 105, 22);
            contentPanel.add(comboBoxModelo);

            JLabel lblMarca = new JLabel("Marca");
            lblMarca.setBounds(238, 88, 46, 14);
            contentPanel.add(lblMarca);

            JLabel lblModelo = new JLabel("Modelo");
            lblModelo.setBounds(238, 136, 46, 14);
            contentPanel.add(lblModelo);
            
            
            
            capaPlata = new JLabel("");
            Image plata= new ImageIcon(this.getClass().getResource("/img/plata.png")).getImage();
            capaPlata.setVisible(false);
    		capaPlata.setIcon(new ImageIcon(plata));
            capaPlata.setBounds(49, 196, 121, 62);
            contentPanel.add(capaPlata);
            
            capaAzul = new JLabel("");
            Image azul= new ImageIcon(this.getClass().getResource("/img/azul.png")).getImage();
            capaAzul.setVisible(false);
    		capaAzul.setIcon(new ImageIcon(azul));
            capaAzul.setBounds(49, 196, 121, 62);
            contentPanel.add(capaAzul);
            
            capaRojo = new JLabel("");
            Image rojo= new ImageIcon(this.getClass().getResource("/img/rojo.png")).getImage();
            capaRojo.setVisible(false);
            capaRojo.setIcon(new ImageIcon(rojo));
            capaRojo.setBounds(49, 196, 121, 62);
            contentPanel.add(capaRojo);
            
            capaBmw = new JLabel("");
            Image bmw= new ImageIcon(this.getClass().getResource("/img/bmw.png")).getImage();
            capaBmw.setVisible(false);
            capaBmw.setIcon(new ImageIcon(bmw));
            capaBmw.setBounds(409, 67, 63, 62);
            contentPanel.add(capaBmw);
            
            capaSeat = new JLabel("");
            Image seat= new ImageIcon(this.getClass().getResource("/img/seat.png")).getImage();
            capaSeat.setVisible(false);
            capaSeat.setIcon(new ImageIcon(seat));
            capaSeat.setBounds(409, 67, 63, 62);
            contentPanel.add(capaSeat);
            
        
            
            

            {
                    JPanel buttonPane = new JPanel();
                    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    getContentPane().add(buttonPane, BorderLayout.SOUTH);

                    botonAnterior = new JButton("");
                    botonAnterior.setIcon(new ImageIcon("C:\\Users\\Oscar\\Desktop\\pgTercerTrimestre\\InterfazGr\u00E1fica\\src\\img\\flecha_izquierda.gif"));
                    botonAnterior.setVisible(false);
                    botonAnterior.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                    mostrarAnterior();
                            }

                    });
                    buttonPane.add(botonAnterior);

                    botonSiguiente = new JButton("");
                    botonSiguiente.setIcon(new ImageIcon("C:\\Users\\Oscar\\Desktop\\pgTercerTrimestre\\InterfazGr\u00E1fica\\src\\img\\flecha_derecha.gif"));
                    botonSiguiente.setVisible(false);
                    botonSiguiente.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                    mostrarSiguiente();
                            }
                    });
                    buttonPane.add(botonSiguiente);

                    {
                            JButton cancelButton = new JButton("Salir");
                            cancelButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                            setVisible(false);
                                            dispose();
                                    }
                            });

                            btnMostrar = new JButton("Mostrar");
                            btnMostrar.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent arg0) {
                                            if (General.concesionario.size() == 0)
                                                    JOptionPane.showMessageDialog(contentPanel,
                                                                    "El concesionario esta vacio", "Error",
                                                                    JOptionPane.ERROR_MESSAGE);
                                            if (General.concesionario.get(0) != null) {
                                                    mostrarCoche(General.concesionario.get(indice));
                                                    comprobarTamaño();
                                                    botonSiguiente.setVisible(true);
                                                    botonAnterior.setVisible(true);
                                                    btnMostrar.setVisible(false);
                                            }
                                    }
                            });
                            buttonPane.add(btnMostrar);
                            buttonPane.add(cancelButton);
                    }
            }

    }

    private void mostrarSiguiente() {
            mostrarCoche(General.concesionario.get(++indice));
            comprobarTamaño();
    }

    private void mostrarAnterior() {
            mostrarCoche(General.concesionario.get(--indice));
            comprobarTamaño();
    }

    private void mostrarCoche(Coche coche) {
            txtMatricula.setText(coche.getMatricula());
            if (coche.getColor().toString().equals("ROJO")){
                    rdbtnRojo.setSelected(true);
            		rdbtnRojo.setBackground(Color.RED);
            		rdbtnAzul.setBackground(new Color(240,240,240,240));
            		rdbtnPlata.setBackground(new Color(240,240,240,240));
            		capaRojo.setVisible(true);
            		capaAzul.setVisible(false);
            		capaPlata.setVisible(false);
            		}
            else if (coche.getColor().toString().equals("PLATA")){
            	 rdbtnPlata.setSelected(true);
            	 rdbtnPlata.setBackground(Color.GRAY);
            	 rdbtnRojo.setBackground(new Color(240,240,240,240));
            	 rdbtnAzul.setBackground(new Color(240,240,240,240));
            	 capaPlata.setVisible(true);
            	 capaRojo.setVisible(false);
            	 capaAzul.setVisible(false);
            }
                   
            else{
                    rdbtnAzul.setSelected(true);
            		rdbtnAzul.setBackground(Color.BLUE);
            		rdbtnPlata.setBackground(new Color(240,240,240,240));
            		rdbtnRojo.setBackground(new Color(240,240,240,240));
            		capaAzul.setVisible(true);
            		capaPlata.setVisible(false);
            		capaRojo.setVisible(false);
            }
            comboBoxMarca.addItem(coche.getModelo().getMarca());
            comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
            comboBoxModelo.addItem(coche.getModelo());
            comboBoxModelo.setSelectedItem(coche.getModelo());
            if(comboBoxMarca.getSelectedItem()==Marca.BMW){
            	capaBmw.setVisible(true);
            	capaSeat.setVisible(false);
            	
            }else if (comboBoxMarca.getSelectedItem()==Marca.SEAT){
            	capaSeat.setVisible(true);
            	capaBmw.setVisible(false);
            }

    }

    private void comprobarTamaño() {
            if (General.concesionario.get(indice + 1) == null)
                    botonSiguiente.setEnabled(false);
            else
                    botonSiguiente.setEnabled(true);

            if (General.concesionario.get(indice - 1) == null)
                    botonAnterior.setEnabled(false);
            else
                    botonAnterior.setEnabled(true);
    }
}