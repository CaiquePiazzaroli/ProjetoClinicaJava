package view;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import modelo.entidade.Paciente;
import controller.PacienteController;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;
import java.util.Date;
import javax.swing.DropMode;
import java.time.*;


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
		JLabel lblNewLabel = new JLabel("Nome do Paciente");
		lblNewLabel.setBounds(23, 44, 110, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(23, 140, 110, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		lblNewLabel_2.setBounds(91, 97, 42, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Altura");
		lblNewLabel_3.setBounds(78, 188, 34, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Peso");
		lblNewLabel_4.setBounds(469, 137, 57, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setBounds(259, 140, 35, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone");
		lblNewLabel_6.setBounds(259, 94, 57, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Celular");
		lblNewLabel_7.setBounds(469, 97, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Convenio");
		lblNewLabel_8.setBounds(259, 188, 62, 14);
		getContentPane().add(lblNewLabel_8);
		
		
		//Campos de texto do form
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setBounds(130, 41, 552, 20);
		getContentPane().add(txtNomePaciente);
		txtNomePaciente.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(130, 185, 96, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		
		txtPeso = new JTextField();
		txtPeso.setBounds(525, 137, 157, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		
		//Cria um padrao para o campo data e atribui apenas numeros para serem digitados
		formatadorData = new MaskFormatter("##/##/####");
		formatadorData.setValidCharacters("0123456789");
		txtDataNascimento = new JFormattedTextField(formatadorData);
		txtDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataNascimento.setBounds(130, 137, 110, 20);
		getContentPane().add(txtDataNascimento);
				
				
		formatadorRg = new MaskFormatter("#########");
		formatadorRg.setValidCharacters("0123456789");	
		txtRG = new JFormattedTextField(formatadorRg);
		txtRG.setHorizontalAlignment(SwingConstants.CENTER);
		txtRG.setBounds(130, 94, 110, 20);
		getContentPane().add(txtRG);
						
		formatadorTelefone = new MaskFormatter("########");
		formatadorTelefone.setValidCharacters("0123456789");
		txtTelefone = new JFormattedTextField(formatadorTelefone);
		txtTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefone.setBounds(312, 94, 135, 20);
		getContentPane().add(txtTelefone);
	
		formatadorCel = new MaskFormatter("(##)#####-####");
		formatadorCel.setValidCharacters("0123456789");
		txtCelular = new JFormattedTextField(formatadorCel);
		txtCelular.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelular.setBounds(525, 91, 157, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(312, 185, 135, 20);
		getContentPane().add(txtConvenio);
		txtConvenio.setColumns(10);
		
		
		//Combo box do form
		cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino", "Outros"}));
		cboSexo.setBounds(312, 136, 135, 22);
		getContentPane().add(cboSexo);
		
		
		
		//Botoes do form
		JButton btnCadastrarPaciente = new JButton("Cadastrar");
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPaciente();
			}
		});
		btnCadastrarPaciente.setBounds(23, 536, 89, 23);
		getContentPane().add(btnCadastrarPaciente);
	}
	
	//A função abaixo pega os dados string no campo de data e os converte para o formatação do banco de dados MYSQL
	// pega a data no formato ex: 03/02/1988 -> 1988-02-03
	private String dataNascFormatada(String data){
		
		//Divide a data pelo caractere / e os insere em uma lista
		String[] datas = data.split("/");
		
		//Pega cada valor (dia, mes e ano) da lista e os coloca na ordem para o mysql
		String dia = datas[0];
		String mes = datas[1];
		String ano = datas[2];

		
		//Retorna uma string com os dados formatados 
		return ano + "-" + mes + "-" + dia;
	}
	
	
	private void cadastrarPaciente() {
		//Cria um novo objeto paciente com os dados do formulário
		this.paciente = new Paciente(
				txtNomePaciente.getText(), txtRG.getText(), txtTelefone.getText(), txtCelular.getText(), 
				dataNascFormatada(txtDataNascimento.getText()), cboSexo.getSelectedItem().toString(), txtPeso.getText(), txtAltura.getText(), txtConvenio.getText()
		);
		
		//cria um controller de pacientes que recebe o objeto paciente
		PacienteController pacienteController = new PacienteController();
		String resultadoPacienteController = pacienteController.salvaPaciente(TelaCadastroPaciente.this);
		if(resultadoPacienteController.equals("sucesso")) {
			JOptionPane.showMessageDialog(null, "Usário adicionado com sucesso!");
			txtNomePaciente.setText(null);
			txtRG.setText(null);
			txtTelefone.setText(null);
			txtCelular.setText(null);
			txtDataNascimento.setText(null);
			txtPeso.setText(null);
			txtAltura.setText(null);
			txtConvenio.setText(null);
		} else if(resultadoPacienteController.equals("camposVazios")) {
			JOptionPane.showMessageDialog(null, "Os campos obrigatórios não podem estar em branco");
		} else if (resultadoPacienteController.equals("usuarioInvalido")) {
			JOptionPane.showMessageDialog(null, "Usário Inválido!");
		}
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
