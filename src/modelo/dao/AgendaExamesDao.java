package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.entidade.AgendamentoConsulta;

public class AgendaExamesDao {
	
	//Instanciando o módulo de conexao com o banco
	Conexao moduloConexao = new Conexao();
		
	//Recebendo a conexao com banco
	Connection conexao = moduloConexao.conector();
		
	PreparedStatement pst = null;
	ResultSet rs = null;

		
	public String[] selectPacientesDao() {

		try {
			//Query do banco de dados
			String sql = "select * from pacientes";
			
			pst = conexao.prepareStatement(sql);
			
			//executando a query
			rs = pst.executeQuery();
			
			
			// Verificando quantas linhas tem a query
            int linhas = 0;
            while (rs.next()) {
                linhas++;
            }
            
            //Executando a query novamente mas agora para salvar no array
            rs = pst.executeQuery();
            
            //Indice para percorrer o array
			int i = 0;
			
			//lista com o tamanho dos registro no banco
			String [] nomes = new String [linhas];
			
			while(rs.next()){
				//Adicionando os nomes na lista
				nomes[i] = rs.getString("nomePaciente").toString();
			    i++; 
			 }
			return nomes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	public String[] selectProfissionaisDao() {

		try {
			//Query do banco de dados
			String sql = "select * from profissionais";
			
			pst = conexao.prepareStatement(sql);
			
			//executando a query
			rs = pst.executeQuery();
			
			
			// Verificando quantas linhas tem a query
            int linhas = 0;
            while (rs.next()) {
                linhas++;
            }
            
            //Executando a query novamente mas agora para salvar no array
            rs = pst.executeQuery();
            
            //Indice para percorrer o array
			int i = 0;
			
			//lista com o tamanho dos registro no banco
			String [] nomes = new String [linhas];
			
			while(rs.next()){
				//Adicionando os nomes na lista
				nomes[i] = rs.getString("nomeProfissional").toString();
			    i++; 
			 }
			return nomes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	public ResultSet selectAgendamentos() {
		//Query que será executada no banco de dados
		String sql= "select * from agendamentos";
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//Retornando o RS
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	
	public void insertAgendamentos(AgendamentoConsulta agendamento) {
		
		String sql= "insert into agendamentos (nomeCliente, "
				+ "emailCliente, telefoneCliente, "
				+ "celularCliente, nomeProfissional, dataRealizacao, "
				+ "horario, statusAgendamento, obsExames) values (?,?,?,?,?,?,?,?,?)";
		try {
			
			pst = conexao.prepareStatement(sql);
			
			pst.setString(1, agendamento.getPacienteExame().toString());
			pst.setString(2, agendamento.getEmailPaciente().toString());
			pst.setString(3, agendamento.getTelefonePaciente().toString());
			pst.setString(4, agendamento.getCelularPaciente().toString());
			pst.setString(5, agendamento.getProfResponsavel().toString());
			pst.setString(6, agendamento.getDataRealizacao().toString());
			pst.setString(7, agendamento.getHoraRealizacao().toString());
			pst.setString(8, agendamento.getStatusConsulta().toString());
			pst.setString(9, agendamento.getObsExames().toString());
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Agendamento criado com sucesso!");
			
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	
	
	public void updateAgendamentos(AgendamentoConsulta agendamento, String idAgendamento) {
			
			String sql= "update agendamentos set nomeCliente = ?, "
					+ "emailCliente = ?, telefoneCliente = ?, "
					+ "celularCliente = ?, nomeProfissional = ?, dataRealizacao =?, "
					+ "horario = ?, statusAgendamento = ?, obsExames = ? where idAgendamento = ?";
			try {
				
				pst = conexao.prepareStatement(sql);
				
				pst.setString(1, agendamento.getPacienteExame().toString());
				pst.setString(2, agendamento.getEmailPaciente().toString());
				pst.setString(3, agendamento.getTelefonePaciente().toString());
				pst.setString(4, agendamento.getCelularPaciente().toString());
				pst.setString(5, agendamento.getProfResponsavel().toString());
				pst.setString(6, agendamento.getDataRealizacao().toString());
				pst.setString(7, agendamento.getHoraRealizacao().toString());
				pst.setString(8, agendamento.getStatusConsulta().toString());
				pst.setString(9, agendamento.getObsExames().toString());
				pst.setString(10, idAgendamento);
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Agendamento alterado com sucesso!");
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				
			}
		}
	
	
	
	public void deleteAgendamentos(String idAgendamento) {
		
		String sql= "delete from agendamentos where idAgendamento = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, idAgendamento);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Agendamento excluido com sucesso!");
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
	}
	
		public ResultSet selectHorarioProfissional(String nomeProfissional) {
			String idProfissionalSql = "select * from profissionais where nomeProfissional = ?";
			PreparedStatement pstId = null;
			ResultSet rsId = null;
			String idProf= null;
			
			String sql= "select nomeEspecialidade, diaSemana, horaInicio, horaFim as nome from horarioProfissional where idProfissional = ?";
			
			try {
				
				pstId= conexao.prepareStatement(idProfissionalSql);
				pstId.setString(1, nomeProfissional);
				rsId = pstId.executeQuery();
				int i = 0;
				while(rsId.next()){
					//Adicionando os nomes na lista
					idProf = rsId.getString("idProfissional").toString();
				    i++; 
				}
		
				pst = conexao.prepareStatement(sql);
				pst.setString(1, idProf);
				rs = pst.executeQuery();
				return rs;
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
	}
}
