package controller;

import view.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.*;

public class TelaLoginController {
		
	public ArrayList<String> loginController(TelaLogin telaLogin){
		TelaLoginDao telaLoginDao = new TelaLoginDao();
		String usuario = telaLogin.getTextFieldUsuario().getText();
		//Recebendo a senha do formulário 
		String senha = new String(telaLogin.getPasswordField().getPassword());
		return telaLoginDao.loginDao(usuario, senha);
		
	}
}
