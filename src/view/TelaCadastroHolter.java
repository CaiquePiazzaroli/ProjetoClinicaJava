package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class TelaCadastroHolter extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroHolter frame = new TelaCadastroHolter();
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
	public TelaCadastroHolter() {
		setMaximizable(true);
		getContentPane().setBackground(new Color(227, 227, 227));
		setTitle("Cadastro Holter 24");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(0, 0, 948, 669);
		getContentPane().setLayout(null);

	}

}
