package modelo.entidade;

import modelo.dao.Conexao;
import view.TelaLogin;

public class Principal {

	public static void main(String[] args) {
		Conexao conn = new Conexao();
		TelaLogin telaLogin = new TelaLogin();
		telaLogin.setVisible(true);
	}
}
