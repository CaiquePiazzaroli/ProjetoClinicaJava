package modelo.dao;

import modelo.entidade.*;
import modelo.dao.Conexao;
import java.sql.*;

import javax.swing.JOptionPane;


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
}
