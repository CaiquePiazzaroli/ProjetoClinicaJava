package modelo.entidade;

public class Ecocardiograma {
	
	private String paciente, idade, profissional, horarioExame, dataExame, idAgendamento,
	diaDiastolico, diaSistolico, espessuraDiastolicaSepto, espessuraDiastolicaPar, massaVentriculoEsquerdo,
	diametroDiastolico, diametroTelessistolico, diametroAorta, obsExame;
	
	public Ecocardiograma(
			String paciente, String idade, String profissional, String horarioExame, String dataExame, String idAgendamento,
			String diaDiastolico, String diaSistolico, String espessuraDiastolicaSepto, String espessuraDiastolicaPar, String massaVentriculoEsquerdo,
			String diametroDiastolico, String diametroTelessistolico, String diametroAorta, String obsExame) {
		this.paciente = paciente;
		this.idade = idade;
		this.profissional = profissional;
		this.horarioExame = horarioExame;
		this.dataExame = dataExame;
		this.idAgendamento = idAgendamento;
		this.diaDiastolico = diaDiastolico;
		this.diaSistolico = diaSistolico;
		this.espessuraDiastolicaSepto = espessuraDiastolicaSepto;
		this.espessuraDiastolicaPar = espessuraDiastolicaPar;
		this.massaVentriculoEsquerdo = massaVentriculoEsquerdo;
		this.diametroDiastolico = diametroDiastolico;
		this.diametroTelessistolico = diametroTelessistolico;
		this.diametroAorta = diametroAorta;
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

	public String getDiaDiastolico() {
		return diaDiastolico;
	}

	public void setDiaDiastolico(String diaDiastolico) {
		this.diaDiastolico = diaDiastolico;
	}

	public String getDiaSistolico() {
		return diaSistolico;
	}

	public void setDiaSistolico(String diaSistolico) {
		this.diaSistolico = diaSistolico;
	}

	public String getEspessuraDiastolicaSepto() {
		return espessuraDiastolicaSepto;
	}

	public void setEspessuraDiastolicaSepto(String espessuraDiastolicaSepto) {
		this.espessuraDiastolicaSepto = espessuraDiastolicaSepto;
	}

	public String getEspessuraDiastolicaPar() {
		return espessuraDiastolicaPar;
	}

	public void setEspessuraDiastolicaPar(String espessuraDiastolicaPar) {
		this.espessuraDiastolicaPar = espessuraDiastolicaPar;
	}

	public String getMassaVentriculoEsquerdo() {
		return massaVentriculoEsquerdo;
	}

	public void setMassaVentriculoEsquerdo(String massaVentriculoEsquerdo) {
		this.massaVentriculoEsquerdo = massaVentriculoEsquerdo;
	}

	public String getDiametroDiastolico() {
		return diametroDiastolico;
	}

	public void setDiametroDiastolico(String diametroDiastolico) {
		this.diametroDiastolico = diametroDiastolico;
	}

	public String getDiametroTelessistolico() {
		return diametroTelessistolico;
	}

	public void setDiametroTelessistolico(String diametroTelessistolico) {
		this.diametroTelessistolico = diametroTelessistolico;
	}

	public String getDiametroAorta() {
		return diametroAorta;
	}

	public void setDiametroAorta(String diametroAorta) {
		this.diametroAorta = diametroAorta;
	}

	public String getObsExame() {
		return obsExame;
	}

	public void setObsExame(String obsExame) {
		this.obsExame = obsExame;
	}
	
	
	
}
