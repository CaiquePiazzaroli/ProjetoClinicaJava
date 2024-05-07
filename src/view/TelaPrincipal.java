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
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	private JLabel lblUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icones/coracao25.png")));
		setTitle("AMAR - Tela Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 768);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menCad = new JMenu("Cadastro");
		menuBar.add(menCad);
		
		JMenuItem menCadPac = new JMenuItem("Pacientes");
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 931, 707);
		contentPane.add(desktopPane);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUsuario.setBounds(941, 23, 298, 29);
		contentPane.add(lblUsuario);
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblData.setBounds(941, 63, 233, 29);
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
