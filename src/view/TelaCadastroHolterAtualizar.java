package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import controller.Holter24Controller;
import modelo.entidade.Holter24;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaCadastroHolterAtualizar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String idExame;
	private JTextField txtPaciente;
	private JTextField txtIdade;
	private JTextField txtProfissional;
	private JTextField txtHorarioExame;
	private JTextField txtDataExame;
	private JTextField txtAgendamento;
	private JTextField txtVarRR;
	private JTextField txtTotBat;
	private JTextField txtFreqMax;
	private JTextField txtFreqMed;
	private JTextField txtFreqMin;
	private JTextField txtExtraVentr;
	private JTextField txtExtraVentrPar;
	private JTextField txtTacVentr;
	private JTextField txtExtraSupra;
	private JTextField txtTacSupra;
	private JTextPane txtObsExame;
	
	
	
	public TelaCadastroHolterAtualizar(String idExame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroHolterAtualizar.class.getResource("/icones/coracao25.png")));
		setTitle("Alterar Exame");
		setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				buscarDadosExame();
			}
		});
		//Id do exame pelo qual vamos trabalhar
		this.idExame = idExame;
		setBounds(100, 100, 978, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPaciente = new JLabel("Paciente");
			lblPaciente.setBounds(10, 11, 58, 22);
			lblPaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
			contentPanel.add(lblPaciente);
		}
		
		txtPaciente = new JTextField();
		txtPaciente.setEnabled(false);
		txtPaciente.setBounds(78, 15, 124, 20);
		contentPanel.add(txtPaciente);
		txtPaciente.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblIdade.setBounds(212, 11, 43, 22);
		contentPanel.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(265, 15, 161, 20);
		contentPanel.add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblProfissionalResponsvel = new JLabel("Profissional Responsável");
		lblProfissionalResponsvel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblProfissionalResponsvel.setBounds(436, 11, 177, 22);
		contentPanel.add(lblProfissionalResponsvel);
		
		txtProfissional = new JTextField();
		txtProfissional.setEnabled(false);
		txtProfissional.setBounds(623, 15, 327, 20);
		contentPanel.add(txtProfissional);
		txtProfissional.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Horario Exame");
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 55, 114, 19);
		contentPanel.add(lblNewLabel_2_1_1_1);
		
		txtHorarioExame = new JTextField();
		txtHorarioExame.setBounds(134, 57, 133, 20);
		contentPanel.add(txtHorarioExame);
		txtHorarioExame.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Data Exame");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(293, 55, 89, 19);
		contentPanel.add(lblNewLabel_2_1_1_1_1);
		
		txtDataExame = new JTextField();
		txtDataExame.setBounds(392, 57, 141, 20);
		contentPanel.add(txtDataExame);
		txtDataExame.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Agendamento");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(563, 55, 104, 19);
		contentPanel.add(lblNewLabel_2_1_1_1_1_1);
		
		txtAgendamento = new JTextField();
		txtAgendamento.setBounds(672, 57, 278, 20);
		contentPanel.add(txtAgendamento);
		txtAgendamento.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Holter 24", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		panel.setBounds(10, 107, 940, 176);
		contentPanel.add(panel);
		
		JLabel lblVariabilidadeRr = new JLabel("Variabilidade RR");
		lblVariabilidadeRr.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblVariabilidadeRr.setBounds(10, 135, 127, 19);
		panel.add(lblVariabilidadeRr);
		
		txtVarRR = new JTextField();
		txtVarRR.setColumns(10);
		txtVarRR.setBounds(137, 137, 65, 20);
		panel.add(txtVarRR);
		
		JLabel lblTotalBatimentos = new JLabel("Total Batimentos");
		lblTotalBatimentos.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblTotalBatimentos.setBounds(10, 105, 127, 19);
		panel.add(lblTotalBatimentos);
		
		txtTotBat = new JTextField();
		txtTotBat.setColumns(10);
		txtTotBat.setBounds(137, 104, 65, 20);
		panel.add(txtTotBat);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("bpm");
		lblNewLabel_1_1_1.setBounds(227, 16, 30, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblFrequenciaMxima = new JLabel("Frequencia Máxima");
		lblFrequenciaMxima.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblFrequenciaMxima.setBounds(10, 11, 140, 19);
		panel.add(lblFrequenciaMxima);
		
		txtFreqMax = new JTextField();
		txtFreqMax.setColumns(10);
		txtFreqMax.setBounds(152, 13, 65, 20);
		panel.add(txtFreqMax);
		
		JLabel lblFrequenciaMdia = new JLabel("Frequencia Média");
		lblFrequenciaMdia.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblFrequenciaMdia.setBounds(10, 41, 140, 19);
		panel.add(lblFrequenciaMdia);
		
		txtFreqMed = new JTextField();
		txtFreqMed.setColumns(10);
		txtFreqMed.setBounds(137, 41, 65, 20);
		panel.add(txtFreqMed);
		
		JLabel lblNewLabel_1_1 = new JLabel("bpm");
		lblNewLabel_1_1.setBounds(207, 46, 30, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Frequencia Mínima");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 74, 140, 19);
		panel.add(lblNewLabel);
		
		txtFreqMin = new JTextField();
		txtFreqMin.setColumns(10);
		txtFreqMin.setBounds(147, 76, 65, 20);
		panel.add(txtFreqMin);
		
		JLabel lblNewLabel_1 = new JLabel("bpm");
		lblNewLabel_1.setBounds(217, 79, 30, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblExtrassstolesVentricularesPareadas = new JLabel("Extrassístoles Ventriculares Pareadas");
		lblExtrassstolesVentricularesPareadas.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblExtrassstolesVentricularesPareadas.setBounds(358, 41, 261, 19);
		panel.add(lblExtrassstolesVentricularesPareadas);
		
		JLabel lblExtrassstoles = new JLabel("Extrassístoles Ventriculares");
		lblExtrassstoles.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblExtrassstoles.setBounds(358, 11, 194, 19);
		panel.add(lblExtrassstoles);
		
		JLabel lblTac = new JLabel("Taquicardia Ventricular");
		lblTac.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblTac.setBounds(358, 74, 170, 19);
		panel.add(lblTac);
		
		JLabel lblExtrassstolesSupraVentriculares = new JLabel("Extrassístoles Supraventriculares");
		lblExtrassstolesSupraVentriculares.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblExtrassstolesSupraVentriculares.setBounds(358, 105, 261, 19);
		panel.add(lblExtrassstolesSupraVentriculares);
		
		JLabel lblTaquicardiaSupraventricular = new JLabel("Taquicardia Supraventricular");
		lblTaquicardiaSupraventricular.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblTaquicardiaSupraventricular.setBounds(358, 135, 210, 19);
		panel.add(lblTaquicardiaSupraventricular);
		
		txtExtraVentr = new JTextField();
		txtExtraVentr.setColumns(10);
		txtExtraVentr.setBounds(551, 11, 86, 20);
		panel.add(txtExtraVentr);
		
		txtExtraVentrPar = new JTextField();
		txtExtraVentrPar.setColumns(10);
		txtExtraVentrPar.setBounds(623, 41, 86, 20);
		panel.add(txtExtraVentrPar);
		
		txtTacVentr = new JTextField();
		txtTacVentr.setColumns(10);
		txtTacVentr.setBounds(524, 76, 86, 20);
		panel.add(txtTacVentr);
		
		txtExtraSupra = new JTextField();
		txtExtraSupra.setColumns(10);
		txtExtraSupra.setBounds(590, 104, 86, 20);
		panel.add(txtExtraSupra);
		
		txtTacSupra = new JTextField();
		txtTacSupra.setColumns(10);
		txtTacSupra.setBounds(567, 137, 86, 20);
		panel.add(txtTacSupra);
		
		txtObsExame = new JTextPane();
		txtObsExame.setBounds(10, 323, 940, 93);
		contentPanel.add(txtObsExame);
		
		JLabel lblNewLabel_3 = new JLabel("Observações sobre o exame");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 290, 225, 22);
		contentPanel.add(lblNewLabel_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AtualizarHolter24();
						TelaCadastroHolterAtualizar.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaCadastroHolterAtualizar.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	//aaaa
	public void setarCampos(ArrayList<String> dadosExame) {
		txtPaciente.setText(dadosExame.get(1));
		txtIdade.setText(dadosExame.get(2));
		txtProfissional.setText(dadosExame.get(3));
		txtHorarioExame.setText(dadosExame.get(4));
		txtDataExame.setText(dadosExame.get(5));
		txtAgendamento.setText(dadosExame.get(6));
		txtFreqMax.setText(dadosExame.get(7));
		txtFreqMed.setText(dadosExame.get(8));
		txtFreqMin.setText(dadosExame.get(9));
		txtTotBat.setText(dadosExame.get(10));
		txtVarRR.setText(dadosExame.get(11));
		txtExtraVentr.setText(dadosExame.get(12));
		txtExtraVentrPar.setText(dadosExame.get(13));
		txtTacVentr.setText(dadosExame.get(14));
		txtExtraSupra.setText(dadosExame.get(15));
		txtTacSupra.setText(dadosExame.get(16));
		txtObsExame.setText(dadosExame.get(9));
	}
	
	
	public void buscarDadosExame() {
		Holter24Controller holter = new Holter24Controller();
		ArrayList<String> dadosExame= holter.buscarDadosExameHolter(idExame);
		setarCampos(dadosExame);
	}
	
	
	public void AtualizarHolter24() {
		//Instanciando um objeto holter 24
		Holter24 holter24 = new Holter24(
				txtPaciente.getText(),
				txtIdade.getText(),
				txtProfissional.getText(),
				txtHorarioExame.getText(),
				txtDataExame.getText(),
				txtAgendamento.getText(),
				txtFreqMin.getText(),
				txtFreqMed.getText(),
				txtFreqMax.getText(),
				txtTotBat.getText(),
				txtVarRR.getText(),
				txtExtraVentr.getText(),
				txtExtraVentrPar.getText(),
				txtTacVentr.getText(),
				txtExtraSupra.getText(),
				txtTacSupra.getText(),
				txtObsExame.getText()
		);
		Holter24Controller holter24Controller = new Holter24Controller();
		holter24Controller.atualizarHolter24(holter24, idExame);
		buscarDadosExame();
	}
	
	
	
}
