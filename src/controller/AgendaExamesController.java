package controller;

import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;

import modelo.dao.AgendaExamesDao;
import modelo.entidade.AgendamentoConsulta;
import view.TelaAgendaExames;

public class AgendaExamesController {

	
	public void selectPacientesProfissionais(TelaAgendaExames telaAgenda) {
		AgendaExamesDao agendaDao = new AgendaExamesDao();
		telaAgenda.getCboNomePaciente().setModel(new DefaultComboBoxModel(agendaDao.selectPacientesDao()));
		telaAgenda.getCboProfissionalResponsavel().setModel(new DefaultComboBoxModel(agendaDao.selectProfissionaisDao()));
	}
	
	
	//CRUD
	
	public ResultSet buscarAgendamentos() {
		AgendaExamesDao agendaExames = new AgendaExamesDao();
		ResultSet rs = agendaExames.selectAgendamentos();
		return rs;
	}
	
	
	public void salvarAgendamento(AgendamentoConsulta agendamento) {
		AgendamentoConsulta agenda = agendamento;
		AgendaExamesDao agendaDao = new AgendaExamesDao();
		agendaDao.insertAgendamentos(agendamento);
	}
	
	
	public void updateAgendamentos(AgendamentoConsulta agendamento, String idAgendamento) {
		AgendaExamesDao agendaDao = new AgendaExamesDao();
		agendaDao.updateAgendamentos(agendamento,idAgendamento);
	}
	
	public void deleteAgendamentos(String idAgendamento) {
		AgendaExamesDao agendaDao = new AgendaExamesDao();
		agendaDao.deleteAgendamentos(idAgendamento);
	}

	public ResultSet selectHorarioProfissional(String nomeProf) {
		AgendaExamesDao agendaDao = new AgendaExamesDao();
		ResultSet rs = agendaDao.selectHorarioProfissional(nomeProf);
		return rs;
	}
	
	
}
