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

public class TelaCadastroEletrocardiograma extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEletrocardiograma frame = new TelaCadastroEletrocardiograma();
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
	public TelaCadastroEletrocardiograma() {
		setFrameIcon(new ImageIcon(TelaCadastroEletrocardiograma.class.getResource("/icones/coracao25.png")));
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 83, 912, 176);
		getContentPane().add(panel);
		
		JLabel lblMassaVentriculoEsquerdo = new JLabel("Massa Ventriculo Esquerdo ( VE)");
		lblMassaVentriculoEsquerdo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblMassaVentriculoEsquerdo.setBounds(10, 135, 228, 19);
		panel.add(lblMassaVentriculoEsquerdo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(248, 137, 65, 20);
		panel.add(textField_4);
		
		JLabel lblEspDiast = new JLabel("Esp. Diast. (PPVE)");
		lblEspDiast.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblEspDiast.setBounds(10, 105, 127, 19);
		panel.add(lblEspDiast);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(137, 104, 65, 20);
		panel.add(textField_5);
		
		JLabel lblDiametroDiastlicoFinal = new JLabel("Diametro diastólico final do V.E");
		lblDiametroDiastlicoFinal.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblDiametroDiastlicoFinal.setBounds(10, 11, 244, 19);
		panel.add(lblDiametroDiastlicoFinal);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(261, 11, 65, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(248, 39, 65, 20);
		panel.add(textField_7);
		
		JLabel lblEspessuraDiastlicaDo = new JLabel("Espessura diastólica do septo");
		lblEspessuraDiastlicaDo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblEspessuraDiastlicaDo.setBounds(10, 74, 210, 19);
		panel.add(lblEspessuraDiastlicaDo);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(226, 74, 65, 20);
		panel.add(textField_8);
		
		JLabel lblDiametroTelessisticoDo = new JLabel("Diametro Telessistóico do atrio esq");
		lblDiametroTelessisticoDo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblDiametroTelessisticoDo.setBounds(425, 37, 261, 19);
		panel.add(lblDiametroTelessisticoDo);
		
		JLabel lblDiametroSistlicoVe = new JLabel("Diametro sistólico V.E");
		lblDiametroSistlicoVe.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblDiametroSistlicoVe.setBounds(425, 11, 194, 19);
		panel.add(lblDiametroSistlicoVe);
		
		JLabel lblDiametroAorta = new JLabel("Diametro Aorta");
		lblDiametroAorta.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblDiametroAorta.setBounds(425, 67, 170, 19);
		panel.add(lblDiametroAorta);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(685, 13, 86, 20);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(685, 39, 86, 20);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(685, 67, 86, 20);
		panel.add(textField_11);
		
		JLabel lblDiametroSistlicoFinal = new JLabel("Diametro sistólico final do V.E");
		lblDiametroSistlicoFinal.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblDiametroSistlicoFinal.setBounds(8, 42, 225, 19);
		panel.add(lblDiametroSistlicoFinal);
		
		JTextPane txtObsExame = new JTextPane();
		txtObsExame.setBounds(10, 295, 912, 222);
		getContentPane().add(txtObsExame);
		
		JLabel lblNewLabel_3 = new JLabel("Observações sobre o exame");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 270, 225, 14);
		getContentPane().add(lblNewLabel_3);
		setTitle("Cadastro Ecocardiograma");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 948, 669);
		
		
		
		
		
	}

}
