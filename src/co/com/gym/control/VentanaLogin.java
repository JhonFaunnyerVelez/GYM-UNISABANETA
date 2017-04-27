package co.com.gym.control;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import co.com.gym.impl.UsuarioImpl;
import co.com.gym.model.Usuario;

public class VentanaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214898667088555065L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JLabel lblImagen,lblOlvidoContra;
	private Color azul=new Color(20,130,200);
	
	UsuarioImpl usuarioImpl = new UsuarioImpl();
	private JLabel lblSalir;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 260, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		lblSalir=new JLabel("Salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Salir();
			}
		});
		lblSalir.setBounds(179,353,41,34);
		Font font=lblSalir.getFont();
		Map atributos=font.getAttributes();
		atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblSalir.setFont(font.deriveFont(atributos));
		lblSalir.setForeground(azul);
		lblSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lblSalir);
		
		lblImagen=new JLabel();
		lblImagen.setBounds(40,5,200,200);
		lblImagen.setIcon(new ImageIcon(getClass().getResource("/img/logo1.jpg")));
		contentPane.add(lblImagen);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(20, 200, 80, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(20, 250, 80, 30);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(100, 200, 120, 30);
		contentPane.add(txtUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(100, 250, 120, 30);
		contentPane.add(txtClave);
		
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ingresar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnIngresar.setBounds(30, 300, 190, 30);
		btnIngresar.setBackground(azul);
		btnIngresar.setForeground(Color.white);
		btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnIngresar);
		
		lblOlvidoContra = new JLabel("Olvidaste tu contrase\u00F1a");
		lblOlvidoContra.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//VentanaRegistro registro = new VentanaRegistro();
				//registro.setVisible(true);
				
			}
		});
		lblOlvidoContra.setBounds(19, 353, 150, 34);
		Font font1=lblOlvidoContra.getFont();
		Map atributos1=font1.getAttributes();
		atributos1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblOlvidoContra.setFont(font1.deriveFont(atributos1));
		lblOlvidoContra.setForeground(azul);
		lblOlvidoContra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lblOlvidoContra);
	}

	protected void ingresar() throws SQLException {
		// TODO Auto-generated method stub
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtClave.getPassword());
		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);
		
		Usuario usu = usuarioImpl.obtenerUsuario(usuario2);
		
		if(usu!=null){
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			this.dispose();
			//frmBienvenido hola = new frmBienvenido();
			//hola.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(contentPane, "Datos Invalidos","Error", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	public void Salir(){
		this.dispose();
	}


}
