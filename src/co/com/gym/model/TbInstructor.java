package co.com.gym.model;

// default package
// Generated 29-abr-2017 19:04:13 by Hibernate Tools 4.3.1.Final

import java.util.Date;

public class TbInstructor implements java.io.Serializable {

	public TbInstructor(Integer idTbInstructor, String dsnombre, String dsprimerapellido, String dssegundoapellido,
			Integer nmtelefono, String dsdireccion, int nmdocumento, String dscorreo, Date fefechanacimiento,
			Date feregistro) {
		super();
		this.idTbInstructor = idTbInstructor;
		this.dsnombre = dsnombre;
		this.dsprimerapellido = dsprimerapellido;
		this.dssegundoapellido = dssegundoapellido;
		this.nmtelefono = nmtelefono;
		this.dsdireccion = dsdireccion;
		this.nmdocumento = nmdocumento;
		this.dscorreo = dscorreo;
		this.fefechanacimiento = fefechanacimiento;
		this.feregistro = feregistro;
	}

	private Integer idTbInstructor;
	private String dsnombre;
	private String dsprimerapellido;
	private String dssegundoapellido;
	private Integer nmtelefono;
	private String dsdireccion;
	private int nmdocumento;
	private String dscorreo;
	private Date fefechanacimiento;
	private Date feregistro;

	public TbInstructor() {
	}

	public TbInstructor(int nmdocumento) {
		this.nmdocumento = nmdocumento;
	}

	public TbInstructor(String dsnombre, String dsprimerapellido, String dssegundoapellido, Integer nmtelefono,
			String dsdireccion, int nmdocumento, String dscorreo, Date fefechanacimiento, Date feregistro) {
		this.dsnombre = dsnombre;
		this.dsprimerapellido = dsprimerapellido;
		this.dssegundoapellido = dssegundoapellido;
		this.nmtelefono = nmtelefono;
		this.dsdireccion = dsdireccion;
		this.nmdocumento = nmdocumento;
		this.dscorreo = dscorreo;
		this.fefechanacimiento = fefechanacimiento;
		this.feregistro = feregistro;
	}

	public Integer getIdTbInstructor() {
		return this.idTbInstructor;
	}

	public void setIdTbInstructor(Integer idTbInstructor) {
		this.idTbInstructor = idTbInstructor;
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

	public Integer getNmtelefono() {
		return this.nmtelefono;
	}

	public void setNmtelefono(Integer nmtelefono) {
		this.nmtelefono = nmtelefono;
	}

	public String getDsdireccion() {
		return this.dsdireccion;
	}

	public void setDsdireccion(String dsdireccion) {
		this.dsdireccion = dsdireccion;
	}

	public int getNmdocumento() {
		return this.nmdocumento;
	}

	public void setNmdocumento(int nmdocumento) {
		this.nmdocumento = nmdocumento;
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

	public Date getFeregistro() {
		return this.feregistro;
	}

	public void setFeregistro(Date feregistro) {
		this.feregistro = feregistro;
	}


}
