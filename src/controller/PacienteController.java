package controller;

import view.TelaCadastroPaciente;

import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.dao.PacienteDao;
import modelo.entidade.Paciente;

public class PacienteController {
	

	//O método abaixo envia os dados do paciente que foram capturados na tela de cadastro de paciente para o banco de dados
	public String salvaPaciente(TelaCadastroPaciente pacienteTela) {
		Paciente paciente = pacienteTela.getPaciente();
		PacienteDao pacienteDao = new PacienteDao();
		String resultadoSalvaPaciente = pacienteDao.salvarPaciente(paciente);
		return resultadoSalvaPaciente;
	}
	
	//O método abaixo chama o método da dal que recupera os dados da tabela paciente no banco de dados
	public ResultSet pesquisaPacientes(TelaCadastroPaciente pacienteTela) {
		//Pega a tabela do form e envia para o paciente dao
		JTable tabelaPaciente = pacienteTela.getTbPacientes();
		JTextField campoPesquisa = pacienteTela.getTxtPacPesquisar();
		PacienteDao pacienteDao = new PacienteDao();
		ResultSet resultadoSelectPaciente = pacienteDao.selectPacientes(tabelaPaciente, campoPesquisa);
		return resultadoSelectPaciente;
	}
	
	//O método abaixo captura os dados do formulário do form do paciente e os envia ao metodo da classe PacienteDAO
	public String altualizaPaciente(TelaCadastroPaciente pacienteTela) {
		Paciente paciente = pacienteTela.getPaciente();
		String idPaciente =  pacienteTela.getTxtIdPaciente().getText();
		PacienteDao pacienteDao = new PacienteDao();
		String resultadoSalvaPaciente = pacienteDao.updatePaciente(paciente, idPaciente);
		System.out.println(resultadoSalvaPaciente);
		return resultadoSalvaPaciente;
	}
	
	//O método abaixo pega os dados do formulário e os envia para o metodo deletePaciente da classe pacienteDAO
	public String excluiPaciente(TelaCadastroPaciente pacienteTela) {
		String idPaciente =  pacienteTela.getTxtIdPaciente().getText();
		PacienteDao pacienteDao = new PacienteDao();
		String resultadoExcluiPaciente = pacienteDao.deletePaciente(idPaciente);
		return resultadoExcluiPaciente;
	}
	
	
}

