package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class TelaAgendaExames extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmailPaciente;
	private JTextField txtTelefonePaciente;
	private JTextField txtCelularPaciente;
	private JTextField txtDataRealizacao;
	private JTextField txtHorarioRealizacao;
	private JTextField txtObs;
	private JTable tblAgendamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgendaExames frame = new TelaAgendaExames();
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
	public TelaAgendaExames() {
		setMaximizable(true);
		getContentPane().setBackground(new Color(227, 227, 227));
		setTitle("Agenda de exames");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 948, 669);
		getContentPane().setLayout(null);
		
		JLabel lblnomePaciente = new JLabel("Nome do Paciente");
		lblnomePaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblnomePaciente.setBounds(10, 342, 134, 14);
		getContentPane().add(lblnomePaciente);
		
		JComboBox cboNomePaciente = new JComboBox();
		cboNomePaciente.setBounds(10, 368, 315, 22);
		getContentPane().add(cboNomePaciente);
		
		JLabel lblemailPaciente = new JLabel("Email Paciente");
		lblemailPaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblemailPaciente.setBounds(347, 342, 134, 14);
		getContentPane().add(lblemailPaciente);
		
		txtEmailPaciente = new JTextField();
		txtEmailPaciente.setBounds(347, 368, 171, 20);
		getContentPane().add(txtEmailPaciente);
		txtEmailPaciente.setColumns(10);
		
		JLabel lblTelefonePaciente = new JLabel("Telefone");
		lblTelefonePaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblTelefonePaciente.setBounds(535, 342, 134, 14);
		getContentPane().add(lblTelefonePaciente);
		
		txtTelefonePaciente = new JTextField();
		txtTelefonePaciente.setColumns(10);
		txtTelefonePaciente.setBounds(534, 368, 171, 20);
		getContentPane().add(txtTelefonePaciente);
		
		txtCelularPaciente = new JTextField();
		txtCelularPaciente.setColumns(10);
		txtCelularPaciente.setBounds(715, 369, 171, 20);
		getContentPane().add(txtCelularPaciente);
		
		JLabel lblCelularPaciente = new JLabel("Celular");
		lblCelularPaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblCelularPaciente.setBounds(715, 342, 134, 14);
		getContentPane().add(lblCelularPaciente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 912, 285);
		getContentPane().add(scrollPane);
		
		tblAgendamentos = new JTable();
		scrollPane.setViewportView(tblAgendamentos);
		
		JComboBox cboProfissionalResponsavel = new JComboBox();
		cboProfissionalResponsavel.setBounds(10, 424, 315, 22);
		getContentPane().add(cboProfissionalResponsavel);
		
		JLabel lblProfissionalResponsavel = new JLabel("Profissional Responsável");
		lblProfissionalResponsavel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblProfissionalResponsavel.setBounds(10, 401, 183, 14);
		getContentPane().add(lblProfissionalResponsavel);
		
		JLabel lblDataRealizacao = new JLabel("Data da Realização");
		lblDataRealizacao.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblDataRealizacao.setBounds(347, 404, 141, 14);
		getContentPane().add(lblDataRealizacao);
		
		txtDataRealizacao = new JTextField();
		txtDataRealizacao.setColumns(10);
		txtDataRealizacao.setBounds(347, 425, 171, 20);
		getContentPane().add(txtDataRealizacao);
		
		JLabel lblHorarioRealizacao = new JLabel("Horário de Realizacao");
		lblHorarioRealizacao.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblHorarioRealizacao.setBounds(535, 404, 170, 14);
		getContentPane().add(lblHorarioRealizacao);
		
		txtHorarioRealizacao = new JTextField();
		txtHorarioRealizacao.setColumns(10);
		txtHorarioRealizacao.setBounds(535, 425, 171, 20);
		getContentPane().add(txtHorarioRealizacao);
		
		JLabel lblObs = new JLabel("Observações e exames da consulta");
		lblObs.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblObs.setBounds(10, 457, 274, 14);
		getContentPane().add(lblObs);
		
		txtObs = new JTextField();
		txtObs.setColumns(10);
		txtObs.setBounds(10, 482, 912, 96);
		getContentPane().add(txtObs);
		
		JButton btnNewButton = new JButton("Cadastrar Agendamento");
		btnNewButton.setBounds(10, 605, 151, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnAtualizarAgendamento = new JButton("Atualizar Agendamento");
		btnAtualizarAgendamento.setBounds(405, 605, 151, 23);
		getContentPane().add(btnAtualizarAgendamento);
		
		JButton btnExcluirAgendamento = new JButton("Excluir Agendamento");
		btnExcluirAgendamento.setBounds(771, 605, 151, 23);
		getContentPane().add(btnExcluirAgendamento);

	}	
}
