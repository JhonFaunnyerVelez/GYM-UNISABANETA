package co.com.gym.model;

// default package
// Generated 22-may-2017 20:46:06 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbUsuario generated by hbm2java
 */
public class TbUsuario implements java.io.Serializable {

	private Integer idTbUsuario;
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
	private Integer fktipoUsuario;
	private String dsestadocivil;
	private String deespecialidad;
	private Integer nmedad;
	private Integer nmcelular;

	public TbUsuario() {
	}

	public TbUsuario(TbTipoUsuario tbTipoUsuario, String dsnombre, String dsprimerapellido, int nmautorizado,
			String dscorreo, Date fefechanacimiento, int nmdocumento) {
		this.tbTipoUsuario = tbTipoUsuario;
		this.dsnombre = dsnombre;
		this.dsprimerapellido = dsprimerapellido;
		this.nmautorizado = nmautorizado;
		this.dscorreo = dscorreo;
		this.fefechanacimiento = fefechanacimiento;
		this.nmdocumento = nmdocumento;
	}

	public TbUsuario(TbTipoUsuario tbTipoUsuario, String dsnombre, String dsprimerapellido, String dssegundoapellido,
			int nmautorizado, String dscorreo, Date fefechanacimiento, int nmdocumento, String dscontrasena,
			String dstelefono, String dsdireccion, String dssexo, String dsocupacion, String feregistro,
			Integer fktipoUsuario, String dsestadocivil, String deespecialidad, Integer nmedad, Integer nmcelular) {
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
		this.fktipoUsuario = fktipoUsuario;
		this.dsestadocivil = dsestadocivil;
		this.deespecialidad = deespecialidad;
		this.nmedad = nmedad;
		this.nmcelular = nmcelular;
	}

	public Integer getIdTbUsuario() {
		return this.idTbUsuario;
	}

	public void setIdTbUsuario(Integer idTbUsuario) {
		this.idTbUsuario = idTbUsuario;
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

	public Integer getFktipoUsuario() {
		return this.fktipoUsuario;
	}

	public void setFktipoUsuario(Integer fktipoUsuario) {
		this.fktipoUsuario = fktipoUsuario;
	}

	public String getDsestadocivil() {
		return this.dsestadocivil;
	}

	public void setDsestadocivil(String dsestadocivil) {
		this.dsestadocivil = dsestadocivil;
	}

	public String getDeespecialidad() {
		return this.deespecialidad;
	}

	public void setDeespecialidad(String deespecialidad) {
		this.deespecialidad = deespecialidad;
	}

	public Integer getNmedad() {
		return this.nmedad;
	}

	public void setNmedad(Integer nmedad) {
		this.nmedad = nmedad;
	}

	public Integer getNmcelular() {
		return this.nmcelular;
	}

	public void setNmcelular(Integer nmcelular) {
		this.nmcelular = nmcelular;
	}


}
