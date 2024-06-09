package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PacienteController;
import controller.ProfissionalController;
import modelo.entidade.Paciente;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import modelo.entidade.Profissional;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaCadastroProfissional extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIdProf;
	private JTextField txtNomeProf;
	private JTable tblProfissionais;
	private JTable tblEspecProf;
	private JTextField txtPesquisarProf;
	private JButton btnAtualizarProf;
	private JButton btnExcluirProf;
	private JButton btnIncluirProf;
	private JButton btnExcluirEspec;
	private JTable tblHorarioProf;
	private JButton btnAdicionarEspec;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtHoraInicio;
	private JTextField txtHoraFim;
	private JComboBox cboDiaSemana;
	private JButton btnAdicionarHorario;
	private JButton btnExcluirHorario;
	private JButton btnAtualizarHorario;
	private JComboBox cboEspecialidade;
	
	public TelaCadastroProfissional() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				//Chamando o método pesquisar profissionais
				pesquisarProfissional();
			}
		});
		setTitle("Cadastro de profissionais");
		setBounds(0, 0,  948, 669);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("idProfissional");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(598, 109, 110, 27);
		getContentPane().add(lblNewLabel);
		
		txtIdProf = new JTextField();
		txtIdProf.setBounds(598, 147, 86, 20);
		getContentPane().add(txtIdProf);
		txtIdProf.setEnabled(false);
		txtIdProf.setEditable(false);
		txtIdProf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Profissional*");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(596, 168, 150, 27);
		getContentPane().add(lblNewLabel_1);
		
		txtNomeProf = new JTextField();
		txtNomeProf.setBounds(598, 197, 324, 20);
		getContentPane().add(txtNomeProf);
		txtNomeProf.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 575, 191);
		getContentPane().add(scrollPane);
		
		tblProfissionais = new JTable();
		tblProfissionais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblProfissionais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblProfissionais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Chamando o método setar campos
				setarCampos();
				
			}
		});
		tblProfissionais.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Nome Profissional"
			}
		));
		scrollPane.setViewportView(tblProfissionais);
		
		JLabel lblNewLabel_2 = new JLabel("Especialidades do profissional");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 238, 215, 27);
		getContentPane().add(lblNewLabel_2);
		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(10, 269, 381, 185);
//		getContentPane().add(scrollPane_1);
		
//		tblEspecProf = new JTable();
//		tblEspecProf.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				btnExcluirEspec.setEnabled(true);
//				btnAdicionarEspec.setEnabled(true);
//				
//			}
//		});
//		tblEspecProf.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		tblEspecProf.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Especialidades"
//			}
//		));
//		scrollPane_1.setViewportView(tblEspecProf);
		
//		btnAdicionarEspec = new JButton("Adicionar");
//		btnAdicionarEspec.setEnabled(false);
//		btnAdicionarEspec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnAdicionarEspec.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//Chamando o método adicionar especialiadade
//				 //adicionarEspecialidade();
//			}
//		});
//		btnAdicionarEspec.setBounds(10, 460, 86, 20);
//		getContentPane().add(btnAdicionarEspec);
		
		btnIncluirProf = new JButton("Incluir Profissional");
		btnIncluirProf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIncluirProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIncluirProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/IncluirProfissionalHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIncluirProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/IncluirProfissional.png")));
			}
		});
		btnIncluirProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/IncluirProfissional.png")));
		btnIncluirProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o método de criar profissional
				criarProfissional();
			}
		});
		btnIncluirProf.setBounds(10, 573, 257, 32);
		getContentPane().add(btnIncluirProf);
		
		btnAtualizarProf = new JButton("Atualizar Profissional");
		btnAtualizarProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtualizarProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/AtualizarProfissionalHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtualizarProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/AtualizarProfissional.png")));
			}
		});
		btnAtualizarProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/AtualizarProfissional.png")));
		btnAtualizarProf.setEnabled(false);
		btnAtualizarProf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtualizarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o metodo atualizar profissional
				atualizarProfissional();
			}
		});
		btnAtualizarProf.setBounds(337, 573, 257, 32);
		getContentPane().add(btnAtualizarProf);
		
		btnExcluirProf = new JButton("Excluir Profissional");
		btnExcluirProf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExcluirProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/ExcluirProfissionalHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExcluirProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/ExcluirProfissional.png")));
			}
		});
		btnExcluirProf.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/ExcluirProfissional.png")));
		btnExcluirProf.setEnabled(false);
		btnExcluirProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o método excluir profissional
				int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover este profissional?", "Atenção", JOptionPane.YES_NO_OPTION);
				if(confirma==JOptionPane.YES_OPTION) {
					excluirProfissional();
				}
			}
		});
		btnExcluirProf.setBounds(665, 573, 257, 32);
		getContentPane().add(btnExcluirProf);
		
		JLabel lblNewLabel_3 = new JLabel("Campos Obrigatórios *");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(593, 71, 171, 27);
		getContentPane().add(lblNewLabel_3);
		
		txtPesquisarProf = new JTextField();
		txtPesquisarProf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//Chamando o método pesquisar profissional
				pesquisarProfissional();
			}
		});
		txtPesquisarProf.setBounds(10, 11, 250, 27);
		getContentPane().add(txtPesquisarProf);
		txtPesquisarProf.setColumns(10);
		
//		btnExcluirEspec = new JButton("Excluir");
//		btnExcluirEspec.setEnabled(false);
//		btnExcluirEspec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnExcluirEspec.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//Chamando o método excluir espec
//				//excluirEspecialidade();
//			}
//		});
//		btnExcluirEspec.setBounds(98, 460, 86, 20);
//		getContentPane().add(btnExcluirEspec);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 269, 912, 156);
		getContentPane().add(scrollPane_2);
		
		tblHorarioProf = new JTable();
		tblHorarioProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarCamposHorario();
			}
		});
		tblHorarioProf.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Horarios de Atendimento"
			}
		));
		tblHorarioProf.getColumnModel().getColumn(0).setPreferredWidth(206);
		scrollPane_2.setViewportView(tblHorarioProf);
		
		JLabel lblNewLabel_4 = new JLabel("Horarios de Atendimento");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(738, 238, 184, 27);
		getContentPane().add(lblNewLabel_4);
		
		btnAdicionarHorario = new JButton("Adicionar");
		btnAdicionarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarHorario();
			}
		});
		btnAdicionarHorario.setBounds(665, 432, 81, 22);
		getContentPane().add(btnAdicionarHorario);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(TelaCadastroProfissional.class.getResource("/icones/doutor.png")));
		lblNewLabel_5.setBounds(782, 68, 128, 118);
		getContentPane().add(lblNewLabel_5);
		
		cboDiaSemana = new JComboBox();
		cboDiaSemana.setModel(new DefaultComboBoxModel(new String[] {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"}));
		cboDiaSemana.setBounds(170, 432, 162, 22);
		getContentPane().add(cboDiaSemana);
		
		lblNewLabel_6 = new JLabel("Horário Início:");
		lblNewLabel_6.setBounds(337, 436, 69, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtHoraInicio = new JTextField();
		txtHoraInicio.setBounds(411, 433, 80, 20);
		getContentPane().add(txtHoraInicio);
		txtHoraInicio.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Horário Final:");
		lblNewLabel_7.setBounds(501, 436, 65, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtHoraFim = new JTextField();
		txtHoraFim.setBounds(576, 433, 80, 20);
		getContentPane().add(txtHoraFim);
		txtHoraFim.setColumns(10);
		
		btnExcluirHorario = new JButton("Excluir");
		btnExcluirHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirHorario();
			}
		});
		btnExcluirHorario.setEnabled(false);
		btnExcluirHorario.setBounds(847, 432, 75, 22);
		getContentPane().add(btnExcluirHorario);
		
		btnAtualizarHorario = new JButton("Atualizar");
		btnAtualizarHorario.setEnabled(false);
		btnAtualizarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarHorario();
			}
		});
		btnAtualizarHorario.setBounds(755, 432, 82, 22);
		getContentPane().add(btnAtualizarHorario);
		
		cboEspecialidade = new JComboBox();
		cboEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"Ecocardiograma", "Eletrocardiograma", "Ergometrico", "Holter 24"}));
		cboEspecialidade.setBounds(10, 432, 150, 22);
		getContentPane().add(cboEspecialidade);
	} 

	
	public void setarCampos() {
		//Pega a linha que está selecionada
		int setar = tblProfissionais.getSelectedRow();
		txtIdProf.setText(tblProfissionais.getModel().getValueAt(setar, 0).toString());
		txtNomeProf.setText(tblProfissionais.getModel().getValueAt(setar, 1).toString());
		btnAtualizarProf.setEnabled(true);
		btnExcluirProf.setEnabled(true);
		btnIncluirProf.setEnabled(false);
		//pesquisarEspecialidade();
		pesquisarHorario();

	}
	
	public void limparCampos(){
		txtIdProf.setText(null);
		txtNomeProf.setText(null);
//		tblEspecProf.setModel(new DefaultTableModel(
//				new Object[][] {},
//				new String[] {
//					"Especialidades"
//				}
//		));
		tblHorarioProf.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Horarios de atendimento"
				}
		));
		btnAtualizarProf.setEnabled(false);
		btnExcluirProf.setEnabled(false);
		btnIncluirProf.setEnabled(true);
	}
	
	private void pesquisarProfissional() {
		//Criando o controller de profissional
		ProfissionalController profissionalController = new ProfissionalController();
		
		//Chamando o método de pesquisar profissional
		ResultSet rs = profissionalController.pesquisaProfissionais(TelaCadastroProfissional.this);
		
		// a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
		tblProfissionais.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	private void criarProfissional() {
		Profissional profissional = new Profissional(txtNomeProf.getText(), null);
		ProfissionalController profissionalController = new ProfissionalController();
		profissionalController.criarProfissional(txtNomeProf.getText());
		limparCampos();
		pesquisarProfissional();
	}
	
	private void atualizarProfissional() {
		Profissional profissional = new Profissional(txtNomeProf.getText(), txtIdProf.getText());
		ProfissionalController profissionalController = new ProfissionalController();
		profissionalController.atualizarProfissional(txtIdProf.getText(), txtNomeProf.getText());
		limparCampos();
		pesquisarProfissional();
	}
	
	private void excluirProfissional() {
		Profissional profissional = new Profissional(txtNomeProf.getText(), txtIdProf.getText());
		ProfissionalController profissionalController = new ProfissionalController();
		profissionalController.excluirProfissional(txtIdProf.getText());
		limparCampos();
		pesquisarProfissional();
	}
	
//	private void pesquisarEspecialidade() {
//		ProfissionalController profissionalController = new ProfissionalController();
//		ResultSet rs = profissionalController.pesquisaEspecialidadeProfissional(TelaCadastroProfissional.this);
//		tblEspecProf.setModel(DbUtils.resultSetToTableModel(rs));
//		btnAdicionarEspec.setEnabled(true);
//		
//	}
//	
//	private void adicionarEspecialidade() {
//		  Object[] exames = { "Ecocardiograma", "Eletrocardiograma", "Ergométrico", "Holter24"};
//	      Object exameSelecionado = JOptionPane.showInputDialog(null,"Escolha um exame", "Opção", JOptionPane.INFORMATION_MESSAGE, null, exames, exames [0]);
//	      ProfissionalController profissionalController = new ProfissionalController();
//	      if(exameSelecionado != null) {
//	    	  profissionalController.salvarEspecialidade(txtIdProf.getText(), exameSelecionado.toString());
//	      }
//	      pesquisarEspecialidade();
//	      btnExcluirEspec.setEnabled(false);
//	}
//	
//	private void excluirEspecialidade() {
//		int setar = tblEspecProf.getSelectedRow();
//		String especialidade = tblEspecProf.getModel().getValueAt(setar, 0).toString();
//		String idProf = txtIdProf.getText();
//		ProfissionalController profissionalController = new ProfissionalController();
//		profissionalController.excluirEspecialidade(idProf, especialidade);
//		pesquisarEspecialidade();
//		btnExcluirEspec.setEnabled(false);
//	}
	
	
	public void limparFormHorario() {
		cboDiaSemana.setSelectedIndex(0);
		txtHoraInicio.setText(null);
		txtHoraFim.setText(null);
	}
	
	
	public void setarCamposHorario() {
		int setar = tblHorarioProf.getSelectedRow();
		String exame = tblHorarioProf.getModel().getValueAt(setar, 0).toString();
		if(exame.equals("Ecocardiograma")) {
			cboEspecialidade.setSelectedIndex(0);
		} else if(exame.equals("Eletrocardiograma")) {
			cboEspecialidade.setSelectedIndex(1);
		} else if(exame.equals("Ergometrico")) {
			cboEspecialidade.setSelectedIndex(2);
		} else if(exame.equals("Holter 24")) {
			cboEspecialidade.setSelectedIndex(3);
		}
		String diaSemana = tblHorarioProf.getModel().getValueAt(setar, 1).toString();
		if(diaSemana.equals("Segunda")) {
			cboDiaSemana.setSelectedIndex(0);
		} else if(diaSemana.equals("Terça")) {
			cboDiaSemana.setSelectedIndex(1);
		} else if(diaSemana.equals("Quarta")) {
			cboDiaSemana.setSelectedIndex(2);
		} else if(diaSemana.equals("Quinta")) {
			cboDiaSemana.setSelectedIndex(3);
		} else if(diaSemana.equals("Sexta")) {
			cboDiaSemana.setSelectedIndex(4);
		} else if(diaSemana.equals("Sábado")) {
			cboDiaSemana.setSelectedIndex(5);
		}
		String horaInicio = tblHorarioProf.getModel().getValueAt(setar, 2).toString();
		String horaFim = tblHorarioProf.getModel().getValueAt(setar, 3).toString();
		
		
		
		
		txtHoraInicio.setText(horaInicio);
		txtHoraFim.setText(horaFim);
		btnAdicionarHorario.setEnabled(false);
		btnExcluirHorario.setEnabled(true);
		btnAtualizarHorario.setEnabled(true);
	}
	
	
	public JTable getTblHorarioProf() {
		return tblHorarioProf;
	}


	public void setTblHorarioProf(JTable tblHorarioProf) {
		this.tblHorarioProf = tblHorarioProf;
	}


	private void pesquisarHorario() {
		ProfissionalController profissionalController = new ProfissionalController();
		ResultSet rs = profissionalController.pesquisaHorarioProfissional(TelaCadastroProfissional.this);
		tblHorarioProf.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	private void salvarHorario() {
		ProfissionalController profissionalController = new ProfissionalController();
		profissionalController.salvarHorarioProfissional(TelaCadastroProfissional.this);
		pesquisarHorario();
		limparFormHorario();
	}
	
	private void atualizarHorario() {
		ProfissionalController profissionalController = new ProfissionalController();
		profissionalController.atualizarHorarioProfissional(TelaCadastroProfissional.this);
		pesquisarHorario();
		btnAdicionarHorario.setEnabled(true);
		btnExcluirHorario.setEnabled(false);
		btnAtualizarHorario.setEnabled(false);
		limparFormHorario();
	}
	
	private void excluirHorario() {
		ProfissionalController profissionalController = new ProfissionalController();
		profissionalController.excluirHorarioProfissional(TelaCadastroProfissional.this);
		pesquisarHorario();
		limparFormHorario();
		btnAdicionarHorario.setEnabled(true);
		btnExcluirHorario.setEnabled(false);
		btnAtualizarHorario.setEnabled(false);
		
	}
	
	
	

	public JComboBox getCboEspecialidade() {
		return cboEspecialidade;
	}


	public void setCboEspecialidade(JComboBox cboEspecialidade) {
		this.cboEspecialidade = cboEspecialidade;
	}


	public JTextField getTxtIdProf() {
			return txtIdProf;
		}

		public void setTxtIdProf(JTextField txtIdProf) {
			this.txtIdProf = txtIdProf;
		}

	public JTable getTblProfissionais() {
		return tblProfissionais;
	}

	public void setTblProfissionais(JTable tblProfissionais) {
		this.tblProfissionais = tblProfissionais;
	}

	public JTextField getTxtPesquisarProf() {
		return txtPesquisarProf;
	}

	public void setTxtPesquisarProf(JTextField txtPesquisarProf) {
		this.txtPesquisarProf = txtPesquisarProf;
	}


	public JTextField getTxtHoraInicio() {
		return txtHoraInicio;
	}


	public void setTxtHoraInicio(JTextField txtHoraInicio) {
		this.txtHoraInicio = txtHoraInicio;
	}


	public JTextField getTxtHoraFim() {
		return txtHoraFim;
	}


	public void setTxtHoraFim(JTextField txtHoraFim) {
		this.txtHoraFim = txtHoraFim;
	}


	public JComboBox getCboDiaSemana() {
		return cboDiaSemana;
	}


	public void setCboDiaSemana(JComboBox cboDiaSemana) {
		this.cboDiaSemana = cboDiaSemana;
	}
}
