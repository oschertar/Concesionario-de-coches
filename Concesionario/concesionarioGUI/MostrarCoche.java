package concesionarioGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;


import concesionarioCoches.Coche;
import concesionarioCoches.CocheNoExistenteException;
import concesionarioCoches.Marca;
import concesionarioCoches.MatriculaNoValidaException;
import concesionarioCoches.Modelo;
import javax.swing.SwingConstants;

public class MostrarCoche extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMatricula;
	private JComboBox cbMarcas;
	private JComboBox cbModelos;
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnAzul;
	private JRadioButton rdbtnPlata;
	private JButton okButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarCoche dialog = new MostrarCoche();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarCoche() {
		setTitle("Buscar Coche por Matr\u00EDcula");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMatricula = new JLabel("Matricula");
			lblMatricula.setBounds(48, 16, 62, 14);
			contentPanel.add(lblMatricula);
		}
		{
			txtMatricula = new JTextField();
			txtMatricula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

				}
			});
			txtMatricula
					.setToolTipText("Formato: 1234-BBB (no se admite A, E, I, O, U o \u00D1)");
			txtMatricula.setBounds(115, 13, 86, 20);
			contentPanel.add(txtMatricula);
			txtMatricula.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "Colores",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			panel.setBounds(42, 72, 121, 98);
			contentPanel.add(panel);
			panel.setLayout(null);

			rdbtnRojo = new JRadioButton("Rojo");
			rdbtnRojo.setEnabled(false);
			rdbtnRojo.setBounds(6, 16, 109, 23);
			panel.add(rdbtnRojo);
			rdbtnRojo.setForeground(new Color(255, 0, 51));

			rdbtnPlata = new JRadioButton("Plata");
			rdbtnPlata.setEnabled(false);
			rdbtnPlata.setBounds(6, 42, 109, 23);
			panel.add(rdbtnPlata);
			rdbtnPlata.setForeground(Color.LIGHT_GRAY);

			rdbtnAzul = new JRadioButton("Azul");
			rdbtnAzul.setEnabled(false);
			rdbtnAzul.setBounds(6, 68, 109, 23);
			panel.add(rdbtnAzul);
			rdbtnAzul.setForeground(Color.BLUE);
		}

		JLabel lblMarcas = new JLabel("Marcas");
		lblMarcas.setBounds(229, 46, 46, 14);
		contentPanel.add(lblMarcas);

		cbMarcas = new JComboBox();
		cbMarcas.setBackground(Color.BLUE);
		cbMarcas.setEnabled(false);
		cbMarcas.setToolTipText("Elige una marca entre las disponibles");
		cbMarcas.setModel(new DefaultComboBoxModel(Marca.values()));
		cbMarcas.setBounds(229, 80, 132, 32);
		contentPanel.add(cbMarcas);

		JLabel lblModelos = new JLabel("Modelos");
		lblModelos.setBounds(229, 137, 46, 14);
		contentPanel.add(lblModelos);

		cbModelos = new JComboBox();
		cbModelos.setBackground(Color.BLUE);
		cbModelos.setEnabled(false);
		cbModelos.setModel(new DefaultComboBoxModel(getModelo(cbMarcas)));
		cbModelos.setToolTipText("Elige un modelo entre los disponibles");
		cbModelos.setBounds(229, 162, 132, 32);
		contentPanel.add(cbModelos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Mostrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						mostrar();
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		}
	}
	protected void mostrar() {
		try {
			Coche coche = General.concesionario.get(txtMatricula.getText());
			if(coche.getColor().toString().equals("ROJO")){
				rdbtnRojo.setSelected(true);
				rdbtnAzul.setSelected(false);
				rdbtnPlata.setSelected(false);
				
			}else if(coche.getColor().toString().equals("AZUL")){
				rdbtnAzul.setSelected(true);
				rdbtnRojo.setSelected(false);
				rdbtnPlata.setSelected(false);
			}else if(coche.getColor().toString().equals("PLATA")){
				rdbtnPlata.setSelected(true);
				rdbtnRojo.setSelected(false);
				rdbtnAzul.setSelected(false);
			}
			
			cbMarcas.addItem(coche.getModelo().getMarca());
			cbMarcas.setSelectedItem(coche.getModelo().getMarca());
			cbModelos.addItem(coche.getModelo());
			cbModelos.setSelectedItem(coche.getModelo());
			
			
		} catch (MatriculaNoValidaException | CocheNoExistenteException e) {
			JOptionPane.showMessageDialog(contentPanel,
					"El coche no existe.", "Error",
					JOptionPane.ERROR_MESSAGE);
		
		}
	}

	private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}
		

	}
		
	


