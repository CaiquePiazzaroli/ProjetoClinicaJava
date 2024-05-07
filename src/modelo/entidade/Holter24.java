package modelo.entidade;

import javax.swing.JOptionPane;

public class Holter24 {
	//teste hoter 24
	
	String resultado;
		
	Holter24(){
		
	}
	
	
	public String calculaBatimentos() {
		int batimentos = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor em BPM dos batimentos"));
		if(batimentos > 90) {
			 return "Vai morrer";
		}else {
			return "Ta normal manin";
		}
	}
	
	
	
	
	
}
