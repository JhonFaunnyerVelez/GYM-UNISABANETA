package co.com.gym.model;

// default package
// Generated 29-abr-2017 19:04:13 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbUsuario generated by hbm2java
 */
public class TbUsuario implements java.io.Serializable {

	private Integer idTbUsuario;
	private TbInstructor tbInstructor;
	private TbTipoUsuario tbTipoUsuario;
	private String dsnombre;
	private String dsprimerapellido;
	private String dssegundoapellido;
	private int nmautorizado;
	private String dscorreo;
	private Date fefechanacimiento;
	private int nmdocumento;
	private String dscontrasena;
	private String dstelefono;
	private String dsdireccion;
	private String dssexo;
	private String dsocupacion;
	private String feregistro;

	public TbUsuario() {
	}
	

	public TbUsuario(int nmdocumento,String dscontrasena) {
		this.nmdocumento = nmdocumento;
		this.dscontrasena = dscontrasena;
	}

	public TbUsuario(TbInstructor tbInstructor, TbTipoUsuario tbTipoUsuario, String dsnombre, String dsprimerapellido,
			int nmautorizado, String dscorreo, Date fefechanacimiento, int nmdocumento) {
		this.tbInstructor = tbInstructor;
		this.tbTipoUsuario = tbTipoUsuario;
		this.dsnombre = dsnombre;
		this.dsprimerapellido = dsprimerapellido;
		this.nmautorizado = nmautorizado;
		this.dscorreo = dscorreo;
		this.fefechanacimiento = fefechanacimiento;
		this.nmdocumento = nmdocumento;
	}

	public TbUsuario(TbInstructor tbInstructor, TbTipoUsuario tbTipoUsuario, String dsnombre, String dsprimerapellido,
			String dssegundoapellido, int nmautorizado, String dscorreo, Date fefechanacimiento, int nmdocumento,
			String dscontrasena, String dstelefono, String dsdireccion, String dssexo, String dsocupacion,
			String feregistro, Set tbRutinases, Set tbEstadoPagos) {
		this.tbInstructor = tbInstructor;
		this.tbTipoUsuario = tbTipoUsuario;
		this.dsnombre = dsnombre;
		this.dsprimerapellido = dsprimerapellido;
		this.dssegundoapellido = dssegundoapellido;
		this.nmautorizado = nmautorizado;
		this.dscorreo = dscorreo;
		this.fefechanacimiento = fefechanacimiento;
		this.nmdocumento = nmdocumento;
		this.dscontrasena = dscontrasena;
		this.dstelefono = dstelefono;
		this.dsdireccion = dsdireccion;
		this.dssexo = dssexo;
		this.dsocupacion = dsocupacion;
		this.feregistro = feregistro;
	}

	public Integer getIdTbUsuario() {
		return this.idTbUsuario;
	}

	public void setIdTbUsuario(Integer idTbUsuario) {
		this.idTbUsuario = idTbUsuario;
	}

	public TbInstructor getTbInstructor() {
		return this.tbInstructor;
	}

	public void setTbInstructor(TbInstructor tbInstructor) {
		this.tbInstructor = tbInstructor;
	}

	public TbTipoUsuario getTbTipoUsuario() {
		return this.tbTipoUsuario;
	}

	public void setTbTipoUsuario(TbTipoUsuario tbTipoUsuario) {
		this.tbTipoUsuario = tbTipoUsuario;
	}

	public String getDsnombre() {
		return this.dsnombre;
	}

	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}

	public String getDsprimerapellido() {
		return this.dsprimerapellido;
	}

	public void setDsprimerapellido(String dsprimerapellido) {
		this.dsprimerapellido = dsprimerapellido;
	}

	public String getDssegundoapellido() {
		return this.dssegundoapellido;
	}

	public void setDssegundoapellido(String dssegundoapellido) {
		this.dssegundoapellido = dssegundoapellido;
	}

	public int getNmautorizado() {
		return this.nmautorizado;
	}

	public void setNmautorizado(int nmautorizado) {
		this.nmautorizado = nmautorizado;
	}

	public String getDscorreo() {
		return this.dscorreo;
	}

	public void setDscorreo(String dscorreo) {
		this.dscorreo = dscorreo;
	}

	public Date getFefechanacimiento() {
		return this.fefechanacimiento;
	}

	public void setFefechanacimiento(Date fefechanacimiento) {
		this.fefechanacimiento = fefechanacimiento;
	}

	public int getNmdocumento() {
		return this.nmdocumento;
	}

	public void setNmdocumento(int nmdocumento) {
		this.nmdocumento = nmdocumento;
	}

	public String getDscontrasena() {
		return this.dscontrasena;
	}

	public void setDscontrasena(String dscontrasena) {
		this.dscontrasena = dscontrasena;
	}

	public String getDstelefono() {
		return this.dstelefono;
	}

	public void setDstelefono(String dstelefono) {
		this.dstelefono = dstelefono;
	}

	public String getDsdireccion() {
		return this.dsdireccion;
	}

	public void setDsdireccion(String dsdireccion) {
		this.dsdireccion = dsdireccion;
	}

	public String getDssexo() {
		return this.dssexo;
	}

	public void setDssexo(String dssexo) {
		this.dssexo = dssexo;
	}

	public String getDsocupacion() {
		return this.dsocupacion;
	}

	public void setDsocupacion(String dsocupacion) {
		this.dsocupacion = dsocupacion;
	}

	public String getFeregistro() {
		return this.feregistro;
	}

	public void setFeregistro(String feregistro) {
		this.feregistro = feregistro;
	}



}
