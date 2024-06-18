package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.AgendaExamesController;
import modelo.entidade.AgendamentoConsulta;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ListSelectionModel;

public class TelaAgendaExames extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmailPaciente;
	private JTextField txtTelefonePaciente;
	private JTextField txtCelularPaciente;
	private JTextField txtDataRealizacao;
	private JTextField txtHorarioRealizacao;
	private JTable tblAgendamentos;
	private JComboBox cboNomePaciente;
	private JComboBox cboProfissionalResponsavel;
	private JComboBox cboStatusConsulta;
	private JTextPane txtObs;
	private JTextField txtIdAgendamento;
	private JTable tblHorariosProf;

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
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				selectPacientes();
			}
		});
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
		
		cboNomePaciente = new JComboBox();
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
		scrollPane.setBounds(10, 46, 912, 258);
		getContentPane().add(scrollPane);
		
		tblAgendamentos = new JTable();
		tblAgendamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblAgendamentos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setarCampos();
			}
		});
		tblAgendamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		scrollPane.setViewportView(tblAgendamentos);
		
		cboProfissionalResponsavel = new JComboBox();
		cboProfissionalResponsavel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectHorarioProf();
			}
		});
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
		lblObs.setBounds(347, 456, 274, 14);
		getContentPane().add(lblObs);
		
		JButton btnNewButton = new JButton("Cadastrar Agendamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertConsultas();
			}
		});
		btnNewButton.setBounds(10, 605, 151, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnAtualizarAgendamento = new JButton("Atualizar Agendamento");
		btnAtualizarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateConsultas();
			}
		});
		btnAtualizarAgendamento.setBounds(405, 605, 151, 23);
		getContentPane().add(btnAtualizarAgendamento);
		
		JButton btnExcluirAgendamento = new JButton("Excluir Agendamento");
		btnExcluirAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirma = JOptionPane.showConfirmDialog(null,"Deseja Prosseguir com a exclusão?", "Atenção", JOptionPane.YES_NO_OPTION);
				if(confirma==JOptionPane.YES_OPTION) {
					deleteConsultas();
				}
			}
		});
		btnExcluirAgendamento.setBounds(771, 605, 151, 23);
		getContentPane().add(btnExcluirAgendamento);
		
		cboStatusConsulta = new JComboBox();
		cboStatusConsulta.setModel(new DefaultComboBoxModel(new String[] {"Em aberto", "Realizado"}));
		cboStatusConsulta.setBounds(715, 424, 156, 22);
		getContentPane().add(cboStatusConsulta);
		
		JLabel lblStatusConsulta = new JLabel("Status da Consulta");
		lblStatusConsulta.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblStatusConsulta.setBounds(715, 404, 156, 14);
		getContentPane().add(lblStatusConsulta);
		
		txtObs = new JTextPane();
		txtObs.setBounds(347, 483, 533, 94);
		getContentPane().add(txtObs);
		
		JLabel lblIdAgendamento = new JLabel("Agendamento N");
		lblIdAgendamento.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblIdAgendamento.setBounds(13, 311, 123, 20);
		getContentPane().add(lblIdAgendamento);
		
		txtIdAgendamento = new JTextField();
		txtIdAgendamento.setEditable(false);
		txtIdAgendamento.setEnabled(false);
		txtIdAgendamento.setColumns(10);
		txtIdAgendamento.setBounds(142, 308, 96, 20);
		getContentPane().add(txtIdAgendamento);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 457, 315, 121);
		getContentPane().add(scrollPane_1);
		
		tblHorariosProf = new JTable();
		tblHorariosProf.setEnabled(false);
		scrollPane_1.setViewportView(tblHorariosProf);

	}	
	
	
	public void selectPacientes() {
		AgendaExamesController agendaExames = new AgendaExamesController();
		agendaExames.selectPacientesProfissionais(TelaAgendaExames.this);
		selectConsultas();
	}
	
	public void selectConsultas() {
		AgendaExamesController agendaController = new AgendaExamesController();
		ResultSet rs = agendaController.buscarAgendamentos();
		tblAgendamentos.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
	
	public void setarCampos() {
		int linhaSelecionada =  tblAgendamentos.getSelectedRow();
		String nomePessoaSelecionada = tblAgendamentos.getModel().getValueAt(linhaSelecionada, 1).toString();
		String nomeProfissionalSelecionado = tblAgendamentos.getModel().getValueAt(linhaSelecionada, 5).toString();
		
		for(int i = 0; i < cboNomePaciente.getModel().getSize(); i++) {
			if(cboNomePaciente.getModel().getElementAt(i).toString().equals(nomePessoaSelecionada)) {
				cboNomePaciente.getModel().setSelectedItem(nomePessoaSelecionada);
				break;
			}	
		}
		
		for(int i = 0; i < cboProfissionalResponsavel.getModel().getSize(); i++) {
			if(cboProfissionalResponsavel.getModel().getElementAt(i).toString().equals(nomeProfissionalSelecionado)) {
				cboProfissionalResponsavel.getModel().setSelectedItem(nomeProfissionalSelecionado);
				break;
			}	
		}
		
		
		String statusSelecionado = tblAgendamentos.getModel().getValueAt(linhaSelecionada, 8).toString();
		
		for(int i = 0; i < cboStatusConsulta.getModel().getSize(); i++) {
			if(cboStatusConsulta.getModel().getElementAt(i).toString().equals(statusSelecionado)) {
				cboStatusConsulta.getModel().setSelectedItem(statusSelecionado);
				break;
			}
		}
		
		txtEmailPaciente.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 2).toString());
		txtTelefonePaciente.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 3).toString());
		txtCelularPaciente.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 4).toString());
		txtDataRealizacao.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 6).toString());
		txtDataRealizacao.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 4).toString());
		txtHorarioRealizacao.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 7).toString());
		txtObs.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 9).toString());
		txtIdAgendamento.setText(tblAgendamentos.getModel().getValueAt(linhaSelecionada, 0).toString());
	}
	
	
	
	

	public void insertConsultas() {
		AgendamentoConsulta agendamento = new AgendamentoConsulta(
				cboNomePaciente.getSelectedItem().toString(),
				txtEmailPaciente.getText(),
				txtTelefonePaciente.getText(),
				txtCelularPaciente.getText(),
				cboProfissionalResponsavel.getSelectedItem().toString(),
				txtDataRealizacao.getText(),
				txtHorarioRealizacao.getText(),
				cboStatusConsulta.getSelectedItem().toString(),
				txtObs.getText()
				);
	
		AgendaExamesController agendaExame = new AgendaExamesController();
		agendaExame.salvarAgendamento(agendamento);
		selectConsultas();
	}
	
	public void updateConsultas() {
		AgendamentoConsulta agendamento = new AgendamentoConsulta(
					cboNomePaciente.getSelectedItem().toString(),
					txtEmailPaciente.getText(),
					txtTelefonePaciente.getText(),
					txtCelularPaciente.getText(),
					cboProfissionalResponsavel.getSelectedItem().toString(),
					txtDataRealizacao.getText(),
					txtHorarioRealizacao.getText(),
					cboStatusConsulta.getSelectedItem().toString(),
					txtObs.getText()
				);
		
		
		String idAgendamento = txtIdAgendamento.getText();
		AgendaExamesController agendaExame = new AgendaExamesController();
		agendaExame.updateAgendamentos(agendamento, idAgendamento);
		selectConsultas();
	}
	
	public void deleteConsultas() {
		
		String idAgendamento = txtIdAgendamento.getText();
		AgendaExamesController agendaExame = new AgendaExamesController();
		agendaExame.deleteAgendamentos(idAgendamento);
		selectConsultas();
	}
	
	public void selectHorarioProf() {
		String nomeProf = cboProfissionalResponsavel.getSelectedItem().toString();
		AgendaExamesController agendaExame = new AgendaExamesController();
		ResultSet rs = agendaExame.selectHorarioProfissional(nomeProf);
		tblHorariosProf.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	
	public JTextField getTxtEmailPaciente() {
		return txtEmailPaciente;
	}

	public void setTxtEmailPaciente(JTextField txtEmailPaciente) {
		this.txtEmailPaciente = txtEmailPaciente;
	}

	public JTextField getTxtTelefonePaciente() {
		return txtTelefonePaciente;
	}

	public void setTxtTelefonePaciente(JTextField txtTelefonePaciente) {
		this.txtTelefonePaciente = txtTelefonePaciente;
	}

	public JTextField getTxtCelularPaciente() {
		return txtCelularPaciente;
	}

	public void setTxtCelularPaciente(JTextField txtCelularPaciente) {
		this.txtCelularPaciente = txtCelularPaciente;
	}

	public JTextField getTxtDataRealizacao() {
		return txtDataRealizacao;
	}

	public void setTxtDataRealizacao(JTextField txtDataRealizacao) {
		this.txtDataRealizacao = txtDataRealizacao;
	}

	public JTextField getTxtHorarioRealizacao() {
		return txtHorarioRealizacao;
	}

	public void setTxtHorarioRealizacao(JTextField txtHorarioRealizacao) {
		this.txtHorarioRealizacao = txtHorarioRealizacao;
	}

	

	public JTable getTblAgendamentos() {
		return tblAgendamentos;
	}

	public void setTblAgendamentos(JTable tblAgendamentos) {
		this.tblAgendamentos = tblAgendamentos;
	}

	public JComboBox getCboNomePaciente() {
		return cboNomePaciente;
	}

	public void setCboNomePaciente(JComboBox cboNomePaciente) {
		this.cboNomePaciente = cboNomePaciente;
	}

	public JComboBox getCboProfissionalResponsavel() {
		return cboProfissionalResponsavel;
	}

	public void setCboProfissionalResponsavel(JComboBox cboProfissionalResponsavel) {
		this.cboProfissionalResponsavel = cboProfissionalResponsavel;
	}
}
