package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class VisualizaExameDao {
	
	Conexao moduloConexao = new Conexao();
	
	Connection conexao = moduloConexao.conector();
	
	PreparedStatement pst = null;
	ResultSet rs = null;

	
	public ResultSet selectExameHolter(String tipoExame) {
		String sql = "select idExame as 'Exame', paciente as Paciente, profissional as 'Responsável', horarioExame as 'Horario', dataExame as 'Data', idAgendamento as 'Referente ao agendamento' from holter24";
		
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		
	}
	
	public ResultSet selectExameEco(String tipoExame) {
		String sql = "select * from ecocardiograma";
		
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		
	}
	
	public ResultSet selectExameEletro(String tipoExame) {
		String sql = "select * from eletrocardiograma";
		
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}	
	}
	
	public ResultSet selectExameErgo(String tipoExame) {
		String sql = "select * from ergometrico";
		
		try {
			pst = conexao.prepareStatement(sql);
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}	
	}
	
	
}
