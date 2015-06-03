package concesionarioGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ayuda");

		setBounds(100, 100, 589, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 573, 330);
		contentPanel.add(scrollPane);

		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		scrollPane.setViewportView(editor);
		editor.setContentType("text/html");
		editor.setText("<style type=\"text/css\">\r\n \t#listaGeneral {\r\n  \t\tcolor: #000099;\r\n  \t\tfont-weight: bold;\r\n  \t\tfont-style: italic;\r\n     }\r\n\r\n\t#subLista{\r\n  \t\tcolor: #CC0000;\r\n     }\r\n\r\n     #indice{\r\n  \t\tfont-size: 17;\r\n  \t\t\r\n     }\r\n\r\n\r\n     \r\n\r\n  </style>\r\n\r\n\r\n\r\n<h1>Ayuda sobre Concesionario</h1><br>\r\n\r\n\r\n<ol>\r\n<a href=#primero><li id=\"indice\">Hist\u00F3rico de versiones</li></a>\r\n<a href=#segundo><li id=\"indice\">Men\u00FA Inicio</li></a>\r\n<a href=#tercero><li id=\"indice\">Men\u00FA Editar</li></a>\r\n<a href=#cuarto><li id=\"indice\">Men\u00FA Visor</li></a>\r\n</br>\r\n</br>\r\n</br>\r\n<hr noshade=\"noshade\" />\r\n</br>\r\n\r\n</ol>\r\n\t<ol>\r\n\t\t<a name=\"primero\"><li id=\"listaGeneral\">Hist\u00F3rico de versiones</li></a>\r\n\t\t\t\t\t<p>v1.12. A\u00F1adido icono al programa y refactorizaci\u00F3n del c\u00F3digo</i></p>\r\n\t\t\t\t\t\t<ul id=\"subLista\">\r\n\t\t\t\t\t\t\t<li>A\u00F1adido icono al programa principal (en su ventana principal y en la barra de tareas de Windows)\r\n\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t<li>Refactorizaci\u00F3n de los m\u00E9todos Nuevo(), Abrir(), Guardar()y GuardarComo().\r\n\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t</ul>\r\n\r\n\t\t\t\t\t<p>v1.11. Men\u00FA Ayuda incorporado y cambio menor</i></p>\r\n\t\t\t\t\t\t<ul id=\"subLista\">\r\n\t\t\t\t\t\t\t<li>A\u00F1adida ayuda al poner el rat\u00F3n sobre los campos del Men\u00FA A\u00F1adir Coche (informaci\u00F3n sobre el formato de \t\t\t\t\t\t\tmatr\u00EDcula, \t\t\t\t\tcolores y modelos/marcas)\r\n\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t</ul>\r\n\t\t\r\n\t\t\t\t\t<p>v1.1. Algunas mejoras en los men\u00FAs <i>\"A\u00F1adir Coche\"</i> y <i>\"Mostrar Concesionario\"</i></p>\r\n\t\t\t\t\t\t<ul id=\"subLista\">\r\n\t\t\t\t \t\t\t<li>A\u00F1adido color rojo a la hora de introducir una m\u00E1tricula no v\u00E1lida en el men\u00FA \"A\u00F1adir Coche\", adem\u00E1s de un letrero que muestra \"Matr\u00EDcula Inv\u00E1lida\" y un icono a su \t izquierda. \r\n\t\t\t\t \t\t\t</li>\r\n\t\t\t\t \t\t\t<li>Cuando se a\u00F1ade un coche podemos ver el color que hemos a\u00F1adido de una forma m\u00E1s intuitiva en la palabra que se refiere a cada Color. \r\n\t\t\t\t \t\t\t</li>\r\n \t\t\t\t\t\t\t<li>Al mostrar el concesionario completo, podemos ver el color de cada coche justo debajo de la tabla \"Colores\", as\u00ED como el logotipo de la marca de nuestro coche. \r\n \t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t</ul>\r\n\r\n\t\t\t\t\t<p>v1.0. Programa funcional</p>\r\n\r\n\r\n\t\t\r\n\t\t<a name=\"segundo\"><li id=\"listaGeneral\">Men\u00FA Inicio<i>(Atajo del teclado: Alt+I). </i></li></a>\r\n\t\t\t\t\t\t<p><ul id=\"ficheros\">\r\n\t\t\t\t \t\t\t<li><strong>Nuevo: </strong><i>(Atajo del teclado: Alt+N). </i>Se crea un nuevo concesionario vac\u00EDo. Nos pregunta si queremos guardar el concesionario que tenemos abierto en ese mismo \tmomento. \r\n\t\t\t\t \t\t\t</li>\r\n\t\t\t\t \t\t\t<li><strong>Abrir:</strong><i> (Atajo del teclado: Alt+A).</i> Abrimos un concesionario que anteriormente hayamos guardado en nuestro sistema.\r\n\t\t\t\t \t\t\t</li>\r\n\t\t \t\t\t\t \t<li><strong>Guardar:</strong><i><i> (Atajo del teclado: Alt+S).</i> Guarda el concesionario que tengamos abierto.\r\n\t\t \t\t\t\t \t</li>\r\n\t\t\t\t\t\t\t<li><strong>Guardar C\u00F3mo:</strong><i> (Atajo del teclado: Alt+G). </i>Guarda el concesionario que tengamos abierto con un nombre distinto. \r\n\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t \t<li><strong>Salir:</strong> <i>(Atajo del teclado: Ctrl+ENTER)</i>. Se cierra la aplicaci\u00F3n. \r\n\t\t\t\t\t\t \t</li>\r\n\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</p>\r\n\r\n\r\n\t\t<a name=\"tercero\"><li id=\"listaGeneral\">Men\u00FA Editar<i>(Atajo del teclado: Alt+E). </i></li></a>\r\n\t\t\t\t\t\t<p><ul id=\"editar\">\r\n\t\t\t\t\t\t\t<li><strong>A\u00F1adir Coche: </strong><i>(Atajo del teclado: Ctrl+A). </i>A\u00F1adir un coche al concesionario. \r\n\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t<li><strong>Campo Matr\u00EDcula: </strong>Deberemos de introducir una matr\u00EDcula v\u00E1lida del territorio Espa\u00F1ol, teniendo este tipo de matr\u00EDculas este formato 0000BBB. Admite n\u00FAmeros del 0 al 9, y todas las letras del abecedario excepto las vocales (A,E,I,O y U) y las letras Q o \u00D1. Al introducir la matr\u00EDcula y pulsar \"TAB\" nos saldr\u00E1 un mensaje a la derecha del campo si la matr\u00EDcula es incorrecta.\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li><strong>Campo Color:</strong> Aqu\u00ED podemos configurar nuestro coche con un color de los tres disponibles: Rojo, Azul o Plata. Seg\u00FAn que color elijamos, en la secci\u00F3n \"Buscar..--> Por Color\" veremos nuestro coche o no.\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li><strong>Campo Marca: </strong>Podemos elegir de que marca ser\u00E1 nuestro coche: BMW o SEAT\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t<li><strong>Campo Modelo: </strong>Este campo depende del anterior. Si en el campo Marca hemos elegido la marca BMW, nos saldr\u00E1n diferentes modelos para elegir: Serie 1, Serie 2, Serie 3 o Serie 5. Sin embargo, si hemos elegido la marca SEAT, podemos elegir entre los modelos Ibiza, Toledo o C\u00F3rdoba\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\r\n\t\t\t\t\t\t\t</li>\r\n\r\n\r\n\t\t\t\t\t\t\t<li><strong>Eliminar Coche: </strong><i>(Atajo del teclado: Ctrl+E). </i>Elimina un coche del concesionario. \r\n\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t<p><strong>Campo Matr\u00EDcula:</strong> Para poder eliminar un coche satisfactoriamente, solo necesitaremos introducir una matr\u00EDcula v\u00E1lida en este campo. L\u00F3gicamente, esa matr\u00EDcula deber\u00E1 estar registrada en nuestra base de datos y asociada a un coche que se ha tenido que crear previamente.</p>\r\n\r\n\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</p>\r\n\t\t<a name=\"cuarto\"><li id=\"listaGeneral\">Men\u00FA Visor<i>(Atajo del teclado: Alt+V). </i></li></a>\r\n\t\t\t\t\t\t<p>\r\n\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t<strong>Buscar...</strong>Posibilidad de buscar un coche seg\u00FAn dos criterios.\r\n\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t<ul>\r\n\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t<strong>Por Matr\u00EDcula: </strong><i>(Atajo del teclado: Ctrl+M). </i>Posibilidad de buscar un coche utilizando el campo matr\u00EDcula como criterio. Al introducir la matr\u00EDcula, buscar\u00E1 en el concesionario y comprobar\u00E1 si esa matr\u00EDcula est\u00E1 registrada o no. En caso afirmativo, nos mostrar\u00E1 la marca y modelo que corresponde a esa matr\u00EDcula adem\u00E1s del color del coche. Lectura individual de los coches (una matr\u00EDcula corresponde a un \u00FAnico coche).\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\r\n\t\t\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t<strong>Por Color: </strong><i>(Atajo del teclado: Ctrl+C). </i>Posibilidad de buscar un coche utilizando el campo color como criterio. Al introducir un color entre los tres disponibles, se mostrar\u00E1n todos los coches que tienen este color, as\u00ED como su matr\u00EDcula, marca y modelo. En esta b\u00FAsqueda, podremos obtener de 0 resultados (no existe ning\u00FAn coche con ese color en el concesionario) a \"n\" resultados (siendo n como m\u00EDnimo 1 y como m\u00E1ximo el n\u00FAmero de coches creados en el concesionario, ya que si todos estos coches son del mismo color, mostrar\u00EDa todos los coches.)\r\n\t\t\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t<strong>N\u00FAmero total de coches:</strong><i>(Atajo del teclado: Ctrl+N). </i>\r\n\t\t\t\t\t\t\t\t\tCada vez que vamos registrando coches en nuestro concesionario, vamos incrementado un contador interno, y gracias a este contador podemos ver cu\u00E1ntos coches se han creado correctamente en el concesionario.\r\n\r\n\t\t\t\t\t\t\t</li>\r\n\r\n\t\t\t\t\t\t\t<li>\r\n\t\t\t\t\t\t\t\t\t<strong>Mostrar Concesionario:</strong><i>(Atajo del teclado: Ctrl+M). </i>\r\n\t\t\t\t\t\t\t\t\tVista general de nuestro concesionario pulsando el bot\u00F3n \"Mostrar\".\r\n\t\t\t\t\t\t\t\t\tSi no existe ning\u00FAn coche nos aparecer\u00E1 un error advierti\u00E9ndonos sobre esto. Si como m\u00EDnimo hay un coche creado, podemos mostrar concesionario pero tendremos las flechas inhabilitadas.\r\n\t\t\t\t\t\t\t\t\tA partir de dos coches, las flechas se habilitar\u00E1n para que podamos desplazarnos por los datos (coches) generados. Tenemos los mismos campos que en la pesta\u00F1a \"A\u00F1adir Coche\"; matr\u00EDcula del coche, paleta de colores, marca del coche y el modelo correspondiente. Sin embargo, en este caso, la vista es m\u00E1s atractiva ya que el campo matr\u00EDcula aparece coloreado para una mejor visualizaci\u00F3n de este, as\u00ED como una vista previa del color elegido en la paleta de colores y el icono correspondiente a la marca del coche elegida.\r\n\r\n\t\t\t\t\t\t\t</li>\r\n\t\t\t\t\t\t</ul>\r\n\t\t\t\t\t\t</p>\t\r\n\t\t\r\n\r\n\t</ol>\r\n\r\n\r\n");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
