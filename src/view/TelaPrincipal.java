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
		setBounds(100, 100, 951, 665);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 740, 612);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menCad = new JMenu("Cadastro");
		menuBar.add(menCad);
		
		JMenuItem menCadPac = new JMenuItem("Pacientes");
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
		
		JMenu menOpc = new JMenu("Opções");
		menuBar.add(menOpc);
		
		JMenuItem menOpcSai = new JMenuItem("Sair");
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
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(750, 23, 185, 29);
		contentPane.add(lblUsuario);
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblData.setBounds(750, 63, 142, 29);
		contentPane.add(lblData);
		
		
		
		
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
