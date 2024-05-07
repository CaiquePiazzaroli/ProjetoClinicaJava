package modelo.entidade;

import javax.swing.JOptionPane;

public class Eletrocardio {
	
	
	

	public String calculaPressao() {
		int pressaoSanguinea = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor da pressao sanguínea:"));
		if(pressaoSanguinea > 100) {
			 return "Ta muito alto meu filho";
		}else {
			return "Ta sussa";
		}
	}
	
	
	
}
