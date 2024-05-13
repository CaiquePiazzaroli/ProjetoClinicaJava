package modelo.dao;

import modelo.entidade.*;
import modelo.dao.Conexao;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PacienteDao {
	
	//Instanciando o módulo de conexao com o banco
	Conexao moduloConexao = new Conexao();
	
	//Recebendo a conexao com banco
	Connection conexao = moduloConexao.conector();
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	//O método salvarPaciente salva os dados do paciente no banco de dados
	public String salvarPaciente(Paciente paciente) {
		String sql = "insert into pacientes (nomePaciente, dataNascimento, rg, altura, peso, sexo, telefone, cel, idConvenio) values (?,?,?,?,?,?,?,?,?)";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, paciente.getNomePaciente()); //Obrigatório
			pst.setString(2, paciente.getDataNascimento()); //Obrigatório
			pst.setString(3, paciente.getRg()); //Obrigatório
			pst.setString(4, paciente.getAltura()); //Não obrigatório
			pst.setString(5, paciente.getPeso()); //Não obrigatório
			pst.setString(6, paciente.getSexo()); //Obrigatório
			pst.setString(7, paciente.getNumeroTelefone()); //Não é obrigatório
			pst.setString(8, paciente.getCel()); //Não é obrigatório
			pst.setString(9, paciente.getConvenio()); //Obrigatório
			if(
				paciente.getNomePaciente().isEmpty() || paciente.getDataNascimento().isEmpty() 
				|| paciente.getRg().isEmpty() || paciente.getConvenio().isEmpty() 
			){
				return "camposVazios";
			} else {
				int adicionado = pst.executeUpdate();
				if(adicionado > 0) {
					return "sucesso";
				} else {
					return "usuarioInvalido";
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return "erroBD";
		}
	}
	
	public ResultSet selectPacientes(JTable tabela, JTextField campoPesquisa) {
		//Query que será executada no banco de dados
		String sql= "Select idPaciente as id, nomePaciente as Nome, dataNascimento as DataNascimento, "
				+ "rg as rg, altura as Altura, peso as Peso, sexo as Sexo, telefone as Telefone, cel as Cel, idConvenio as Convenio from pacientes where nomePaciente like ?";
		try {
			pst = conexao.prepareStatement(sql);
			
			//Passando o conteúdo da caixa de pesquisa para o ?
			//atenção ao "%" - continuação da String sql
			
			pst.setString(1, campoPesquisa.getText() + "%");
			rs = pst.executeQuery();
			
			//Retornando o RS
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	
	public String updatePaciente(Paciente paciente, String idPaciente) {
		String sql = "update pacientes set nomePaciente = ?, dataNascimento = ?, rg= ?, altura= ?, peso= ?, sexo= ?, telefone= ?, cel= ?, idConvenio= ? where idPaciente = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, paciente.getNomePaciente().toString()); 
			pst.setString(2, paciente.getDataNascimento().toString());
			pst.setString(3, paciente.getRg().toString()); 
			pst.setString(4, paciente.getAltura().toString()); 
			pst.setString(5, paciente.getPeso().toString()); 
			pst.setString(6, paciente.getSexo().toString()); 
			pst.setString(7, paciente.getNumeroTelefone().toString()); 
			pst.setString(8, paciente.getCel().toString()); 
			pst.setString(9, paciente.getConvenio().toString());
			pst.setString(10, idPaciente.toString());
			if(
					paciente.getNomePaciente().isEmpty() || paciente.getDataNascimento().isEmpty() 
					|| paciente.getRg().isEmpty() || paciente.getConvenio().isEmpty() 
			){
					return "camposVazios";
			} else {
				int adicionado = pst.executeUpdate();
				if(adicionado > 0) {
					return "sucesso";
				} else {
					return "usuarioInvalido";
				}
			}		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
   }
	

	public String deletePaciente(String idPaciente) {
		String sql = "delete from pacientes where idPaciente = ?";
		try {
			int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover este cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
			if(confirma==JOptionPane.YES_OPTION) {
				pst = conexao.prepareStatement(sql);
				pst.setString(1, idPaciente.toString());
				int apagado = pst.executeUpdate();
				if(apagado > 0) {
					return "sucesso";
				} else {
					return "falha";
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
   }

	
}