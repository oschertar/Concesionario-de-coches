package concesionarioGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AcercaDe dialog = new AcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setTitle("Acerca de");
		setBounds(100, 100, 417, 207);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnAcercaDeconcesionario = new JTextPane();
		txtpnAcercaDeconcesionario.setEditable(false);
		txtpnAcercaDeconcesionario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtpnAcercaDeconcesionario.setBackground(SystemColor.menu);
		txtpnAcercaDeconcesionario.setText("Acerca de \"Concesionario\"\r\nv1.11\r\nDesarrollado por \u00D3scar Heredia Tartajo\r\nAlumno 1\u00BA DAW I.E.S. Gran Capit\u00E1n\r\n\u00A9Copyright. All rights reserved.\r\n");
		txtpnAcercaDeconcesionario.setBounds(10, 11, 376, 207);
		contentPanel.add(txtpnAcercaDeconcesionario);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Atr\u00E1s");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
