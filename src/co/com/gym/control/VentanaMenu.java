package co.com.gym.control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = -7140290221176595615L;
	private JMenuBar menuBar;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8;
	private JButton btnGuardar,btnCancelar;
	private Color azul=new Color(20,130,200);
	private JPanel laminaServ, laminaTbServ;
	private JScrollPane scrollCliente;
	private JTable tabla;


	public static void main(String[] args) {
	
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
	}

	public VentanaMenu() {
		
		//TAMA�O DEL MARCO DE LA VENTANA
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit mipantalla =Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla= mipantalla.getScreenSize();
		int ancho = tamanoPantalla.width;
		
		setSize(ancho/2, 650);
		setLocation(ancho/4 ,40);
		getContentPane().setBackground(Color.white);
		
		LaminaCliente laminaCliente = new LaminaCliente();
		LaminaTblClient laminaTblClient = new LaminaTblClient();
		//---------------------------------------------------------
		getContentPane().add(laminaCliente);
		getContentPane().add(laminaTblClient);
		
		LaminaInstructor laminaInstruc = new LaminaInstructor();
		laminaTbInstruct laminaTbIntruct = new laminaTbInstruct();
		
		getContentPane().add(laminaInstruc);
		getContentPane().add(laminaTbIntruct);
		
		LaminaRutina laminaRut = new LaminaRutina();
		LaminaTbRutina laminaTbRut = new LaminaTbRutina();
		
		getContentPane().add(laminaRut);
		getContentPane().add(laminaTbRut);

		
		//MENU BAR CON LOS BOTONES AGRAGADOS
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(Color.white);
		btnCliente.setBackground(azul);
		menuBar.add(btnCliente);
		
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(true);
				laminaTblClient.setVisible(true);
			}
		});
		
		JButton btnInstructor = new JButton("Instructor");
		btnInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(false);
				laminaTblClient.setVisible(false);
				laminaInstruc.setVisible(true);
				laminaTbIntruct.setVisible(true);
				
			}
		});
		btnInstructor.setForeground(Color.white);
		btnInstructor.setBackground(azul);
		menuBar.add(btnInstructor);
		
		JButton btnRutina = new JButton("Rutina");
		btnRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(false);
				laminaTblClient.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaTbIntruct.setVisible(false);
				laminaServ.setVisible(false);
				laminaTbServ.setVisible(false);
				laminaRut.setVisible(true);
				laminaTbRut.setVisible(true);
			}
		});
		btnRutina.setForeground(Color.white);
		btnRutina.setBackground(azul);
		menuBar.add(btnRutina);
		
		JButton btnServicio = new JButton("Servicio");
		btnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(false);
				laminaTblClient.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaTbIntruct.setVisible(false);
				laminaRut.setVisible(false);
				laminaTbRut.setVisible(false);
				laminaServ.setVisible(true);
				laminaTbServ.setVisible(true);
			}
		});
		btnServicio.setForeground(Color.white);
		btnServicio.setBackground(azul);
		menuBar.add(btnServicio);
		
		//------------------------------------------------------
		
		
		
				
				//LAMINA SERVICIO
				
				laminaServ = new JPanel();
				laminaServ.setBounds(24, 20, 629, 180);
	
				getContentPane().setLayout(null);
				laminaServ.setBackground(Color.WHITE);
				laminaServ.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Servicio", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
				getContentPane().add(laminaServ);
				laminaServ.setVisible(false);
				laminaServ.setLayout(null);
				
				textField = new JTextField();
				textField.setBounds(101, 26, 86, 20);
				laminaServ.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(101, 57, 86, 20);
				laminaServ.add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(101, 88, 86, 20);
				laminaServ.add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(313, 26, 86, 20);
				laminaServ.add(textField_3);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(313, 57, 86, 20);
				laminaServ.add(textField_4);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(313, 88, 86, 20);
				laminaServ.add(textField_5);
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.setBounds(222, 130, 89, 23);
				btnGuardar.setForeground(Color.white);
				btnGuardar.setBackground(azul);
				laminaServ.add(btnGuardar);
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(337, 130, 89, 23);
				btnCancelar.setBackground(azul);
				btnCancelar.setForeground(Color.white);
				laminaServ.add(btnCancelar);
				
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(506, 26, 86, 20);
				laminaServ.add(textField_6);
				
				textField_7 = new JTextField();
				textField_7.setColumns(10);
				textField_7.setBounds(506, 57, 86, 20);
				laminaServ.add(textField_7);
				
				textField_8 = new JTextField();
				textField_8.setColumns(10);
				textField_8.setBounds(506, 88, 86, 20);
				laminaServ.add(textField_8);
				
				JLabel lbLbel = new JLabel("New label");
				lbLbel.setBounds(30, 29, 46, 14);
				laminaServ.add(lbLbel);
				
				JLabel lbLbel_1 = new JLabel("New label");
				lbLbel_1.setBounds(30, 60, 46, 14);
				laminaServ.add(lbLbel_1);
				
				JLabel lbLbel_2 = new JLabel("New label");
				lbLbel_2.setBounds(30, 91, 46, 14);
				laminaServ.add(lbLbel_2);
				
				JLabel lb3 = new JLabel("New label");
				lb3.setBounds(240, 29, 46, 14);
				laminaServ.add(lb3);
				
				JLabel lb_1 = new JLabel("New label");
				lb_1.setBounds(240, 60, 46, 14);
				laminaServ.add(lb_1);
				
				JLabel lb_2 = new JLabel("New label");
				lb_2.setBounds(240, 91, 46, 14);
				laminaServ.add(lb_2);
				
				JLabel lb_3 = new JLabel("New label");
				lb_3.setBounds(437, 32, 46, 14);
				laminaServ.add(lb_3);
				
				JLabel lb_4 = new JLabel("New label");
				lb_4.setBounds(437, 63, 46, 14);
				laminaServ.add(lb_4);
				
				JLabel lb_5 = new JLabel("New label");
				lb_5.setBounds(437, 94, 46, 14);
				laminaServ.add(lb_5);
		
				//LAMINA DE LA TABLA INSTRUCTOR
				
				laminaTbServ = new JPanel();
				laminaTbServ.setBackground(Color.WHITE);
				laminaTbServ.setBounds(10, 211, 657, 374);
				getContentPane().add(laminaTbServ);
				laminaTbServ.setLayout(null);
				DefaultTableModel modelo3 = new DefaultTableModel();
				modelo3.addColumn("idServ");
				modelo3.addColumn("nombre");
				modelo3.addColumn("nacimiento");
				tabla = new JTable(modelo3);
				scrollCliente = new JScrollPane(tabla);
				scrollCliente.setBounds(10, 11, 637, 352);
				laminaTbServ.add(scrollCliente);
				
				//--------------------------------------------------------
		
		
	}
}
