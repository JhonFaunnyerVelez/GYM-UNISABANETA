package co.com.gym.control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import co.com.gym.impl.ServicioImpl;
import co.com.gym.model.TbServicio;
import co.com.gym.util.Conexion;




public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = -7140290221176595615L;
	private JMenuBar menuBar;
	private Color azul=new Color(20,130,200);
	private JPanel laminaServ;
	private JButton btnInstructor, btnCliente, btnRutina, btnTpContrato, btnAdmin;
	
	public JButton getBtnAdmin() {
		return btnAdmin;
	}

	public void setBtnAdmin(JButton btnAdmin) {
		this.btnAdmin = btnAdmin;
	}

	public JButton getBtnTpContrato() {
		return btnTpContrato;
	}

	public void setBtnTpContrato(JButton btnTpContrato) {
		this.btnTpContrato = btnTpContrato;
	}

	private JTextField txtNombre, txtDescripcion, txtCupo, txtFechReg;
	private JButton btnEliminar,btnModificar, btnGuardar, btnLimpiar;
	private JTextField txtBuscar, txtId;
	private JLabel lblId;
	private JTable tabla;
	private DefaultTableModel modelo;
	ServicioImpl servicioImpl = new ServicioImpl();
	TbServicio servicio1 = new TbServicio();
	private JButton btnPago;
	private JButton btnAsignar;
	private JButton btnInforme;
	private JButton btnCumpleaños;



	public JButton getBtnPago() {
		return btnPago;
	}

	public void setBtnPago(JButton btnPago) {
		this.btnPago = btnPago;
	}

	public JButton getBtnRutina() {
		return btnRutina;
	}

	public void setBtnRutina(JButton btnRutina) {
		this.btnRutina = btnRutina;
	}

	public JButton getBtnCliente() {
		return btnCliente;
	}

	public void setBtnCliente(JButton btnCliente) {
		this.btnCliente = btnCliente;
	}

	public JButton getBtnInstructor() {
		return btnInstructor;
	}

	public void setBtnInstructor(JButton btnInstructor) {
		this.btnInstructor = btnInstructor;
	}

	public static void main(String[] args) {
	
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
	}

	public VentanaMenu() {
		
		//TAMAï¿½O DEL MARCO DE LA VENTANA
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit mipantalla =Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla= mipantalla.getScreenSize();
		int ancho = tamanoPantalla.width;
		
		setSize(ancho-100, 650);
		setLocation((ancho/2-650) ,40);
		getContentPane().setBackground(Color.white);
		
		LaminaCliente laminaCliente = new LaminaCliente();
		getContentPane().add(laminaCliente);
		
		LaminaInstructor laminaInstruc = new LaminaInstructor();	
		getContentPane().add(laminaInstruc);
		

		
		LaminaRutina laminaRut = new LaminaRutina();
		
		getContentPane().add(laminaRut);
		
		LaminaTpContrato laminaCont = new LaminaTpContrato();
		getContentPane().add(laminaCont);
		
		LaminaAdmin laminaAdm = new LaminaAdmin();
		getContentPane().add(laminaAdm);
		
		LaminaPago laminaPago = new LaminaPago();
		getContentPane().add(laminaPago);
		
		LaminaAsignarServicio laminaAsignar = new LaminaAsignarServicio();
		getContentPane().add(laminaAsignar);

		LaminaInformes laminaInformes = new LaminaInformes();
		getContentPane().add(laminaInformes);
		
		Cumpleaños cumpleaños = new Cumpleaños();
		getContentPane().add(cumpleaños);

		
		//MENU BAR CON LOS BOTONES AGRAGADOS
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		btnCliente = new JButton("Cliente");
		btnCliente.setForeground(Color.white);
		btnCliente.setBackground(azul);
		menuBar.add(btnCliente);
		
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaInstruc.setVisible(false);
				laminaServ.setVisible(false);
				laminaRut.setVisible(false);
				laminaCont.setVisible(false);
				laminaAdm.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(false);
				laminaCliente.setVisible(true);
			}
		});
		
		btnInstructor = new JButton("Instructor");
		btnInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(false);
				laminaRut.setVisible(false);
				laminaServ.setVisible(false);
				laminaCont.setVisible(false);
				laminaAdm.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				cumpleaños.setVisible(false);
				laminaInformes.setVisible(false);
				laminaInstruc.setVisible(true);
				
			}
		});
		btnInstructor.setForeground(Color.white);
		btnInstructor.setBackground(azul);
		menuBar.add(btnInstructor);
		
		btnRutina = new JButton("Rutina");
		btnRutina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaServ.setVisible(false);
				laminaCont.setVisible(false);
				laminaAdm.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(false);
				laminaRut.setVisible(true);
			}
		});
		
		btnAdmin = new JButton("Administrador");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaServ.setVisible(false);
				laminaCont.setVisible(false);
				laminaRut.setVisible(false);
				laminaAdm.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(false);
				laminaAdm.setVisible(true);
			}
		});
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBackground(new Color(20, 130, 200));
		menuBar.add(btnAdmin);
		btnRutina.setForeground(Color.white);
		btnRutina.setBackground(azul);
		menuBar.add(btnRutina);
		

		
		JButton btnServicio = new JButton("Servicio");
		btnServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaRut.setVisible(false);
				laminaCont.setVisible(false);
				laminaAdm.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(false);
				laminaServ.setVisible(true);

			}
		});
		btnServicio.setForeground(Color.white);
		btnServicio.setBackground(azul);
		menuBar.add(btnServicio);
		
		btnTpContrato = new JButton("Contrato");
		btnTpContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaRut.setVisible(false);
				laminaServ.setVisible(false);
				laminaAdm.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(false);
				laminaCont.setVisible(true);
			}
		});
		btnTpContrato.setForeground(Color.WHITE);
		btnTpContrato.setBackground(new Color(20, 130, 200));
		menuBar.add(btnTpContrato);
		
		btnPago = new JButton("Pago");
		btnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaRut.setVisible(false);
				laminaServ.setVisible(false);
				laminaAdm.setVisible(false);
				laminaCont.setVisible(false);
				laminaAsignar.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(false);
				laminaPago.setVisible(true);

			}
		});
		btnPago.setForeground(Color.WHITE);
		btnPago.setBackground(new Color(20, 130, 200));
		menuBar.add(btnPago);
		
		btnAsignar = new JButton("Asignar Servicio");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaRut.setVisible(false);
				laminaServ.setVisible(false);
				laminaAdm.setVisible(false);
				laminaCont.setVisible(false);
				laminaPago.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(false);
				laminaAsignar.setVisible(true);

				
			}
		});
		btnAsignar.setForeground(Color.WHITE);
		btnAsignar.setBackground(new Color(20, 130, 200));
		menuBar.add(btnAsignar);
		
		btnInforme = new JButton("Informes");
		btnInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaRut.setVisible(false);
				laminaServ.setVisible(false);
				laminaAdm.setVisible(false);
				laminaCont.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				cumpleaños.setVisible(false);
				laminaInformes.setVisible(true);
			}
		});
		btnInforme.setForeground(Color.WHITE);
		btnInforme.setBackground(new Color(20, 130, 200));
		menuBar.add(btnInforme);
		
		btnCumpleaños = new JButton("Cumplea\u00F1os");
		btnCumpleaños.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				laminaCliente.setVisible(false);
				laminaInstruc.setVisible(false);
				laminaRut.setVisible(false);
				laminaServ.setVisible(false);
				laminaAdm.setVisible(false);
				laminaCont.setVisible(false);
				laminaPago.setVisible(false);
				laminaAsignar.setVisible(false);
				laminaInformes.setVisible(false);
				cumpleaños.setVisible(true);
			}
		});
		btnCumpleaños.setForeground(Color.WHITE);
		btnCumpleaños.setBackground(new Color(20, 130, 200));
		menuBar.add(btnCumpleaños);
		
		//------------------------------------------------------
		
		
		
				
				//LAMINA SERVICIO
				
				laminaServ = new JPanel();
				laminaServ.setBounds(10, 20, 1240, 568);
				laminaServ.setVisible(false);
	
				getContentPane().setLayout(null);
				laminaServ.setBackground(Color.WHITE);
				laminaServ.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "SERVICIO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
				getContentPane().add(laminaServ);
				laminaServ.setVisible(false);
				laminaServ.setLayout(null);
				
				JLabel label = new JLabel("Nombre:");
				label.setBounds(408, 28, 83, 14);
				laminaServ.add(label);
				
				JLabel label_1 = new JLabel("Descripcion");
				label_1.setBounds(408, 59, 86, 14);
				laminaServ.add(label_1);
				
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				txtNombre.setBounds(537, 28, 86, 20);
				laminaServ.add(txtNombre);
				txtNombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(c<'a' || c>'z') e.consume();
						
					}
				});
				
				txtDescripcion = new JTextField();
				txtDescripcion.setColumns(10);
				txtDescripcion.setBounds(537, 59, 86, 20);
				laminaServ.add(txtDescripcion);

				
				JLabel lblFechaDeRegistro = new JLabel("Fecha de Registro:");
				lblFechaDeRegistro.setBounds(633, 59, 113, 14);
				
				
				JLabel label_3 = new JLabel("Cupo:");
				label_3.setBounds(633, 28, 67, 14);
				laminaServ.add(label_3);
				
				btnGuardar = new JButton("Guardar");
				btnGuardar.setForeground(Color.WHITE);
				btnGuardar.setBackground(new Color(20, 130, 200));
				btnGuardar.setBounds(439, 149, 89, 20);
				laminaServ.add(btnGuardar);
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {

							txtFechReg.setText(DameFechaRegistro());
							TbServicio servicio = new TbServicio(String.valueOf(txtNombre.getText()), String.valueOf(txtDescripcion.getText()), String.valueOf(txtCupo.getText()), Date.valueOf(txtFechReg.getText()));
							//CapturarDatos();
							servicioImpl.guardarServicio(servicio);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Clear_Table1();
						LlenarTabla("");
						limpiarCampos();
					}
				});
				
				btnLimpiar = new JButton("Limpiar");
				btnLimpiar.setForeground(Color.WHITE);
				btnLimpiar.setBackground(new Color(20, 130, 200));
				btnLimpiar.setBounds(538, 149, 89, 20);
				laminaServ.add(btnLimpiar);
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						limpiarCampos();
					}
				});
				
				txtCupo = new JTextField();
				txtCupo.setColumns(10);
				txtCupo.setBounds(768, 28, 86, 20);
				laminaServ.add(txtCupo);
				txtCupo.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(c<'0' || c>'9') e.consume();
						
					}
				});
				
				txtFechReg = new JTextField();
				txtFechReg.setColumns(10);
				txtFechReg.setBounds(768, 59, 86, 20);
				
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setForeground(Color.WHITE);
				btnEliminar.setEnabled(false);
				btnEliminar.setBackground(new Color(20, 130, 200));
				btnEliminar.setBounds(738, 149, 89, 20);
				laminaServ.add(btnEliminar);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							int id = Integer.valueOf(txtId.getText());
						    servicio1.setIdTbServicio(id);
							servicioImpl.eliminarServicio(servicio1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						limpiarCampos();
						Clear_Table1();
						LlenarTabla("");
						btnGuardar.setEnabled(true);
					
					}
				});
				
				btnModificar = new JButton("Modificar");
				btnModificar.setForeground(Color.WHITE);
				btnModificar.setEnabled(false);
				btnModificar.setBackground(new Color(20, 130, 200));
				btnModificar.setBounds(639, 149, 89, 20);
				laminaServ.add(btnModificar);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							txtFechReg.setText(DameFechaRegistro());
							servicio1.setIdTbServicio(Integer.valueOf(txtId.getText()));
							servicio1.setDsnombre(txtNombre.getText());
							servicio1.setDsdescripcion(txtDescripcion.getText());
							servicio1.setNmcupolimite(txtCupo.getText());
							servicio1.setFeregistro(Date.valueOf(txtFechReg.getText()));
							servicioImpl.modificarServicio(servicio1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						limpiarCampos();
						Clear_Table1();
						LlenarTabla("");
						btnGuardar.setEnabled(true);
					}
				});
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 233, 1220, 288);
				laminaServ.add(scrollPane);
				
				JLabel lblBuscarServicioX = new JLabel("Buscar Servicio X Nombre:");
				lblBuscarServicioX.setBounds(10, 213, 159, 14);
				laminaServ.add(lblBuscarServicioX);
				
				txtBuscar = new JTextField();
				txtBuscar.setColumns(10);
				txtBuscar.setBounds(171, 207, 86, 20);
				laminaServ.add(txtBuscar);
				
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setBackground(new Color(20, 130, 200));
				btnBuscar.setBounds(289, 207, 89, 20);
				laminaServ.add(btnBuscar);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
						Clear_Table1();
						LlenarTabla(txtBuscar.getText());
						}catch(Exception e){
							JOptionPane.showMessageDialog(null, "No hay un Servicio asociado a ese Nombre");
						}
					}
				});
				
				JButton btnActualizar = new JButton("Actualizar");
				btnActualizar.setForeground(Color.WHITE);
				btnActualizar.setBackground(new Color(20, 130, 200));
				btnActualizar.setBounds(569, 540, 106, 23);
				laminaServ.add(btnActualizar);
				btnActualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Clear_Table1();
						LlenarTabla("");
						btnBuscar.setEnabled(true);
						txtBuscar.setEnabled(true);
					
					}
				});
				
				txtId = new JTextField();
				txtId.setEditable(false);
				txtId.setBounds(279, 38, 86, 20);
				txtId.setVisible(false);
				laminaServ.add(txtId);
				txtId.setColumns(10);
				
				lblId = new JLabel("ID");
				lblId.setBounds(245, 41, 24, 14);
				lblId.setVisible(false);;
				laminaServ.add(lblId);
				
		
				modelo = new DefaultTableModel();
				modelo.addColumn("ID");
				modelo.addColumn("Nombre");
				modelo.addColumn("Descripcion");
				modelo.addColumn("Cupo");
				modelo.addColumn("Fech Registro");
				tabla = new JTable(modelo);
				JPopupMenu menu = new JPopupMenu();
				tabla.setComponentPopupMenu(menu);
				JMenuItem Modificar;
				menu.add(Modificar = new JMenuItem("Seleccionar"));
				Modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
							SeleccionarRegistro();
					}
				});
				scrollPane.setViewportView(tabla);
				
		
	}

public void SeleccionarRegistro(){
	int fila = tabla.getSelectedRow();
	if(fila>=0){
		txtId.setText(tabla.getValueAt(fila, 0).toString());
		txtNombre.setText(tabla.getValueAt(fila, 1).toString());
		txtDescripcion.setText(tabla.getValueAt(fila, 2).toString());
		txtCupo.setText(tabla.getValueAt(fila, 3).toString());
		txtFechReg.setText(tabla.getValueAt(fila, 4).toString());
		txtId.setVisible(true);
		lblId.setVisible(true);
		btnGuardar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
	}else{
		JOptionPane.showMessageDialog(null, "no selecciono fila");
	}
}
public void limpiarCampos(){
	btnEliminar.setEnabled(false);
	btnModificar.setEnabled(false);
	btnGuardar.setEnabled(true);
	txtBuscar.setText("");
	txtId.setText("");
	txtNombre.setText("");
	txtDescripcion.setText("");
	txtCupo.setText("");
	txtFechReg.setText("");
	txtId.setVisible(false);
	lblId.setVisible(false);
}
public void LlenarTabla(String valor){
	
	Conexion conexion= null;
	Statement st = null; 
	ResultSet rs =null; 
	String sql="";
	if (valor.equals("")){
		sql = "SELECT * FROM gym_unisabaneta.tb_servicio";
	}else
	{
		sql="SELECT * FROM gym_unisabaneta.tb_servicio WHERE DSNOMBRE='"+valor+"'";
	}
	try{
	    conexion = new Conexion();
	    st = conexion.Conexion().createStatement();
	    rs = st.executeQuery(sql);
	    while(rs.next()){
	        modelo.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)});
	    }
	    
	}catch(Exception e){
	    System.out.println("error");
	    e.printStackTrace();
	}
	finally{
		try {
			conexion.Conexion().close();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; 
	}
}
	
	/*Session sesion =  HibernateUtil.getSessionFactory().openSession();
	Transaction tr = null;
	TbServicio TbServicio = null;
	
	try{
		
		tr = sesion.beginTransaction();
		
		Query q =sesion.createQuery("SELECT s FROM TbServicio s ");
        List lista = q.list();
        lista.toArray();

        for( int i = 0; i < lista.size(); i++ ){
            TbServicio servicioAct = (TbServicio) lista.get( i );
		        modelo.addRow(new Object[] {Integer.valueOf(servicioAct.getIdTbServicio()),String.valueOf(servicioAct.getDsnombre()),String.valueOf(servicioAct.getDsdescripcion()),String.valueOf(servicioAct.getNmcupolimite()),servicioAct.getFeregistro()});

        }

	}catch(Exception e){
		if(tr != null){
			tr.rollback();
		}
		e.printStackTrace();
	}finally{
		sesion.close();	
	}*/
public String DameFechaRegistro(){
	Calendar c2 = new GregorianCalendar();
	int dia = c2.get(Calendar.DATE);
    int mes = c2.get(Calendar.MONTH)+1;
    int annio = c2.get(Calendar.YEAR);
    String dRegistro="";
    if (mes<10 && dia<10){
    	dRegistro = ""+annio+""+"-"+"0"+mes+""+"-"+"0"+dia+"";
    }
    return dRegistro;
}
private void Clear_Table1(){
       for (int i = 0; i < tabla.getRowCount(); i++) {
           modelo.removeRow(i);
           i-=1;
       }
   }
}
