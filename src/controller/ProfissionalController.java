package controller;

import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JTextField;

import view.TelaCadastroProfissional;
import modelo.dao.*;

public class ProfissionalController {
		//O método abaixo chama o método da dal que recupera os dados da tabela paciente no banco de dados
		public ResultSet pesquisaProfissionais(TelaCadastroProfissional profissionalTela) {
			JTextField campoPesquisa = profissionalTela.getTxtPesquisarProf();
			ProfissionalDao profissionalDao = new ProfissionalDao();
			ResultSet resultadoSelectProfissional = profissionalDao.selectProfissionais(campoPesquisa);
			return resultadoSelectProfissional;
		}
				
		public void criarProfissional(String nomeProf) {
			String nomeProfissional = nomeProf;
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.createProfissional(nomeProfissional);
		}
		
		public void atualizarProfissional(String idProfissional, String nome) {
			String idProf = idProfissional;
			String nomeProf = nome;
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.updateProfissional(idProf, nomeProf);
		}
		
		public void excluirProfissional(String idProf) {
			String idProfissional = idProf;
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.deleteProfissional(idProf);
		}
		
//		//O método abaixo chama o metodo da dal que recupera as especialidade do profissional selecionado na tabela
//		public ResultSet pesquisaEspecialidadeProfissional(TelaCadastroProfissional profissionalTela) {
//			JTextField campoId = profissionalTela.getTxtIdProf();
//			ProfissionalDao profissionalDao = new ProfissionalDao();
//			ResultSet resultadoSelectEspecialidades = profissionalDao.selectEspecialidades(campoId);
//			return resultadoSelectEspecialidades;
//		}
//		
//		public void salvarEspecialidade(String idProf, String espec) {
//			String idProfissional = idProf;
//			String especialidade = espec;
//			ProfissionalDao profissionalDao = new ProfissionalDao();
//			profissionalDao.createEspecialidade(idProfissional, especialidade);
//		}
//		
//		public void excluirEspecialidade(String idProf, String espec) {
//			String idProfissional = idProf;
//			String especialidade = espec;
//			ProfissionalDao profissionalDao = new ProfissionalDao();
//			profissionalDao.deleteEspecialidade(idProfissional, especialidade);
//		}
		
		
		public ResultSet pesquisaHorarioProfissional(TelaCadastroProfissional profissionalTela) {
			String idProfissional = profissionalTela.getTxtIdProf().getText();
			ProfissionalDao profissionalDao = new ProfissionalDao();
			ResultSet resultadoSelectHorario = profissionalDao.SelectHorario(idProfissional);
			return resultadoSelectHorario;
		}
		
		public void salvarHorarioProfissional(TelaCadastroProfissional profissionalTela) {
			String idProfissional = profissionalTela.getTxtIdProf().getText();
			String especialidade = profissionalTela.getCboEspecialidade().getSelectedItem().toString();
			String diaSemana = profissionalTela.getCboDiaSemana().getSelectedItem().toString();
			String horaInicio = profissionalTela.getTxtHoraInicio().getText();
			String horaFim = profissionalTela.getTxtHoraFim().getText();
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.insertHorario(idProfissional,especialidade, diaSemana,horaInicio,horaFim);
		}
		
		public void atualizarHorarioProfissional(TelaCadastroProfissional profissionalTela) {
			String idProfissional = profissionalTela.getTxtIdProf().getText();
			String diaSemana = profissionalTela.getCboDiaSemana().getSelectedItem().toString();
			String horaInicio = profissionalTela.getTxtHoraInicio().getText();
			String horaFim = profissionalTela.getTxtHoraFim().getText();
			String especialidade = profissionalTela.getCboEspecialidade().getSelectedItem().toString();
			int linhaSelecionada = profissionalTela.getTblHorarioProf().getSelectedRow();
			String diaSemanaSelecionado = profissionalTela.getTblHorarioProf().getModel().getValueAt(linhaSelecionada, 1).toString();
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.updateHorario(idProfissional,especialidade, diaSemana,horaInicio,horaFim,diaSemanaSelecionado);
		}
		
		
		public void excluirHorarioProfissional(TelaCadastroProfissional profissionalTela) {
			String idProfissional = profissionalTela.getTxtIdProf().getText();
			int linhaSelecionada = profissionalTela.getTblHorarioProf().getSelectedRow();
			String diaSemanaSelecionado = profissionalTela.getTblHorarioProf().getModel().getValueAt(linhaSelecionada, 1).toString();
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.deleteHorario(idProfissional,diaSemanaSelecionado);
		}
		
		
}
	
