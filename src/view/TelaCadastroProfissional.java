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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProfissional frame = new TelaCadastroProfissional();
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
		setBounds(0, 0, 740, 612);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("idProfissional");
		lblNewLabel.setBounds(421, 76, 72, 14);
		getContentPane().add(lblNewLabel);
		
		txtIdProf = new JTextField();
		txtIdProf.setBounds(420, 101, 86, 20);
		getContentPane().add(txtIdProf);
		txtIdProf.setEnabled(false);
		txtIdProf.setEditable(false);
		txtIdProf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Profissional");
		lblNewLabel_1.setBounds(421, 137, 99, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtNomeProf = new JTextField();
		txtNomeProf.setBounds(421, 162, 293, 20);
		getContentPane().add(txtNomeProf);
		txtNomeProf.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 401, 191);
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
		lblNewLabel_2.setBounds(10, 244, 159, 14);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 269, 293, 185);
		getContentPane().add(scrollPane_1);
		
		tblEspecProf = new JTable();
		tblEspecProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExcluirEspec.setEnabled(true);
				
			}
		});
		tblEspecProf.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblEspecProf.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Especialidades"
			}
		));
		scrollPane_1.setViewportView(tblEspecProf);
		
		JButton btnAdicionarEspec = new JButton("Adicionar");
		btnAdicionarEspec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o método adicionar especialiadade
				 adicionarEspecialidade();
			}
		});
		btnAdicionarEspec.setBounds(10, 460, 86, 20);
		getContentPane().add(btnAdicionarEspec);
		
		btnIncluirProf = new JButton("Incluir Profissional");
		btnIncluirProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o método de criar profissional
				criarProfissional();
			}
		});
		btnIncluirProf.setBounds(10, 548, 119, 23);
		getContentPane().add(btnIncluirProf);
		
		btnAtualizarProf = new JButton("Atualizar Profissional");
		btnAtualizarProf.setEnabled(false);
		btnAtualizarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o metodo atualizar profissional
				atualizarProfissional();
			}
		});
		btnAtualizarProf.setBounds(267, 548, 159, 23);
		getContentPane().add(btnAtualizarProf);
		
		btnExcluirProf = new JButton("Excluir Profissional");
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
		btnExcluirProf.setBounds(575, 548, 139, 23);
		getContentPane().add(btnExcluirProf);
		
		JLabel lblNewLabel_3 = new JLabel("Campos Obrigatórios *");
		lblNewLabel_3.setBounds(561, 109, 111, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtPesquisarProf = new JTextField();
		txtPesquisarProf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//Chamando o método pesquisar profissional
				pesquisarProfissional();
			}
		});
		txtPesquisarProf.setBounds(10, 11, 250, 20);
		getContentPane().add(txtPesquisarProf);
		txtPesquisarProf.setColumns(10);
		
		btnExcluirEspec = new JButton("Excluir");
		btnExcluirEspec.setEnabled(false);
		btnExcluirEspec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o método excluir espec
				excluirEspecialidade();
			}
		});
		btnExcluirEspec.setBounds(98, 460, 86, 20);
		getContentPane().add(btnExcluirEspec);
	} 
	
	public void setarCampos() {
		//Pega a linha que está selecionada
		int setar = tblProfissionais.getSelectedRow();
		txtIdProf.setText(tblProfissionais.getModel().getValueAt(setar, 0).toString());
		txtNomeProf.setText(tblProfissionais.getModel().getValueAt(setar, 1).toString());
		btnAtualizarProf.setEnabled(true);
		btnExcluirProf.setEnabled(true);
		btnIncluirProf.setEnabled(false);
		pesquisarEspecialidade();

	}
	
	public void limparCampos(){
		txtIdProf.setText(null);
		txtNomeProf.setText(null);
		tblEspecProf.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Especialidades"
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
	
	private void pesquisarEspecialidade() {
		ProfissionalController profissionalController = new ProfissionalController();
		ResultSet rs = profissionalController.pesquisaEspecialidadeProfissional(TelaCadastroProfissional.this);
		tblEspecProf.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	private void adicionarEspecialidade() {
		Object[] exames = { "Ecocardiograma", "Eletrocardiograma", "Ergométrico", "Holter24"};
	      Object exameSelecionado = JOptionPane.showInputDialog(null,"Escolha um exame", "Opção", JOptionPane.INFORMATION_MESSAGE, null, exames, exames [0]);
	      ProfissionalController profissionalController = new ProfissionalController();
	      if(exameSelecionado != null) {
	    	  profissionalController.salvarEspecialidade(txtIdProf.getText(), exameSelecionado.toString());
	      }  
	      pesquisarEspecialidade();
	      btnExcluirEspec.setEnabled(false);
	}
	
	private void excluirEspecialidade() {
		int setar = tblEspecProf.getSelectedRow();
		String especialidade = tblEspecProf.getModel().getValueAt(setar, 0).toString();
		String idProf = txtIdProf.getText();
		ProfissionalController profissionalController = new ProfissionalController();
		profissionalController.excluirEspecialidade(idProf, especialidade);
		pesquisarEspecialidade();
		btnExcluirEspec.setEnabled(false);
		
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
}
