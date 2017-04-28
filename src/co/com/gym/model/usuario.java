package co.com.gym.model;

public class Usuario {

	private int CDCODIGO;
	private String TBUSUARIO;
	private String DSNOMBRE;
	private int NMCEDULA;
	private String DS;
	private int NM; 

	public Usuario(int cDCODIGO, String tBUSUARIO, String dSNOMBRE, int nMCEDULA, String dS, int nM) {
		
		CDCODIGO = cDCODIGO;
		TBUSUARIO = tBUSUARIO;
		DSNOMBRE = dSNOMBRE;
		NMCEDULA = nMCEDULA;
		DS = dS;
		NM = nM;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getUsuario() {
		return TBUSUARIO;
	}

	public void setUsuario(String usuario) {
		this.TBUSUARIO = usuario;
	}

	public String getClave() {
		return DS;
	}

	public void setClave(String clave) {
		this.DS = clave;
	}
	
}
