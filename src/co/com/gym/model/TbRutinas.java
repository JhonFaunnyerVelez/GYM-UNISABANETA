package co.com.gym.model;

// default package
// Generated 29-abr-2017 19:04:13 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbRutinas generated by hbm2java
 */
public class TbRutinas implements java.io.Serializable {

	private Integer idTbRutinas;
	private TbUsuario tbUsuario;
	private String dsnombrerutina;
	private String dsdescripcion;
	private Date fefechainicial;
	private Date fefechafinal;
	private Date feregistro;
	private Set tbRutinasXTbServicios = new HashSet(0);

	public TbRutinas() {
	}

	public TbRutinas(TbUsuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

	public TbRutinas(TbUsuario tbUsuario, String dsnombrerutina, String dsdescripcion, Date fefechainicial,
			Date fefechafinal, Date feregistro, Set tbRutinasXTbServicios) {
		this.tbUsuario = tbUsuario;
		this.dsnombrerutina = dsnombrerutina;
		this.dsdescripcion = dsdescripcion;
		this.fefechainicial = fefechainicial;
		this.fefechafinal = fefechafinal;
		this.feregistro = feregistro;
		this.tbRutinasXTbServicios = tbRutinasXTbServicios;
	}

	public Integer getIdTbRutinas() {
		return this.idTbRutinas;
	}

	public void setIdTbRutinas(Integer idTbRutinas) {
		this.idTbRutinas = idTbRutinas;
	}

	public TbUsuario getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(TbUsuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

	public String getDsnombrerutina() {
		return this.dsnombrerutina;
	}

	public void setDsnombrerutina(String dsnombrerutina) {
		this.dsnombrerutina = dsnombrerutina;
	}

	public String getDsdescripcion() {
		return this.dsdescripcion;
	}

	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}

	public Date getFefechainicial() {
		return this.fefechainicial;
	}

	public void setFefechainicial(Date fefechainicial) {
		this.fefechainicial = fefechainicial;
	}

	public Date getFefechafinal() {
		return this.fefechafinal;
	}

	public void setFefechafinal(Date fefechafinal) {
		this.fefechafinal = fefechafinal;
	}

	public Date getFeregistro() {
		return this.feregistro;
	}

	public void setFeregistro(Date feregistro) {
		this.feregistro = feregistro;
	}

	public Set getTbRutinasXTbServicios() {
		return this.tbRutinasXTbServicios;
	}

	public void setTbRutinasXTbServicios(Set tbRutinasXTbServicios) {
		this.tbRutinasXTbServicios = tbRutinasXTbServicios;
	}

}
