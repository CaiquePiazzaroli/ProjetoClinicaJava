package view;

import java.awt.Cursor;
import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import modelo.entidade.Paciente;
import net.proteanit.sql.DbUtils;
import controller.PacienteController;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;
import java.util.Date;
import javax.swing.DropMode;
import java.time.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;


public class TelaCadastroPaciente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNomePaciente;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtCelular;
	private JTextField txtConvenio;
	private JFormattedTextField txtRG;
	private JFormattedTextField txtTelefone;
	private JComboBox cboSexo;
	private Paciente paciente;
	private MaskFormatter formatadorData; //Variavel do para formatar data no formulario
	private MaskFormatter formatadorCel;//Variavel do para formatar celular no formulario
	private MaskFormatter formatadorTelefone; //Variavel do para formatar telefone no formulario
	private MaskFormatter formatadorRg; //Variavel do para formatar telefone no rg
	
	private JFormattedTextField txtDataNascimento;
	private JTable table;
	private JTable tbPacientes;
	private JTextField txtPacPesquisar;
	private JTextField txtIdPaciente;
	private JLabel lblNewLabel_9;
	private JButton btnCadastrarPaciente;
	private JButton btnExcluirPaciente;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	


	//Construtor da tela de cadastro de pacientes 
	//throws ParseException é necessário para trabalhar com o MaskFormater
	public TelaCadastroPaciente() throws ParseException {
		setTitle("Cadastro Pacientes");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 740, 612);
		getContentPane().setLayout(null);
		
		
		//Labels do form
		JLabel lblNewLabel = new JLabel("Nome do Paciente*");
		lblNewLabel.setBounds(23, 321, 110, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento*");
		lblNewLabel_1.setBounds(23, 421, 110, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RG*");
		lblNewLabel_2.setBounds(91, 369, 42, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Altura");
		lblNewLabel_3.setBounds(78, 470, 34, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Peso");
		lblNewLabel_4.setBounds(469, 418, 57, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo*");
		lblNewLabel_5.setBounds(259, 421, 35, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone");
		lblNewLabel_6.setBounds(259, 366, 57, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Celular");
		lblNewLabel_7.setBounds(469, 369, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Convenio*");
		lblNewLabel_8.setBounds(259, 470, 62, 14);
		getContentPane().add(lblNewLabel_8);
		
		
		//Campos de texto do form
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setBounds(130, 318, 569, 20);
		getContentPane().add(txtNomePaciente);
		txtNomePaciente.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(130, 467, 96, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		
		txtPeso = new JTextField();
		txtPeso.setBounds(525, 418, 174, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		
		formatadorData = new MaskFormatter("##/##/####"); //Cria um padrao para o campo data e atribui apenas numeros para serem digitados
		formatadorData.setValidCharacters("0123456789");
		txtDataNascimento = new JFormattedTextField(formatadorData);
		txtDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataNascimento.setBounds(130, 418, 110, 20);
		getContentPane().add(txtDataNascimento);
				
				
		formatadorRg = new MaskFormatter("#########");
		formatadorRg.setValidCharacters("0123456789");	
		txtRG = new JFormattedTextField(formatadorRg);
		txtRG.setHorizontalAlignment(SwingConstants.CENTER);
		txtRG.setBounds(130, 366, 110, 20);
		getContentPane().add(txtRG);
						
		formatadorTelefone = new MaskFormatter("########");
		formatadorTelefone.setValidCharacters("0123456789");
		txtTelefone = new JFormattedTextField(formatadorTelefone);
		txtTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefone.setBounds(312, 366, 135, 20);
		getContentPane().add(txtTelefone);
	
		formatadorCel = new MaskFormatter("(##)#####-####");
		formatadorCel.setValidCharacters("0123456789");
		txtCelular = new JFormattedTextField(formatadorCel);
		txtCelular.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelular.setBounds(525, 363, 174, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(312, 467, 135, 20);
		getContentPane().add(txtConvenio);
		txtConvenio.setColumns(10);
		
		
		txtPacPesquisar = new JTextField();
		txtPacPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//A linha abaixo chama o método pesquisar toda vez que o usuário altera o formulário de paciente
				pesquisarPaciente();
			}
		});
		txtPacPesquisar.setBounds(23, 27, 318, 20);
		getContentPane().add(txtPacPesquisar);
		txtPacPesquisar.setColumns(10);
		
		
		
		JLabel lblIdPaciente = new JLabel("Id Paciente");
		lblIdPaciente.setBounds(23, 284, 89, 14);
		getContentPane().add(lblIdPaciente);
		
		txtIdPaciente = new JTextField();
		txtIdPaciente.setEnabled(false);
		txtIdPaciente.setBounds(130, 281, 86, 20);
		getContentPane().add(txtIdPaciente);
		txtIdPaciente.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Campos Obrigatórios*");
		lblNewLabel_9.setBounds(493, 284, 149, 14);
		getContentPane().add(lblNewLabel_9);
		
		
		//Combo box do form
		cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino", "Outros"}));
		cboSexo.setBounds(312, 417, 135, 22);
		getContentPane().add(cboSexo);
		
		
		
		//Botoes do form
		btnCadastrarPaciente = new JButton("Cadastrar");
		btnCadastrarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPaciente();
			}
		});
		btnCadastrarPaciente.setBounds(23, 536, 110, 23);
		getContentPane().add(btnCadastrarPaciente);
		
		
		//Scroll Pane para conter a tabela
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 62, 676, 198);
		getContentPane().add(scrollPane);
		
		
		//Tabela
		tbPacientes = new JTable();
		tbPacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		tbPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbPacientes.setModel(
			new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		)
		);
		scrollPane.setViewportView(tbPacientes);	
		
		JButton btnAtualizarPaciente = new JButton("Atualizar");
		btnAtualizarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando a função atualizar cliente para o botao atualizar no form
				atualizarPaciente();
			}
		});
		btnAtualizarPaciente.setBounds(315, 536, 110, 23);
		getContentPane().add(btnAtualizarPaciente);
		
		btnExcluirPaciente = new JButton("Excluir");
		btnExcluirPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o método excluir paciente
				excluirPaciente();
			}
		});
		btnExcluirPaciente.setBounds(595, 536, 104, 23);
		getContentPane().add(btnExcluirPaciente);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/icones/procurar.png")));
		lblNewLabel_10.setBounds(344, 27, 24, 20);
		getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Pesquisar Pacientes:");
		lblNewLabel_11.setBounds(23, 11, 111, 14);
		getContentPane().add(lblNewLabel_11);
		
		
	}
	
	
	
	
	//A função abaixo pega os dados string no campo de data e os converte para o formatação do banco de dados MYSQL
	// pega a data no formato ex: 03/02/1988 -> 1988-02-03
	private String dataNascFormatada(String data, boolean recebeBanco){
		
		if(recebeBanco) {
			//Divide a data pelo caractere - e os insere em uma lista
			String[] datas = data.split("-");
			//Pega cada valor (ano, mes e dia) da lista e os coloca na ordem para o mysql
			String dia = datas[2];
			String mes = datas[1];
			String ano = datas[0];
			//Retorna uma string com os dados formatados 
			return dia + "/" + mes + "/" + ano;
		} else {
			//Divide a data pelo caractere / e os insere em uma lista
			String[] datas = data.split("/");
			//Pega cada valor (dia, mes e ano) da lista e os coloca na ordem para o mysql
			String dia = datas[0];
			String mes = datas[1];
			String ano = datas[2];

			
			//Retorna uma string com os dados formatados 
			return ano + "-" + mes + "-" + dia;
		}	
	}
	
	//O método abaixo limpa os campos do formulário
	private void limparCampos() {
		txtNomePaciente.setText(null);
		txtRG.setText(null);
		txtTelefone.setText(null);
		txtCelular.setText(null);
		txtDataNascimento.setText(null);
		txtPeso.setText(null);
		txtAltura.setText(null);
		txtConvenio.setText(null);
		txtIdPaciente.setText(null);
	}
	
	
	private void cadastrarPaciente() {
		
		//Cria um novo objeto paciente com os dados do formulário
		this.paciente = new Paciente(
				txtNomePaciente.getText(), txtRG.getText(), txtTelefone.getText(), txtCelular.getText(), 
				dataNascFormatada(txtDataNascimento.getText(), false), cboSexo.getSelectedItem().toString(), txtPeso.getText(), txtAltura.getText(), txtConvenio.getText()
		);
		
		//cria um controller de pacientes que recebe o objeto paciente
		PacienteController pacienteController = new PacienteController();
		String resultadoPacienteController = pacienteController.salvaPaciente(TelaCadastroPaciente.this);
		if(resultadoPacienteController.equals("sucesso")) {
			JOptionPane.showMessageDialog(null, "Usário adicionado com sucesso!");
			limparCampos();
			pesquisarPaciente();
		} else if(resultadoPacienteController.equals("camposVazios")) {
			JOptionPane.showMessageDialog(null, "Os campos obrigatórios não podem estar em branco");
		} else if (resultadoPacienteController.equals("usuarioInvalido")) {
			JOptionPane.showMessageDialog(null, "Usário Inválido!");
		}
	}
	
	
	private void pesquisarPaciente() {
		//Criando o controller de paciente 
		PacienteController pacienteController = new PacienteController();
		
		//Chamando o método de pesquisar pacientes
		ResultSet rs = pacienteController.pesquisaPacientes(TelaCadastroPaciente.this);
		
		// a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
		tbPacientes.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	//O método abaixo pega os dados das linhas das tabelas e as insere nos campos do form 
	public void setarCampos() {
		
		//Pega a linha que está selecionada
		int setar = tbPacientes.getSelectedRow();
		txtIdPaciente.setText(tbPacientes.getModel().getValueAt(setar, 0).toString());
		txtNomePaciente.setText(tbPacientes.getModel().getValueAt(setar, 1).toString());
		//"DESFORMATANDO" a data do banco para o estilo formatado, o true indica que a formatação será inversa ao banco de dados
		String dataFormatada = dataNascFormatada(tbPacientes.getModel().getValueAt(setar, 2).toString(), true);
		txtDataNascimento.setText(dataFormatada.toString());
		txtRG.setText(tbPacientes.getModel().getValueAt(setar, 3).toString());
		txtAltura.setText(tbPacientes.getModel().getValueAt(setar, 4).toString());
		txtPeso.setText(tbPacientes.getModel().getValueAt(setar, 5).toString());
		if(tbPacientes.getModel().getValueAt(setar, 6).toString().equals("Feminino")) {
			cboSexo.setSelectedIndex(0);
		} else if(tbPacientes.getModel().getValueAt(setar, 6).toString().equals("Masculino")) {
			cboSexo.setSelectedIndex(1);
		} else {
			cboSexo.setSelectedIndex(2);
		}
		txtTelefone.setText(tbPacientes.getModel().getValueAt(setar, 7).toString());
		txtCelular.setText(tbPacientes.getModel().getValueAt(setar, 8).toString());
		txtConvenio.setText(tbPacientes.getModel().getValueAt(setar, 9).toString());
		btnCadastrarPaciente.setEnabled(false);
		
	}
	
	//O método abaixo atualizar o paciente  no banco de dados
	public void atualizarPaciente() {
			this.paciente = new Paciente(
					txtNomePaciente.getText(), 
					txtRG.getText(), 
					txtTelefone.getText(), 
					txtCelular.getText(), 
					dataNascFormatada(txtDataNascimento.getText(), false), 
					cboSexo.getSelectedItem().toString(), 
					txtPeso.getText(), txtAltura.getText(), 
					txtConvenio.getText()
			);
			
		
			//cria um controller de pacientes que recebe o objeto paciente
			PacienteController pacienteController = new PacienteController();
			String resultadoPacienteController = pacienteController.altualizaPaciente(TelaCadastroPaciente.this);
			if(resultadoPacienteController.equals("sucesso")) {
				JOptionPane.showMessageDialog(null, "Usário Alterado com sucesso!");
				limparCampos();
				btnCadastrarPaciente.setEnabled(true);
				pesquisarPaciente();
			} else if(resultadoPacienteController.equals("camposVazios")) {
				JOptionPane.showMessageDialog(null, "Os campos obrigatórios não podem estar em branco");
			} else if (resultadoPacienteController.equals("usuarioInvalido")) {
				JOptionPane.showMessageDialog(null, "Usuário Inválido!");
			}		
	}

	//O método abaixo exclui o paciente
	public void excluirPaciente() {
		this.paciente = new Paciente(
				txtNomePaciente.getText(), 
				txtRG.getText(), 
				txtTelefone.getText(), 
				txtCelular.getText(), 
				dataNascFormatada(txtDataNascimento.getText(), false), 
				cboSexo.getSelectedItem().toString(), 
				txtPeso.getText(), txtAltura.getText(), 
				txtConvenio.getText()
		);
		
		PacienteController pacienteController = new PacienteController();
		String resultadoPacienteController = pacienteController.excluiPaciente(TelaCadastroPaciente.this);
		if(resultadoPacienteController.equals("sucesso")) {
			JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
			limparCampos();
			btnCadastrarPaciente.setEnabled(true);
			pesquisarPaciente();
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário");
		}
	}
		
	public JTextField getTxtIdPaciente() {
		return txtIdPaciente;
	}


	public void setTxtIdPaciente(JTextField txtIdPaciente) {
		this.txtIdPaciente = txtIdPaciente;
	}


	public JTable getTbPacientes() {
		return tbPacientes;
	}

	public void setTbPacientes(JTable tbPacientes) {
		this.tbPacientes = tbPacientes;
	}
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public JTextField getTxtPacPesquisar() {
		return txtPacPesquisar;
	}

	public void setTxtPacPesquisar(JTextField txtPacPesquisar) {
		this.txtPacPesquisar = txtPacPesquisar;
	}
}
