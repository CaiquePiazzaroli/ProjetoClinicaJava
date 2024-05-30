package view;

import java.awt.Color;
import java.awt.Cursor;
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
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.UIManager;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuário;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	// função main para executar a tela login
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
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

	//Construtor tela login
	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/icones/coracao25.png")));
		setTitle("Clinic Soft Sistemas Médicos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 491);
		
		//Retira abarra superior
		//setUndecorated(true);
	
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(227, 227, 227));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuário = new JLabel("");
		lblUsuário.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/Usuário.png")));
		lblUsuário.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuário.setBounds(144, 172, 81, 20);
		contentPane.add(lblUsuário);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		textFieldUsuario.setBounds(144, 203, 316, 34);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/Senha.png")));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(144, 250, 68, 32);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		passwordField.setBounds(144, 277, 316, 34);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login ");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/btnLoginHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/btnLogin.png")));
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/btnLogin.png")));
		btnNewButton.setBackground(new Color(115, 188, 255));
		//Evento ao clicar sobre o botao login
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}	
		});
		btnNewButton.setBounds(178, 362, 249, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/Clinic Soft.png")));
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 17));
		lblNewLabel.setBounds(178, 69, 249, 41);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/icones/Bem vindo ao Clinic Soft.png")));
		lblNewLabel_1.setBounds(155, 121, 305, 29);
		contentPane.add(lblNewLabel_1);
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
				//telaPrincipal.getLblUsuario().setForeground(Color.red);
				
				
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
