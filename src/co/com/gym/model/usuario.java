package co.com.gym.model;

public class usuario {

	private int CDCODIGO;
	private String TBUSUARIO;
	private String DSNOMBRE;
	private int NMCEDULA;
	private String DS;
	private int NM; 

	public usuario(int cDCODIGO, String tBUSUARIO, String dSNOMBRE, int nMCEDULA, String dS, int nM) {
		super();
		CDCODIGO = cDCODIGO;
		TBUSUARIO = tBUSUARIO;
		DSNOMBRE = dSNOMBRE;
		NMCEDULA = nMCEDULA;
		DS = dS;
		NM = nM;
	}

	public usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getUsuario() {
		return TBUSUARIO;
	}

	public void setUsuario(String usuario) {
		this.TBUSUARIO = usuario;
	}

	public String getContraseña() {
		return DS;
	}

	public void setContraseña(String contraseña) {
		this.DS = contraseña;
	}
	
}
