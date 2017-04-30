package co.com.gym.model;

// default package
// Generated 29-abr-2017 19:04:13 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * TbRutinasXTbServicio generated by hbm2java
 */
public class TbRutinasXTbServicio implements java.io.Serializable {

	private TbRutinasXTbServicioId id;
	private TbRutinas tbRutinas;
	private TbServicio tbServicio;
	private Date feregistro;

	public TbRutinasXTbServicio() {
	}

	public TbRutinasXTbServicio(TbRutinasXTbServicioId id, TbRutinas tbRutinas, TbServicio tbServicio) {
		this.id = id;
		this.tbRutinas = tbRutinas;
		this.tbServicio = tbServicio;
	}

	public TbRutinasXTbServicio(TbRutinasXTbServicioId id, TbRutinas tbRutinas, TbServicio tbServicio,
			Date feregistro) {
		this.id = id;
		this.tbRutinas = tbRutinas;
		this.tbServicio = tbServicio;
		this.feregistro = feregistro;
	}

	public TbRutinasXTbServicioId getId() {
		return this.id;
	}

	public void setId(TbRutinasXTbServicioId id) {
		this.id = id;
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
