package modelo.entidade;

public class Convenio {
	
	private String descricaoConvenio, idConvenio;
	
	public Convenio(String descricaoConvenio, String idConvenio) {
		this.descricaoConvenio = descricaoConvenio;
		this.idConvenio = idConvenio;
	}

	public String getDescricaoConvenio() {
		return descricaoConvenio;
	}

	public void setDescricaoConvenio(String descricaoConvenio) {
		this.descricaoConvenio = descricaoConvenio;
	}

	public String getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(String idConvenio) {
		this.idConvenio = idConvenio;
	}
	
}
