package concesionarioGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


import concesionarioCoches.CocheNoExistenteException;
import concesionarioCoches.CocheYaExistenteException;
import concesionarioCoches.ColorNoValidoException;
import concesionarioCoches.MatriculaNoValidaException;
import concesionarioCoches.ModeloNoValidoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class EliminarCoche extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbMarcas;
	private JComboBox cbModelos;
	private JRadioButton rdbtnRojo;
	private JRadioButton rdbtnAzul;
	private JRadioButton rdbtnPlata;
	private JButton okButton;
	private JTextField txtMatricula;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EliminarCoche dialog = new EliminarCoche();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EliminarCoche() {
		setTitle("Eliminar Coche");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(28, 22, 72, 14);
		contentPanel.add(lblMatrcula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(91, 19, 86, 20);
		contentPanel.add(txtMatricula);
		txtMatricula.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						baja();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void baja() {
		try {
			if(General.concesionario
					.eliminar(txtMatricula.getText()));{
						JOptionPane.showMessageDialog(okButton,
								"Coche eliminado con éxito");
					}
			
			
		
		} catch (MatriculaNoValidaException | CocheNoExistenteException e) {
			JOptionPane.showMessageDialog(contentPanel,
					"El coche no se ha podido eliminar.", "Error",
					JOptionPane.ERROR_MESSAGE);;
		}
		
	}
}
