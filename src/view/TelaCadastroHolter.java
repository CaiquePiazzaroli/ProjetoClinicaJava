package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import controller.Holter24Controller;
import modelo.entidade.Holter24;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaCadastroHolter extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtFreqMin;
	private JTextField txtFreqMed;
	private JTextField txtFreqMax;
	private JTextField txtBat;
	private JTextField txtVarRR;
	private JTable table;
	private JTextField txtDataExame;
	private JTextField txtHorarioExame;
	private JTextField txtIdade;
	private JTextField txtExtraVentr;
	private JTextField txtExtraVentrPar;
	private JTextField txttacVentr;
	private JTextField txtExtraSupra;
	private JTextField txtTacSupra;
	private JTextField txtIdAgendamento;
	private JComboBox cboProfissionalResponsavel;
	private JComboBox cboNomePaciente;
	private JTextPane txtObsExame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroHolter frame = new TelaCadastroHolter();
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
	public TelaCadastroHolter() {
		setFrameIcon(new ImageIcon(TelaCadastroHolter.class.getResource("/icones/coracao25.png")));
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				
			}
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				selectPacientesProfissionais();
			}
		});
		setMaximizable(true);
		getContentPane().setBackground(new Color(227, 227, 227));
		setTitle("Cadastro Holter 24");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 948, 669);
		
		JLabel lblNewLabel_2 = new JLabel("Paciente");
		lblNewLabel_2.setBounds(10, 25, 65, 19);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel_2);
		
		table = new JTable();
		table.setBounds(185, 116, 1, 1);
		getContentPane().add(table);
		
		cboNomePaciente = new JComboBox();
		cboNomePaciente.setModel(new DefaultComboBoxModel(new String[] {"Teste"}));
		cboNomePaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		cboNomePaciente.setBounds(76, 25, 212, 19);
		getContentPane().add(cboNomePaciente);
		
		JLabel lblNewLabel_2_1 = new JLabel("Profissional Responsável");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(456, 25, 182, 19);
		getContentPane().add(lblNewLabel_2_1);
		
		cboProfissionalResponsavel = new JComboBox();
		cboProfissionalResponsavel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		cboProfissionalResponsavel.setBounds(636, 25, 225, 19);
		getContentPane().add(cboProfissionalResponsavel);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Data do exame");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(219, 55, 114, 19);
		getContentPane().add(lblNewLabel_2_1_1);
		
		txtDataExame = new JTextField();
		txtDataExame.setBounds(331, 57, 86, 19);
		getContentPane().add(txtDataExame);
		txtDataExame.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Horario Exame");
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 55, 114, 19);
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		txtHorarioExame = new JTextField();
		txtHorarioExame.setColumns(10);
		txtHorarioExame.setBounds(123, 55, 86, 19);
		getContentPane().add(txtHorarioExame);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 97, 912, 176);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVariabilidadeRr = new JLabel("Variabilidade RR");
		lblVariabilidadeRr.setBounds(10, 135, 127, 19);
		panel.add(lblVariabilidadeRr);
		lblVariabilidadeRr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtVarRR = new JTextField();
		txtVarRR.setBounds(137, 137, 65, 20);
		panel.add(txtVarRR);
		txtVarRR.setColumns(10);
		
		JLabel lblTotalBatimentos = new JLabel("Total Batimentos");
		lblTotalBatimentos.setBounds(10, 105, 127, 19);
		panel.add(lblTotalBatimentos);
		lblTotalBatimentos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtBat = new JTextField();
		txtBat.setBounds(137, 104, 65, 20);
		panel.add(txtBat);
		txtBat.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("bpm");
		lblNewLabel_1_1_1.setBounds(227, 16, 30, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblFrequenciaMxima = new JLabel("Frequencia Máxima");
		lblFrequenciaMxima.setBounds(10, 11, 140, 19);
		panel.add(lblFrequenciaMxima);
		lblFrequenciaMxima.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtFreqMax = new JTextField();
		txtFreqMax.setBounds(152, 13, 65, 20);
		panel.add(txtFreqMax);
		txtFreqMax.setColumns(10);
		
		JLabel lblFrequenciaMdia = new JLabel("Frequencia Média");
		lblFrequenciaMdia.setBounds(10, 41, 140, 19);
		panel.add(lblFrequenciaMdia);
		lblFrequenciaMdia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtFreqMed = new JTextField();
		txtFreqMed.setBounds(137, 41, 65, 20);
		panel.add(txtFreqMed);
		txtFreqMed.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("bpm");
		lblNewLabel_1_1.setBounds(207, 46, 30, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Frequencia Mínima");
		lblNewLabel.setBounds(10, 74, 140, 19);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtFreqMin = new JTextField();
		txtFreqMin.setBounds(147, 76, 65, 20);
		panel.add(txtFreqMin);
		txtFreqMin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("bpm");
		lblNewLabel_1.setBounds(217, 79, 30, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblExtrassstolesVentricularesPareadas = new JLabel("Extrassístoles Ventriculares Pareadas");
		lblExtrassstolesVentricularesPareadas.setBounds(358, 41, 261, 19);
		panel.add(lblExtrassstolesVentricularesPareadas);
		lblExtrassstolesVentricularesPareadas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		JLabel lblExtrassstoles = new JLabel("Extrassístoles Ventriculares");
		lblExtrassstoles.setBounds(358, 11, 194, 19);
		panel.add(lblExtrassstoles);
		lblExtrassstoles.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		JLabel lblTac = new JLabel("Taquicardia Ventricular");
		lblTac.setBounds(358, 74, 170, 19);
		panel.add(lblTac);
		lblTac.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		JLabel lblExtrassstolesSupraVentriculares = new JLabel("Extrassístoles Supraventriculares");
		lblExtrassstolesSupraVentriculares.setBounds(358, 105, 261, 19);
		panel.add(lblExtrassstolesSupraVentriculares);
		lblExtrassstolesSupraVentriculares.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		JLabel lblTaquicardiaSupraventricular = new JLabel("Taquicardia Supraventricular");
		lblTaquicardiaSupraventricular.setBounds(358, 135, 210, 19);
		panel.add(lblTaquicardiaSupraventricular);
		lblTaquicardiaSupraventricular.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtExtraVentr = new JTextField();
		txtExtraVentr.setBounds(551, 11, 86, 20);
		panel.add(txtExtraVentr);
		txtExtraVentr.setColumns(10);
		
		txtExtraVentrPar = new JTextField();
		txtExtraVentrPar.setColumns(10);
		txtExtraVentrPar.setBounds(623, 41, 86, 20);
		panel.add(txtExtraVentrPar);
		
		txttacVentr = new JTextField();
		txttacVentr.setColumns(10);
		txttacVentr.setBounds(524, 76, 86, 20);
		panel.add(txttacVentr);
		
		txtExtraSupra = new JTextField();
		txtExtraSupra.setColumns(10);
		txtExtraSupra.setBounds(590, 104, 86, 20);
		panel.add(txtExtraSupra);
		
		txtTacSupra = new JTextField();
		txtTacSupra.setColumns(10);
		txtTacSupra.setBounds(567, 137, 86, 20);
		panel.add(txtTacSupra);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Idade");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(311, 25, 54, 19);
		getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(360, 27, 86, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		txtObsExame = new JTextPane();
		txtObsExame.setBounds(10, 307, 912, 222);
		getContentPane().add(txtObsExame);
		
		JLabel lblNewLabel_3 = new JLabel("Observações sobre o exame");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 282, 225, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarHolter24();
			}
		});
		btnNewButton.setBounds(10, 605, 151, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Id Agendamento");
		lblNewLabel_2_1_1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_2.setBounds(427, 55, 137, 19);
		getContentPane().add(lblNewLabel_2_1_1_2);
		
		txtIdAgendamento = new JTextField();
		txtIdAgendamento.setColumns(10);
		txtIdAgendamento.setBounds(549, 57, 86, 19);
		getContentPane().add(txtIdAgendamento);

	}
	
	// Faz um select no banco de dados e retorna um array contendo os nomes dos profissionais e dos pacientes para o combo box
	public void selectPacientesProfissionais() {
		Holter24Controller holter24 = new Holter24Controller();
		holter24.selectPacientesProfissionais(TelaCadastroHolter.this);
	}
	
	
	public void cadastrarHolter24() {
		//Instanciando um objeto holter 24
		Holter24 holter24 = new Holter24(
				cboNomePaciente.getSelectedItem().toString(),
				txtIdade.getText(),
				cboProfissionalResponsavel.getSelectedItem().toString(),
				txtHorarioExame.getText(),
				txtDataExame.getText(),
				txtIdAgendamento.getText(),
				txtFreqMin.getText(),
				txtFreqMed.getText(),
				txtFreqMax.getText(),
				txtBat.getText(),
				txtVarRR.getText(),
				txtExtraVentr.getText(),
				txtExtraVentrPar.getText(),
				txttacVentr.getText(),
				txtExtraSupra.getText(),
				txtTacSupra.getText(),
				txtObsExame.getText()
		);
		
		Holter24Controller holter24Controller = new Holter24Controller();
		holter24Controller.salvarHolter24(holter24);
	}
	
	
	
	public JComboBox getCboProfissionalResponsavel() {
		return cboProfissionalResponsavel;
	}

	public void setCboProfissionalResponsavel(JComboBox cboProfissionalResponsavel) {
		this.cboProfissionalResponsavel = cboProfissionalResponsavel;
	}

	public JComboBox getCboNomePaciente() {
		return cboNomePaciente;
	}

	public void setCboNomePaciente(JComboBox cboNomePaciente) {
		this.cboNomePaciente = cboNomePaciente;
	}

	

	public JTextField getTxtFreqMin() {
		return txtFreqMin;
	}

	public void setTxtFreqMin(JTextField txtFreqMin) {
		this.txtFreqMin = txtFreqMin;
	}

	public JTextField getTxtFreqMed() {
		return txtFreqMed;
	}

	public void setTxtFreqMed(JTextField txtFreqMed) {
		this.txtFreqMed = txtFreqMed;
	}

	public JTextField getTxtFreqMax() {
		return txtFreqMax;
	}

	public void setTxtFreqMax(JTextField txtFreqMax) {
		this.txtFreqMax = txtFreqMax;
	}

	public JTextField getTxtBat() {
		return txtBat;
	}

	public void setTxtBat(JTextField txtBat) {
		this.txtBat = txtBat;
	}

	public JTextField getTxtVarRR() {
		return txtVarRR;
	}

	public void setTxtVarRR(JTextField txtVarRR) {
		this.txtVarRR = txtVarRR;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTxtDataExame() {
		return txtDataExame;
	}

	public void setTxtDataExame(JTextField txtDataExame) {
		this.txtDataExame = txtDataExame;
	}

	public JTextField getTxtHorarioExame() {
		return txtHorarioExame;
	}

	public void setTxtHorarioExame(JTextField txtHorarioExame) {
		this.txtHorarioExame = txtHorarioExame;
	}

	public JTextField getTxtIdade() {
		return txtIdade;
	}

	public void setTxtIdade(JTextField txtIdade) {
		this.txtIdade = txtIdade;
	}

	public JTextField getTxtExtraVentr() {
		return txtExtraVentr;
	}

	public void setTxtExtraVentr(JTextField txtExtraVentr) {
		this.txtExtraVentr = txtExtraVentr;
	}

	public JTextField getTxtExtraVentrPar() {
		return txtExtraVentrPar;
	}

	public void setTxtExtraVentrPar(JTextField txtExtraVentrPar) {
		this.txtExtraVentrPar = txtExtraVentrPar;
	}

	public JTextField getTxttacVentr() {
		return txttacVentr;
	}

	public void setTxttacVentr(JTextField txttacVentr) {
		this.txttacVentr = txttacVentr;
	}

	public JTextField getTxtExtraSupra() {
		return txtExtraSupra;
	}

	public void setTxtExtraSupra(JTextField txtExtraSupra) {
		this.txtExtraSupra = txtExtraSupra;
	}

	public JTextField getTxtTacSupra() {
		return txtTacSupra;
	}

	public void setTxtTacSupra(JTextField txtTacSupra) {
		this.txtTacSupra = txtTacSupra;
	}

	public JTextField getTxtIdAgendamento() {
		return txtIdAgendamento;
	}

	public void setTxtIdAgendamento(JTextField txtIdAgendamento) {
		this.txtIdAgendamento = txtIdAgendamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
