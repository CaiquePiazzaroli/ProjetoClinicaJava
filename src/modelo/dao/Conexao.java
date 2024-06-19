package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	//Criando uma variavel do tipo Connection
	java.sql.Connection conexao = null;
	
	//Construtor conexao
	public static Connection conector() {
		java.sql.Connection conexao = null; //criando uma variavel do tipo Connection
		
		//Caminho do driver
		String driver = "com.mysql.cj.jdbc.Driver";
				
		//Dados da base de dados
		String url = "jdbc:mysql://localhost:3306/clinica";
		String user = "root";
		String password="010203";
		
		//Estabelecendo a conexao com o banco de dados
		try {
			//Chamando o driver pelo nome
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,user,password);
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}	
}
