package concesionarioGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



import concesionarioCoches.*;

import javax.swing.ButtonGroup;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AnnadirCoche extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMatricula;
	private JComboBox cbMarcas;
	private JComboBox cbModelos;
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnAzul;
	private JRadioButton rdbtnPlata;
	private JButton okButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel capaError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AnnadirCoche dialog = new AnnadirCoche();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AnnadirCoche() {
		setModal(true);
		setTitle("A\u00F1adir Coche");
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
			txtMatricula.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					txtMatricula.setForeground(Color.BLACK);
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(!concesionarioCoches.Coche.esValida(txtMatricula.getText())){
						txtMatricula.setForeground(Color.RED);
						capaError.setVisible(true);
						
					
						
						
				}else{
						txtMatricula.setForeground(Color.BLACK);
						capaError.setVisible(false);
						}
			}
				
			});
						
			
			
			txtMatricula
					.setToolTipText("Formato: 1234-BBB (no se admite A, E, I, O, U, Q o \u00D1)\r\n\r\n");
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
			rdbtnRojo.setToolTipText("Color del coche rojo");
			buttonGroup.add(rdbtnRojo);
			rdbtnRojo.setBounds(6, 16, 109, 23);
			panel.add(rdbtnRojo);
			rdbtnRojo.setForeground(new Color(255, 0, 51));

			rdbtnPlata = new JRadioButton("Plata");
			rdbtnPlata.setToolTipText("Color del coche plata");
			buttonGroup.add(rdbtnPlata);
			rdbtnPlata.setBounds(6, 42, 109, 23);
			panel.add(rdbtnPlata);
			rdbtnPlata.setForeground(Color.GRAY);

			rdbtnAzul = new JRadioButton("Azul");
			rdbtnAzul.setToolTipText("Color del coche azul");
			buttonGroup.add(rdbtnAzul);
			rdbtnAzul.setBounds(6, 68, 109, 23);
			panel.add(rdbtnAzul);
			rdbtnAzul.setForeground(Color.BLUE);
		}

		JLabel lblMarcas = new JLabel("Marcas");
		lblMarcas.setBounds(229, 46, 46, 14);
		contentPanel.add(lblMarcas);

		cbMarcas = new JComboBox();
		cbMarcas.setToolTipText("Elige una marca entre las disponibles");
		cbMarcas.setModel(new DefaultComboBoxModel(Marca.values()));
		cbMarcas.setBounds(229, 80, 132, 32);
		contentPanel.add(cbMarcas);

		JLabel lblModelos = new JLabel("Modelos");
		lblModelos.setBounds(229, 137, 46, 14);
		contentPanel.add(lblModelos);

		cbModelos = new JComboBox();
		cbModelos.setModel(new DefaultComboBoxModel(getModelo(cbMarcas)));
		cbModelos.setToolTipText("Elige un modelo entre los disponibles");
		cbModelos.setBounds(229, 162, 132, 32);
		contentPanel.add(cbModelos);
		
		capaError = new JLabel("Matricula Inv\u00E1lida");
		capaError.setForeground(Color.RED);
		Image error= new ImageIcon(this.getClass().getResource("/img/error.png")).getImage();
        capaError.setVisible(false);
		capaError.setIcon(new ImageIcon(error));
		capaError.setBounds(205, 13, 121, 19);
		contentPanel.add(capaError);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("A\u00F1adir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						alta();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				JButton btnLimpiar = new JButton("Limpiar");
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtMatricula.setText("");
						rdbtnAzul.setSelected(false);
						rdbtnRojo.setSelected(false);
						rdbtnPlata.setSelected(false);
						cbMarcas.setSelectedIndex(-1);
						cbModelos.setSelectedIndex(-1);
						
						
					}
				});
				buttonPane.add(btnLimpiar);
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

		cbMarcas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbModelos
						.setModel(new DefaultComboBoxModel(getModelo(cbMarcas)));
			}
		});

	}

	protected void alta() {
		try {
			if (General.concesionario.annadir(txtMatricula.getText(),
					getColorSeleccionado(),
					(Modelo) cbModelos.getSelectedItem())) {
				JOptionPane.showMessageDialog(okButton,
						"Coche añadido con éxito");
			}

		} catch (HeadlessException | MatriculaNoValidaException
				| ColorNoValidoException | ModeloNoValidoException
				| CocheYaExistenteException e) {

			JOptionPane.showMessageDialog(contentPanel,
					"El coche no se ha podido añadir.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private concesionarioCoches.Color getColorSeleccionado() {
		if (rdbtnAzul.isSelected())
			return concesionarioCoches.Color.AZUL;
		if (rdbtnPlata.isSelected())
			return concesionarioCoches.Color.PLATA;

		return concesionarioCoches.Color.ROJO;

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
