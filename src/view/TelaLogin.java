package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.dao.UsuarioDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modelo.dao.Conexao;
import controller.TelaLoginController;

//importando todos os recursos do jdbc
import java.sql.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import view.*;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuário;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/icones/coracao25.png")));
		setTitle("AMAR - Sistemas Médicos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuário = new JLabel("Usuário");
		lblUsuário.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuário.setBounds(74, 125, 68, 32);
		contentPane.add(lblUsuário);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(139, 131, 200, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(74, 162, 68, 32);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 168, 200, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login ");
		//Evento ao clicar sobre o botao login
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}	
		});
		btnNewButton.setBounds(173, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/CoracaoX80Desc.png")));
		lblNewLabel.setBounds(139, 25, 169, 75);
		contentPane.add(lblNewLabel);
	}
	
	public void login() {

		//Array para armazenar os dados do usuário 
		ArrayList<String> dadosUsuario = new ArrayList<String>();
		
		//Instanciando o objeto controller
		TelaLoginController telaLoginController = new TelaLoginController();
		
		//Recebendo os dados do usuário pela função loginController
		dadosUsuario = telaLoginController.loginController(TelaLogin.this);
		
		//Verficando o status do usuário, admin, user ou usuário nao encontrado
		if(dadosUsuario !=  null) {	
			if(dadosUsuario.get(2).toString().equals("admin")) {
				//Criando a tela principal
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);	
				
				//Inserindo o nome do usuario na tela inicial
				telaPrincipal.getLblUsuario().setText("Olá, " + dadosUsuario.get(0));
				telaPrincipal.getLblUsuario().setForeground(Color.red);
				
				
				//Fechando a tela de login
				this.dispose();
				
			} else {
				//Criando a tela principal
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);	
				
				//Inserindo o nome do usuario na tela inicial
				telaPrincipal.getLblUsuario().setText("Olá, " + dadosUsuario.get(0));
				
				//Fechando a tela de login
				this.dispose();
			}	
		} else {
			JOptionPane.showMessageDialog(null, "Usuário ou/e senha incorretos");
		}
		
	}


	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
	
}
