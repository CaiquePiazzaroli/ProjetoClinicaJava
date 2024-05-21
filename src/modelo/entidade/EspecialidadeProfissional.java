package modelo.entidade;

public class EspecialidadeProfissional {
	
	private String idProfissional, nomeEspecialidade;
	
	EspecialidadeProfissional(String idProfissional, String nomeEspecialidade){
		this.idProfissional = idProfissional;
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public String getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(String idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}
		
}
