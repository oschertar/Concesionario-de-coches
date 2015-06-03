package concesionarioGUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import concesionarioCoches.Concesionario;
import concesionarioCoches.Fichero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PrincipalGUI {

	private JFrame frmConcesionario;
	private AnnadirCoche annadirCoche = new AnnadirCoche();
	private EliminarCoche eliminarCoche = new EliminarCoche();
	private MostrarCoche mostrarCoche = new MostrarCoche();
	private Ayuda ayuda = new Ayuda();
	private AcercaDe acercade = new AcercaDe();
	private JFrame nuevo = new JFrame();
	private MostrarPorColor mostrarPorColor = new MostrarPorColor();
	private MostrarConcesionario mostrarConcesionario = new MostrarConcesionario();
	private JFileChooser filechooser = new JFileChooser();
	private JMenuItem mntmNmeroTotalDe;
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter(
			"Archivos .obj", "obj");
	protected File archivoNuevo;
	protected File file;
	private String rutaFichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI window = new PrincipalGUI();
					window.frmConcesionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public PrincipalGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcesionario = new JFrame("Concesionario");
		frmConcesionario
				.setIconImage(Toolkit
						.getDefaultToolkit()
						.getImage(
								"C:\\Users\\Oscar\\Desktop\\pgTercerTrimestre\\InterfazGr\u00E1fica\\src\\img\\icon.png"));
		frmConcesionario.setResizable(false);
		frmConcesionario.getContentPane().setBackground(Color.WHITE);
		frmConcesionario.setBackground(Color.WHITE);
		frmConcesionario.setBounds(100, 100, 450, 300);
		frmConcesionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmConcesionario.setJMenuBar(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.setMnemonic('I');
		menuBar.add(mnInicio);

		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();

			}

		});
		mntmNuevoConcesionario.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_N, InputEvent.ALT_MASK));
		mnInicio.add(mntmNuevoConcesionario);

		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir");
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbrirConcesionario.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnInicio.add(mntmAbrirConcesionario);

		JMenuItem mntmGuardarConcesionario = new JMenuItem("Guardar ");
		mntmGuardarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardarConcesionario.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, InputEvent.ALT_MASK));
		mnInicio.add(mntmGuardarConcesionario);

		JMenuItem mntmGuardarCmo = new JMenuItem("Guardar c\u00F3mo ...");
		mntmGuardarCmo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarComo();
			}
		});
		mntmGuardarCmo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				InputEvent.ALT_MASK));
		mnInicio.add(mntmGuardarCmo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		JSeparator separator = new JSeparator();
		mnInicio.add(separator);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,
				InputEvent.CTRL_MASK));
		mnInicio.add(mntmSalir);

		JMenu mnEditar = new JMenu("Editar");
		mnEditar.setMnemonic('E');
		menuBar.add(mnEditar);

		JMenuItem mntmAadirCoche = new JMenuItem("A\u00F1adir coche");
		mntmAadirCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mntmAadirCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				annadirCoche.setVisible(true);
			}
		});
		mnEditar.add(mntmAadirCoche);

		JMenuItem mntmNewMenuItem = new JMenuItem("Eliminar coche");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCoche.setVisible(true);
			}
		});
		mnEditar.add(mntmNewMenuItem);

		JMenu mnBuscar = new JMenu("Visor");
		mnBuscar.setMnemonic('V');
		menuBar.add(mnBuscar);

		JMenu mnBuscar_1 = new JMenu("Buscar...");
		mnBuscar_1.setMnemonic('D');
		mnBuscar.add(mnBuscar_1);

		JMenuItem mntmPorMatrcula = new JMenuItem("Por matr\u00EDcula");
		mntmPorMatrcula.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.CTRL_MASK));
		mntmPorMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche.setVisible(true);
			}
		});
		mnBuscar_1.add(mntmPorMatrcula);

		JMenuItem mntmPorColor = new JMenuItem("Por color");
		mntmPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));
		mntmPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorColor.setVisible(true);
			}
		});
		mnBuscar_1.add(mntmPorColor);

		JMenuItem mntmNumeroTotalDe = new JMenuItem("Numero total de coches");
		mntmNumeroTotalDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mntmNumeroTotalDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
						mntmNumeroTotalDe,
						"Número total de coches: "
								+ General.concesionario.size());
			}
		});
		mnBuscar.add(mntmNumeroTotalDe);

		JMenuItem mntmMostrarConcesionario = new JMenuItem(
				"Mostrar Concesionario");
		mntmMostrarConcesionario.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConcesionario.setVisible(true);
			}
		});

		mnBuscar.add(mntmMostrarConcesionario);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercade.setVisible(true);
			}
		});

		JMenuItem mntmVerLaAyuda = new JMenuItem("Ver la ayuda");
		mntmVerLaAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmVerLaAyuda);
		mnAyuda.add(mntmAcercaDe);
		frmConcesionario.getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass()
				.getResource("/img/inicio.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(10, 11, 156, 219);
		frmConcesionario.getContentPane().add(label);

		JLabel lblConcesionarioIes = new JLabel("Concesionario");
		lblConcesionarioIes.setFont(new Font("Consolas", Font.BOLD
				| Font.ITALIC, 16));
		lblConcesionarioIes.setBounds(226, 36, 219, 75);
		frmConcesionario.getContentPane().add(lblConcesionarioIes);

		JLabel lblGranCapitn = new JLabel(" I.E.S. Gran Capit\u00E1n");
		lblGranCapitn
				.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		lblGranCapitn.setBounds(186, 93, 219, 75);
		frmConcesionario.getContentPane().add(lblGranCapitn);

	}

	private boolean guardar() {
		if (rutaFichero != null)
			return almacenar();
		else
			return guardarComo();
	}

	private boolean almacenar() {
		try {
			Fichero.guardar(filechooser.getSelectedFile(),
					General.concesionario);
			rutaFichero = filechooser.getSelectedFile().getAbsolutePath();
			frmConcesionario.setTitle(rutaFichero + " - Concesionario");
			General.concesionario.setModificado(false);
			return true;
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "No se ha podido guardar",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	private boolean guardarComo() {

		int opcion = filechooser.showSaveDialog(frmConcesionario);
		if (opcion == JFileChooser.APPROVE_OPTION)
			if (sobreescribir(filechooser.getSelectedFile()))
				return almacenar();
		return false;
	}

	protected boolean sobreescribir(File fileAux) {

		int opcion;
		if (fileAux.exists()) {
			opcion = JOptionPane.showConfirmDialog(frmConcesionario,
					"¿Sobreescribir?", "Guardar",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				return true;

			default:
				return false;
			}
		}
		return true;

	}

	private void nuevo() {
		if (General.concesionario.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(nuevo,
					"¿Deseas guardar el concesionario?");
			if (opcion == 0) {
				JFileChooser guardar = new JFileChooser();
				guardar.setFileFilter(filtro);
				opcion = guardar.showSaveDialog(frmConcesionario);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					file = guardar.getSelectedFile();
					try {
						Fichero.guardar(file, General.concesionario);
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
				General.concesionario = new Concesionario();
			} else if (opcion == 2)
				nuevo.setVisible(false);
			else
				General.concesionario = new Concesionario();
		} else
			General.concesionario = new Concesionario();
	}

	private void abrir() {
		JFileChooser abrir = new JFileChooser();
		abrir.setFileFilter(filtro);
		int opcion = abrir.showOpenDialog(frmConcesionario);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			
		try {
			General.concesionario = (concesionarioCoches.Concesionario) Fichero
					.abrir(abrir.getSelectedFile());
			rutaFichero = abrir.getSelectedFile().getAbsolutePath();
			frmConcesionario.setTitle(rutaFichero + " - Concesionario");
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		}
		
	}
}
