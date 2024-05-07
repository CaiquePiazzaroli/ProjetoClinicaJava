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
import java.awt.event.ActionEvent;
import modelo.entidade.Paciente;
import controller.PacienteController;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;
import java.util.Date;
import javax.swing.DropMode;

public class TelaCadastroPaciente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNomePaciente;
	private JTextField txtDataNascimento;
	private JTextField txtRG;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtConvenio;
	private JComboBox cboSexo;
	private Paciente paciente;


	//Construtor da tela de cadastro de pacientes
	public TelaCadastroPaciente() {
		setTitle("Cadastro Pacientes");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 740, 612);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Paciente");
		lblNewLabel.setBounds(23, 44, 110, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1.setBounds(23, 140, 110, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setBounds(130, 41, 552, 20);
		getContentPane().add(txtNomePaciente);
		txtNomePaciente.setColumns(10);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(130, 137, 110, 20);
		getContentPane().add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("RG");
		lblNewLabel_2.setBounds(91, 97, 42, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtRG = new JTextField();
		txtRG.setBounds(130, 94, 110, 20);
		getContentPane().add(txtRG);
		txtRG.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Altura");
		lblNewLabel_3.setBounds(78, 188, 34, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(130, 185, 96, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Peso");
		lblNewLabel_4.setBounds(469, 137, 57, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(525, 137, 157, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		lblNewLabel_5.setBounds(259, 140, 35, 14);
		getContentPane().add(lblNewLabel_5);
		
		cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino", "Outros"}));
		cboSexo.setBounds(312, 136, 135, 22);
		getContentPane().add(cboSexo);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone");
		lblNewLabel_6.setBounds(259, 94, 57, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(312, 91, 135, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Celular");
		lblNewLabel_7.setBounds(469, 97, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(525, 91, 157, 20);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Convenio");
		lblNewLabel_8.setBounds(259, 188, 62, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(312, 185, 135, 20);
		getContentPane().add(txtConvenio);
		txtConvenio.setColumns(10);
		
		JButton btnCadastrarPaciente = new JButton("Cadastrar");
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPaciente();
			}
		});
		btnCadastrarPaciente.setBounds(23, 536, 89, 23);
		getContentPane().add(btnCadastrarPaciente);
	}
	
	
	private void cadastrarPaciente() {
		//Cria um novo objeto paciente com os dados do formulário
		
		this.paciente = new Paciente(txtNomePaciente.getText(), txtRG.getText(), txtTelefone.getText(), txtCelular.getText(), txtDataNascimento.getText(), cboSexo.getSelectedItem().toString(), txtPeso.getText(), txtAltura.getText(), txtConvenio.getText());
		
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
