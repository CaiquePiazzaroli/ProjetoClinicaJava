package controller;

import view.TelaCadastroPaciente;
import modelo.dao.PacienteDao;
import modelo.entidade.Paciente;

public class PacienteController {
	
	Paciente paciente;
	
	//O método abaixo envia os dados do paciente que foram capturados na tela de cadastro de paciente para o banco de dados
	public String salvaPaciente(TelaCadastroPaciente pacienteTela) {
		this.paciente = pacienteTela.getPaciente();
		PacienteDao pacienteDao = new PacienteDao();
		String resultadoSalvaPaciente = pacienteDao.salvarPaciente(this.paciente);
		return resultadoSalvaPaciente;
	}
}
