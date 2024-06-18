package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Holter24Controller;
import controller.VisualizaExameController;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class TelaVisualizaExames extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtPaciente;
	private JTextField textField;
	private JTable tblExames;
	private JComboBox cboTipoExame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisualizaExames frame = new TelaVisualizaExames();
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
	public TelaVisualizaExames() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				buscarExame();
			}
		});
		setMaximizable(true);
		getContentPane().setBackground(new Color(227, 227, 227));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Exames", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 912, 85);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(343, 35, 143, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoProfissional = new JLabel("Profissional");
		lblNomeDoProfissional.setBounds(343, 11, 145, 24);
		panel.add(lblNomeDoProfissional);
		lblNomeDoProfissional.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(165, 35, 143, 22);
		panel.add(txtPaciente);
		txtPaciente.setColumns(10);
		
		JLabel lblNomeDoPaciente = new JLabel("Nome do Paciente");
		lblNomeDoPaciente.setBounds(165, 11, 145, 24);
		panel.add(lblNomeDoPaciente);
		lblNomeDoPaciente.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(307, 35, 24, 22);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(TelaVisualizaExames.class.getResource("/icones/procurar.png")));
		
		cboTipoExame = new JComboBox();
		cboTipoExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarExame();
			}
		});
		cboTipoExame.setBounds(10, 35, 143, 22);
		panel.add(cboTipoExame);
		cboTipoExame.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		cboTipoExame.setModel(new DefaultComboBoxModel(new String[] {"Ecocardiograma", "Eletrocardiograma", "Ergometrico", "Holter 24"}));
		
		JLabel lblNewLabel = new JLabel("Tipo de exame:");
		lblNewLabel.setBounds(18, 11, 135, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaVisualizaExames.class.getResource("/icones/procurar.png")));
		lblNewLabel_1_1.setBounds(485, 35, 24, 22);
		panel.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 912, 445);
		getContentPane().add(scrollPane);
		
		tblExames = new JTable();
		tblExames.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		tblExames.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		scrollPane.setViewportView(tblExames);
		
		JButton btnDadosExame = new JButton("Visualizar Exame");
		btnDadosExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizarExame();
			}
		});
		btnDadosExame.setBounds(10, 605, 122, 23);
		getContentPane().add(btnDadosExame);
		
		JButton btnNewButton = new JButton("Atualizar Tabela");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarExame();
			}
		});
		btnNewButton.setBounds(10, 556, 122, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnExcluirExame = new JButton("Excluir Exame");
		btnExcluirExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover este exame?", "Atenção", JOptionPane.YES_NO_OPTION);
				if(confirma==JOptionPane.YES_OPTION) {
					excluirExame();
					buscarExame();
				}	
			}
		});
		btnExcluirExame.setBounds(800, 605, 122, 23);
		getContentPane().add(btnExcluirExame);
		setTitle("Cadastro Holter 24");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 948, 669);

	}
	
	public void buscarExame() {
		VisualizaExameController examesController = new VisualizaExameController();
		System.out.println(cboTipoExame.getSelectedItem().toString());
		ResultSet rs = examesController.selectExames(cboTipoExame.getSelectedItem().toString());
		tblExames.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	
	public void visualizarExame() {
		String exameSelecionado = cboTipoExame.getSelectedItem().toString();
		switch(exameSelecionado) {
			case "Holter 24":
				String idExameSelecionado = tblExames.getModel().getValueAt(tblExames.getSelectedRow(), 0).toString();
				TelaCadastroHolterAtualizar holter24 = new TelaCadastroHolterAtualizar(idExameSelecionado);
				holter24.setVisible(true);
		}
	
	}
	
	
	public void excluirExame() {
		String exameSelecionado = cboTipoExame.getSelectedItem().toString();
		switch(exameSelecionado) {
			case "Holter 24":
				String idExameSelecionado = tblExames.getModel().getValueAt(tblExames.getSelectedRow(), 0).toString();
				Holter24Controller holter = new Holter24Controller();
				holter.excluirHolter24(idExameSelecionado);
		}
	
	}
}
