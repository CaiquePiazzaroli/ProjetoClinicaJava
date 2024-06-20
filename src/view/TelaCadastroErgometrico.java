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
import javax.swing.border.TitledBorder;

public class TelaCadastroErgometrico extends JInternalFrame {

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
					TelaCadastroErgometrico frame = new TelaCadastroErgometrico();
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
	public TelaCadastroErgometrico() {
		setFrameIcon(new ImageIcon(TelaCadastroErgometrico.class.getResource("/icones/coracao25.png")));
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				
			}
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
		
			}
		});
		setMaximizable(true);
		getContentPane().setBackground(new Color(227, 227, 227));
		setTitle("Teste ergométrico");
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
		panel.setBorder(new TitledBorder(null, "Exame Ergom\u00E9trico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 97, 912, 176);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVariabilidadeRr = new JLabel("Débito Sistólico");
		lblVariabilidadeRr.setBounds(10, 135, 127, 19);
		panel.add(lblVariabilidadeRr);
		lblVariabilidadeRr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtVarRR = new JTextField();
		txtVarRR.setBounds(137, 137, 254, 20);
		panel.add(txtVarRR);
		txtVarRR.setColumns(10);
		
		JLabel lblTotalBatimentos = new JLabel("Débito Cardíaco");
		lblTotalBatimentos.setBounds(10, 105, 127, 19);
		panel.add(lblTotalBatimentos);
		lblTotalBatimentos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtBat = new JTextField();
		txtBat.setBounds(137, 104, 254, 20);
		panel.add(txtBat);
		txtBat.setColumns(10);
		
		JLabel lblFrequenciaMxima = new JLabel("Duração da prova");
		lblFrequenciaMxima.setBounds(10, 14, 140, 19);
		panel.add(lblFrequenciaMxima);
		lblFrequenciaMxima.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtFreqMax = new JTextField();
		txtFreqMax.setBounds(152, 13, 239, 20);
		panel.add(txtFreqMax);
		txtFreqMax.setColumns(10);
		
		JLabel lblFrequenciaMdia = new JLabel("Distância Percorrida");
		lblFrequenciaMdia.setBounds(10, 41, 140, 19);
		panel.add(lblFrequenciaMdia);
		lblFrequenciaMdia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtFreqMed = new JTextField();
		txtFreqMed.setBounds(162, 44, 229, 20);
		panel.add(txtFreqMed);
		txtFreqMed.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FC Máxima");
		lblNewLabel.setBounds(10, 74, 127, 19);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtFreqMin = new JTextField();
		txtFreqMin.setBounds(147, 76, 244, 20);
		panel.add(txtFreqMin);
		txtFreqMin.setColumns(10);
		
		JLabel lblExtrassstolesVentricularesPareadas = new JLabel("MET Máximo");
		lblExtrassstolesVentricularesPareadas.setBounds(448, 41, 114, 19);
		panel.add(lblExtrassstolesVentricularesPareadas);
		lblExtrassstolesVentricularesPareadas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		JLabel lblExtrassstoles = new JLabel("DP Máximo");
		lblExtrassstoles.setBounds(448, 14, 103, 19);
		panel.add(lblExtrassstoles);
		lblExtrassstoles.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtExtraVentr = new JTextField();
		txtExtraVentr.setBounds(548, 16, 239, 20);
		panel.add(txtExtraVentr);
		txtExtraVentr.setColumns(10);
		
		txtExtraVentrPar = new JTextField();
		txtExtraVentrPar.setColumns(10);
		txtExtraVentrPar.setBounds(548, 43, 239, 20);
		panel.add(txtExtraVentrPar);
		
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
	
}
