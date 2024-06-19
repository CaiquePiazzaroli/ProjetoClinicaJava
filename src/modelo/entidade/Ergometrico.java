package modelo.entidade;

public class Ergometrico {
	
	private String paciente, idade, profissional, horarioExame, dataExame, idAgendamento, duracaoProva,
	distanciaPercorrida, FCMaxima, debitoCardiaco, debtoSistolico, DPmaximo, METmaximo, obsExame;

	public Ergometrico(String paciente, String idade, String profissional, String horarioExame, String dataExame,
			String idAgendamento, String duracaoProva, String distanciaPercorrida, String fCMaxima,
			String debitoCardiaco, String debtoSistolico, String dPmaximo, String mETmaximo, String obsExame) {
		this.paciente = paciente;
		this.idade = idade;
		this.profissional = profissional;
		this.horarioExame = horarioExame;
		this.dataExame = dataExame;
		this.idAgendamento = idAgendamento;
		this.duracaoProva = duracaoProva;
		this.distanciaPercorrida = distanciaPercorrida;
		this.FCMaxima = fCMaxima;
		this.debitoCardiaco = debitoCardiaco;
		this.debtoSistolico = debtoSistolico;
		this.DPmaximo = dPmaximo;
		this.METmaximo = mETmaximo;
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

	public String getDuracaoProva() {
		return duracaoProva;
	}

	public void setDuracaoProva(String duracaoProva) {
		this.duracaoProva = duracaoProva;
	}

	public String getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(String distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public String getFCMaxima() {
		return FCMaxima;
	}

	public void setFCMaxima(String fCMaxima) {
		FCMaxima = fCMaxima;
	}

	public String getDebitoCardiaco() {
		return debitoCardiaco;
	}

	public void setDebitoCardiaco(String debitoCardiaco) {
		this.debitoCardiaco = debitoCardiaco;
	}

	public String getDebtoSistolico() {
		return debtoSistolico;
	}

	public void setDebtoSistolico(String debtoSistolico) {
		this.debtoSistolico = debtoSistolico;
	}

	public String getDPmaximo() {
		return DPmaximo;
	}

	public void setDPmaximo(String dPmaximo) {
		DPmaximo = dPmaximo;
	}

	public String getMETmaximo() {
		return METmaximo;
	}

	public void setMETmaximo(String mETmaximo) {
		METmaximo = mETmaximo;
	}

	public String getObsExame() {
		return obsExame;
	}

	public void setObsExame(String obsExame) {
		this.obsExame = obsExame;
	}
	
	
	
	
	
}
