package modelo.entidade;

import javax.swing.JOptionPane;

public class Eletrocardio {
	
	private String paciente, idade, profissional, horarioExame, dataExame, idAgendamento, interpretacao, obsExame;

	public Eletrocardio(String paciente, String idade, String profissional, String horarioExame, String dataExame,
			String idAgendamento, String interpretacao, String obsExame) {
		this.paciente = paciente;
		this.idade = idade;
		this.profissional = profissional;
		this.horarioExame = horarioExame;
		this.dataExame = dataExame;
		this.idAgendamento = idAgendamento;
		this.interpretacao = interpretacao;
		this.obsExame = obsExame;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public String getHorarioExame() {
		return horarioExame;
	}

	public void setHorarioExame(String horarioExame) {
		this.horarioExame = horarioExame;
	}

	public String getDataExame() {
		return dataExame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}

	public String getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public String getInterpretacao() {
		return interpretacao;
	}

	public void setInterpretacao(String interpretacao) {
		this.interpretacao = interpretacao;
	}

	public String getObsExame() {
		return obsExame;
	}

	public void setObsExame(String obsExame) {
		this.obsExame = obsExame;
	}
	
	
	
	
}
