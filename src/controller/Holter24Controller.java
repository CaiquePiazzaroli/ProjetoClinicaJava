package controller;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import modelo.dao.Holter24Dao;
import modelo.entidade.Holter24;
import view.TelaCadastroHolter;

public class Holter24Controller {
	
	
	public void selectPacientesProfissionais(TelaCadastroHolter telaHolter) {
		Holter24Dao holterDao = new Holter24Dao();
		telaHolter.getCboNomePaciente().setModel(new DefaultComboBoxModel(holterDao.selectPacientesDao()));
		telaHolter.getCboProfissionalResponsavel().setModel(new DefaultComboBoxModel(holterDao.selectProfissionaisDao()));
	}
	
	
	public void salvarHolter24(Holter24 holterExame) {
		Holter24Dao holterDao = new Holter24Dao();
		holterDao.insertHolter24(holterExame);
	}
	
	public void atualizarHolter24(Holter24 holterExame, String idExame) {
		Holter24Dao holterDao = new Holter24Dao();
		holterDao.updateHolter24(holterExame, idExame);
	}
	
	public void excluirHolter24(String idExame) {
		Holter24Dao holterDao = new Holter24Dao();
		holterDao.deleteHolter24(idExame);
	}
	
	public ArrayList <String> buscarDadosExameHolter(String idExame) {
		Holter24Dao holterDao = new Holter24Dao();
		return holterDao.buscarDadosExameHolter(idExame);
	}
	
}
