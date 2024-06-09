package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.TelaCadastroPaciente;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	private JLabel lblUsuario;

	//Construtor da dela principal
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icones/coracao25.png")));
		setTitle("AMAR - Tela Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 737);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(67, 67, 67));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(227, 227, 227));
		desktopPane.setBounds(248, -2, 948, 671);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		menuBar.setBackground(new Color(128, 0, 64));
		setJMenuBar(menuBar);
		
		JMenu menCad = new JMenu("Cadastro");
		menCad.setBackground(new Color(227, 227, 227));
		menCad.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		menuBar.add(menCad);
		
		JMenuItem menCadPac = new JMenuItem("Pacientes");
		menCadPac.setBackground(new Color(227, 227, 227));
		menCadPac.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		menCadPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//chamando o formulário de cadastro de pacientes
			TelaCadastroPaciente telaCadastroPaciente;
			try {
				telaCadastroPaciente = new TelaCadastroPaciente();
				telaCadastroPaciente.setVisible(true);
				desktopPane.add(telaCadastroPaciente);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		menCadPac.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		menCad.add(menCadPac);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Profissionais");
		mntmNewMenuItem.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProfissional telaProfissional = new TelaCadastroProfissional();
				telaProfissional.setVisible(true);
				desktopPane.add(telaProfissional);
			}
		});
		menCad.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Holter 24");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroHolter telaHolter = new TelaCadastroHolter();
				telaHolter.setVisible(true);
				desktopPane.add(telaHolter);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		menCad.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Consultas");
		mnNewMenu.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agenda de exames");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAgendaExames agendaExames = new TelaAgendaExames();
				agendaExames.setVisible(true);
				desktopPane.add(agendaExames);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu menOpc = new JMenu("Opções");
		menOpc.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		menuBar.add(menOpc);
		
		JMenuItem menOpcSai = new JMenuItem("Sair");
		menOpcSai.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		menOpcSai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exibe uma caixa de dialogo
				int sair = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION) {
					//Encerra o sistema
					System.exit(0);
				}
			}
		});
		menOpc.add(menOpcSai);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblUsuario.setBounds(24, 89, 184, 40);
		contentPane.add(lblUsuario);
		
		lblData = new JLabel("Data");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblData.setBounds(24, 140, 153, 29);
		contentPane.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Divisória.png")));
		lblNewLabel.setBounds(240, 34, 4, 606);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/Clinic Soft120xwhite.png")));
		lblNewLabel_1.setBounds(49, 32, 128, 46);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		//Evento executado quando a tela é iniciada
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				//formatando a data com o Date Format
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
				lblData.setText(formatador.format(data));
			}
		});
		
		
	}


	public JLabel getLblUsuario() {
		return lblUsuario;
	}	
}
