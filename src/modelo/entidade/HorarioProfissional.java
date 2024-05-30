package modelo.entidade;

public class HorarioProfissional {
	
	private String idProfissional, diaSemana, horarioInicio, horarioFim;
	
	public HorarioProfissional(String idProfissional, String diaSemana, String horarioInicio, String horarioFim) {
		this.idProfissional = idProfissional;
		this.diaSemana = diaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}

	public String getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(String idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}
}
