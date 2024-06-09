package modelo.entidade;

public class AgendamentoConsulta {
	
	private String pacienteExame, emailPaciente, telefonePaciente, celularPaciente, ProfResponsavel, dataRealizacao, horaRealizacao, ObsExames;
	
	public AgendamentoConsulta(String pacExame, String emailPac, String telPac, String celPac,String profResp, String dataReal, String horaReal, String obsExames) {
		this.pacienteExame = pacExame;
		this.emailPaciente = emailPac;
		this.telefonePaciente = telPac;
		this.celularPaciente = celPac;
		this.ProfResponsavel = profResp;
		this.dataRealizacao = dataReal;
		this.horaRealizacao = horaReal;
		this.ObsExames = obsExames;
	}

	public String getPacienteExame() {
		return pacienteExame;
	}

	public void setPacienteExame(String pacienteExame) {
		this.pacienteExame = pacienteExame;
	}

	public String getProfResponsavel() {
		return ProfResponsavel;
	}

	public void setProfResponsavel(String profResponsavel) {
		ProfResponsavel = profResponsavel;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public String getHoraRealizacao() {
		return horaRealizacao;
	}

	public void setHoraRealizacao(String horaRealizacao) {
		this.horaRealizacao = horaRealizacao;
	}

	public String getObsExames() {
		return ObsExames;
	}

	public void setObsExames(String obsExames) {
		ObsExames = obsExames;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	public String getCelularPaciente() {
		return celularPaciente;
	}

	public void setCelularPaciente(String celularPaciente) {
		this.celularPaciente = celularPaciente;
	}	
}
