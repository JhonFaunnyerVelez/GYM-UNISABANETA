package co.com.gym.model;

// default package
// Generated 29-abr-2017 19:04:13 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TbTipoUsuario generated by hbm2java
 */
public class TbTipoUsuario implements java.io.Serializable {

	private Integer idTipoUsuario;
	private String dsdescripcion;

	public TbTipoUsuario() {
	}

	public TbTipoUsuario(String dsdescripcion, Set tbUsuarios) {
		this.dsdescripcion = dsdescripcion;
	}

	public Integer getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getDsdescripcion() {
		return this.dsdescripcion;
	}

	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}


}