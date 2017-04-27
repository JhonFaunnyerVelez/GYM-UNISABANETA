package co.com.gym.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ventanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaLogin frame = new ventanaLogin();
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
	public ventanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(72, 87, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(53, 129, 65, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(151, 84, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(151, 126, 86, 20);
		contentPane.add(txtContraseña);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnSalir.setBounds(106, 192, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setBounds(257, 192, 89, 23);
		contentPane.add(btnIngresar);
	}

	protected void ingresar() {
		// TODO Auto-generated method stub
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtContraseña.getPassword());
		GestionUsuario gestionUsuario = new GestionUsuario();
		usuario usuario2=new usuario();
		usuario2.setUsuario(usuario);
		usuario2.setContraseña(clave);
		
		usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		
		if(usu!=null){
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			//this.dispose();
			//frmBienvenido hola = new frmBienvenido();
			//hola.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(contentPane, "Datos Invalidos","Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	protected void salir() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
