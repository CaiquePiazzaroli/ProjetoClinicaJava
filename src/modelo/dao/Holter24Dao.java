package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.entidade.Holter24;

public class Holter24Dao {
		
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
	
	
	public void insertHolter24(Holter24 holter) {
		String sql = "insert into holter24  (paciente, idade, profissional, horarioExame, dataExame,"
				+ "idAgendamento,freqMax, freqMed, freqMin, totBat, varRR, extraVentr,"
				+ "extraVentrPar, tacVentr, extraSupra, tacSupra, obsExame) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, holter.getPaciente());
			pst.setString(2, holter.getIdade());
			pst.setString(3, holter.getProfissional());
			pst.setString(4, holter.getHorarioExame());
			pst.setString(5, holter.getDataExame());
			pst.setString(6, holter.getIdAgendamento());
			pst.setString(7, holter.getFreqMax());
			pst.setString(8, holter.getFreqMed());
			pst.setString(9, holter.getFreqMin());
			pst.setString(10, holter.getTotBat());
			pst.setString(11, holter.getVarRR());
			pst.setString(12, holter.getExtraVentr());
			pst.setString(13, holter.getExtraVentrPar());
			pst.setString(14, holter.getTacVentri());
			pst.setString(15, holter.getExtraSupra());
			pst.setString(16, holter.getTacSupra());
			pst.setString(17, holter.getObsExame());
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Exame adicionado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	public ArrayList <String> buscarDadosExameHolter(String IdExame) {
		String sql = "Select * from holter24 where idExame = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, IdExame);
			rs = pst.executeQuery();
			ArrayList<String> dadosHolter = new ArrayList<String>();
			while(rs.next()) {
				dadosHolter.add(rs.getString("idExame"));
				dadosHolter.add(rs.getString("paciente"));
				dadosHolter.add(rs.getString("idade"));
				dadosHolter.add(rs.getString("profissional"));
				dadosHolter.add(rs.getString("horarioExame"));
				dadosHolter.add(rs.getString("dataExame"));
				dadosHolter.add(rs.getString("idAgendamento"));
				dadosHolter.add(rs.getString("freqMax"));
				dadosHolter.add(rs.getString("freqMed"));
				dadosHolter.add(rs.getString("freqMin"));
				dadosHolter.add(rs.getString("totBat"));
				dadosHolter.add(rs.getString("varRR"));
				dadosHolter.add(rs.getString("extraVentr"));
				dadosHolter.add(rs.getString("extraVentrPar"));
				dadosHolter.add(rs.getString("tacVentr"));
				dadosHolter.add(rs.getString("extraSupra"));
				dadosHolter.add(rs.getString("tacSupra"));
				dadosHolter.add(rs.getString("obsExame"));
			}
			return dadosHolter;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	
	public void updateHolter24(Holter24 holter, String idHolter) {
		String sql = "update holter24  set paciente = ?, idade = ?, profissional = ?, horarioExame = ?, dataExame = ?,"
				+ "idAgendamento = ?,freqMax = ?, freqMed = ?, freqMin = ?, totBat = ?, varRR = ?, extraVentr = ?,"
				+ "extraVentrPar = ?, tacVentr = ?, extraSupra = ?, tacSupra = ?, obsExame = ? where idExame = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, holter.getPaciente());
			pst.setString(2, holter.getIdade());
			pst.setString(3, holter.getProfissional());
			pst.setString(4, holter.getHorarioExame());
			pst.setString(5, holter.getDataExame());
			pst.setString(6, holter.getIdAgendamento());
			pst.setString(7, holter.getFreqMax());
			pst.setString(8, holter.getFreqMed());
			pst.setString(9, holter.getFreqMin());
			pst.setString(10, holter.getTotBat());
			pst.setString(11, holter.getVarRR());
			pst.setString(12, holter.getExtraVentr());
			pst.setString(13, holter.getExtraVentrPar());
			pst.setString(14, holter.getTacVentri());
			pst.setString(15, holter.getExtraSupra());
			pst.setString(16, holter.getTacSupra());
			pst.setString(17, holter.getObsExame());
			pst.setString(18, idHolter);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Exame atualizado com com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void deleteHolter24(String idHolter) {
		String sql = "delete from holter24 where idExame = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, idHolter);
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Exame atualizado com com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
}
