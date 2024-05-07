package modelo.dao;

import view.*;
import java.sql.*;
import java.util.ArrayList;

import modelo.dao.*;
import controller.TelaLoginController;


public class TelaLoginDao {
	//Preparando a conexao com o banco, a query e o resultado
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	
	
	public ArrayList<String> loginDao(String usuario, String senha) {
		//Crio a conexao com o banco
		conexao = Conexao.conector();
		//Crio a query
		String sql = "Select * from usuarios where login=? and senha=?";
		ArrayList<String> dadosUsuarioLogin;
		
		try {
			pst = conexao.prepareStatement(sql);
			//Recebendo o usuário do formulário
			pst.setString(1, usuario);
			pst.setString(2, senha);
			
			//Executando a query
			rs = pst.executeQuery();
			
			if(rs.next()) {
				dadosUsuarioLogin = new ArrayList<String>();
				dadosUsuarioLogin.add(rs.getString(2)); //nome
				dadosUsuarioLogin.add(rs.getString(3)); //login
				dadosUsuarioLogin.add(rs.getString(5)); //nivel de permissão
				conexao.close();
				return dadosUsuarioLogin;
			} else {
				conexao.close();
				return null;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
	}
	
}
