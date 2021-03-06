package co.com.gym.model;

// default package
// Generated 22-may-2017 20:46:06 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * TbRutinasXTbServicio generated by hbm2java
 */
public class TbRutinasXTbServicio implements java.io.Serializable {

	private Integer cdcodigo;
	private TbRutinas tbRutinas;
	private TbServicio tbServicio;
	private Date feregistro;

	public TbRutinasXTbServicio() {
	}

	public TbRutinasXTbServicio(TbRutinas tbRutinas, TbServicio tbServicio) {
		this.tbRutinas = tbRutinas;
		this.tbServicio = tbServicio;
	}

	public TbRutinasXTbServicio(TbRutinas tbRutinas, TbServicio tbServicio, Date feregistro) {
		this.tbRutinas = tbRutinas;
		this.tbServicio = tbServicio;
		this.feregistro = feregistro;
	}

	public Integer getCdcodigo() {
		return this.cdcodigo;
	}

	public void setCdcodigo(Integer cdcodigo) {
		this.cdcodigo = cdcodigo;
	}

	public TbRutinas getTbRutinas() {
		return this.tbRutinas;
	}

	public void setTbRutinas(TbRutinas tbRutinas) {
		this.tbRutinas = tbRutinas;
	}

	public TbServicio getTbServicio() {
		return this.tbServicio;
	}

	public void setTbServicio(TbServicio tbServicio) {
		this.tbServicio = tbServicio;
	}

	public Date getFeregistro() {
		return this.feregistro;
	}

	public void setFeregistro(Date feregistro) {
		this.feregistro = feregistro;
	}

}
