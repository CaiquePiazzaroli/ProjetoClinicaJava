package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class TelaCadastroEcocardiograma extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEcocardiograma frame = new TelaCadastroEcocardiograma();
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
	public TelaCadastroEcocardiograma() {
		setFrameIcon(new ImageIcon(TelaCadastroEcocardiograma.class.getResource("/icones/coracao25.png")));
		setMaximizable(true);
		getContentPane().setBackground(new Color(227, 227, 227));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(10, 591, 151, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Paciente");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 11, 65, 19);
		getContentPane().add(lblNewLabel_2);
		
		JComboBox cboNomePaciente = new JComboBox();
		cboNomePaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		cboNomePaciente.setBounds(76, 11, 212, 19);
		getContentPane().add(cboNomePaciente);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Horario Exame");
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 41, 114, 19);
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(123, 41, 86, 19);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Data do exame");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(219, 41, 114, 19);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(331, 43, 86, 19);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Idade");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(311, 11, 51, 19);
		getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(360, 13, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Profissional Responsável");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(456, 11, 182, 19);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Id Agendamento");
		lblNewLabel_2_1_1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_2.setBounds(427, 41, 137, 19);
		getContentPane().add(lblNewLabel_2_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(549, 43, 86, 19);
		getContentPane().add(textField_3);
		
		JComboBox cboProfissionalResponsavel = new JComboBox();
		cboProfissionalResponsavel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		cboProfissionalResponsavel.setBounds(636, 11, 225, 19);
		getContentPane().add(cboProfissionalResponsavel);
		
		JTextPane txtObsExame = new JTextPane();
		txtObsExame.setBounds(10, 121, 912, 396);
		getContentPane().add(txtObsExame);
		
		JLabel lblNewLabel_3 = new JLabel("Interpretação dos dados eletrocardiograma:");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 94, 389, 23);
		getContentPane().add(lblNewLabel_3);
		setTitle("Cadastro Eletrocardiograma");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 948, 669);
		
		
		
		
		
	}

}
