package co.com.gym.control;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import co.com.gym.impl.UsuarioImpl;
import co.com.gym.model.TbUsuario;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = -2214898667088555065L;
	
	private JPanel lamina;
	
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	
	private JLabel lblImagen,lblOlvidoContra;
	private Color azul=new Color(20,130,200);
	
	private JLabel lblSalir;
	
	UsuarioImpl usuarioImpl = new UsuarioImpl();
	VentanaMenu menu = new VentanaMenu();
	

	public static void main(String[] args) {
		
					VentanaLogin Marco = new VentanaLogin();
					Marco.setVisible(true);
					Marco.setResizable(false);
					Marco.setLocationRelativeTo(null);
					
	}

	public VentanaLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 240, 330);
		
		lamina = new JPanel();
		lamina.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		getContentPane().add(lamina);
		lamina.setLayout(null);
		lamina.setBackground(Color.white);
		
		lblSalir=new JLabel("Salir");
		lblSalir.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Salir();
			}});
		
		
		lblSalir.setBounds(180,295,41,34);
		Font font=lblSalir.getFont();
		Map atributos=font.getAttributes();
		atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		lblSalir.setFont(font.deriveFont(atributos));
		lblSalir.setForeground(azul);
		lblSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lamina.add(lblSalir);
		
		lblImagen=new JLabel();
		lblImagen.setBounds(30,3,170,142);
		lblImagen.setIcon(new ImageIcon(getClass().getResource("/img/logo1.jpg")));
		lamina.add(lblImagen);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(20, 148, 80, 30);
		lamina.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(20, 189, 80, 30);
		lamina.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(100, 148, 120, 30);
		lamina.add(txtUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(100, 189, 120, 30);
		lamina.add(txtClave);
		
		
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
		btnIngresar.setBounds(30, 240, 190, 30);
		btnIngresar.setBackground(azul);
		btnIngresar.setForeground(Color.white);
		btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lamina.add(btnIngresar);
		
		lblOlvidoContra = new JLabel("Olvidaste tu contrase\u00F1a");
		lblOlvidoContra.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//VentanaRegistro registro = new VentanaRegistro();
				//registro.setVisible(true);
				
			}
		});
		lblOlvidoContra.setBounds(20, 295, 150, 34);
		Font font1=lblOlvidoContra.getFont();
		Map atributos1=font1.getAttributes();
		atributos1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lblOlvidoContra.setFont(font1.deriveFont(atributos1));
		lblOlvidoContra.setForeground(azul);
		lblOlvidoContra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lamina.add(lblOlvidoContra);
	}

	protected void ingresar() throws SQLException {
		// TODO Auto-generated method stub
		int usuario =  Integer.valueOf(txtUsuario.getText());
		String clave = String.valueOf(txtClave.getPassword());
		TbUsuario usuario2 = new TbUsuario();
		usuario2.setNmdocumento(usuario);
		usuario2.setDscontrasena(clave);
		
		TbUsuario usu = usuarioImpl.obtenerUsuario(usuario2);
		
		if(usu!=null){
			this.dispose();
			JOptionPane.showMessageDialog(lamina, "Bienvenido");
			menu.setVisible(true);
			
		}else{
			JOptionPane.showMessageDialog(lamina, "Datos Invalidos","Error", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	public void Salir(){
		this.dispose();
	}


}
