package co.com.gym.control;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7140290221176595615L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtCed;
	private JTextField txtClave;
	private JTextField txtNum;
	private JLabel lblNombre;
	private JLabel lblCedula;
	private JLabel lblContrasea;
	private JLabel lblNumero;
	private JButton btnRegistrarse;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(202, 73, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(202, 114, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCed = new JTextField();
		txtCed.setBounds(202, 162, 86, 20);
		contentPane.add(txtCed);
		txtCed.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(202, 206, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		txtNum = new JTextField();
		txtNum.setBounds(202, 252, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(101, 76, 62, 14);
		contentPane.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(101, 116, 62, 14);
		contentPane.add(lblNombre);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCedula.setBounds(101, 164, 62, 14);
		contentPane.add(lblCedula);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(101, 208, 77, 14);
		contentPane.add(lblContrasea);
		
		lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumero.setBounds(101, 254, 62, 14);
		contentPane.add(lblNumero);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(170, 299, 89, 29);
		contentPane.add(btnRegistrarse);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin login = new VentanaLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(0, 0, 112, 34);
		contentPane.add(btnRegresar);
	}

}
