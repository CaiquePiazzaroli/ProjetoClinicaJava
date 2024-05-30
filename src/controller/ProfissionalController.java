package controller;

import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JTextField;

import view.TelaCadastroHorario;
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
		//O método abaixo chama o metodo da dal que recupera as especialidade do profissional selecionado na tabela
		public ResultSet pesquisaEspecialidadeProfissional(TelaCadastroProfissional profissionalTela) {
			JTextField campoId = profissionalTela.getTxtIdProf();
			ProfissionalDao profissionalDao = new ProfissionalDao();
			ResultSet resultadoSelectEspecialidades = profissionalDao.selectEspecialidades(campoId);
			return resultadoSelectEspecialidades;
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
		
		public void salvarEspecialidade(String idProf, String espec) {
			String idProfissional = idProf;
			String especialidade = espec;
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.createEspecialidade(idProfissional, especialidade);
		}
		
		public void excluirEspecialidade(String idProf, String espec) {
			String idProfissional = idProf;
			String especialidade = espec;
			ProfissionalDao profissionalDao = new ProfissionalDao();
			profissionalDao.deleteEspecialidade(idProfissional, especialidade);
		}
		
		public ResultSet pesquisaHorarioProfissional(TelaCadastroProfissional profissionalTela) {
			String idProfissional = profissionalTela.getTxtIdProf().getText();
			ProfissionalDao profissionalDao = new ProfissionalDao();
			ResultSet resultadoCreateHorario = profissionalDao.createHorario(idProfissional);
			return resultadoCreateHorario;
		}
		
		
}
