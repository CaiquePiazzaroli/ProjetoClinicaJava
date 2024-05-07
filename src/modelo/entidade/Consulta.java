package modelo.entidade;

import javax.swing.JOptionPane;

public class Consulta {
	
	Usuario usuarioCriou;
	Paciente paciente;
	Profissional profissional;
	String data;

	
	
	Consulta(Usuario usuario, Paciente paciente, Profissional profissional){
		this.usuarioCriou = usuario;
		this.paciente = paciente;
		this.profissional = profissional;
	}
	
		
	//Este método verifica qual é o exame selecionado pelo usuário do sistema
	public String verificaExame() {
		Object[] itens = { "Holter", "Eletrocardio", "Ecocardio", "Ergométrico"};
		Object valorSelecionado = JOptionPane.showInputDialog(null, "Escolha um exame", "Exames", JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);
		String resultadoExame;
		if(valorSelecionado == "Holter") {
			//exibe tela holter
			Holter24 holter = new Holter24();
			resultadoExame = holter.calculaBatimentos();
			return resultadoExame;
		} else if (valorSelecionado == "Eletrocardio"){
			//exibe tela eletrocardio
			Eletrocardio eletro = new Eletrocardio();
			resultadoExame = eletro.calculaPressao();
			return resultadoExame;
		} else if(valorSelecionado == "Ecocardio") {
			//exibe tela eletrocardio
			return "nada";
		} else if(valorSelecionado == "Ecocardio") {
			return "nada";
		} else {
			return "Nada foi selecionado";
		}
	}
	

	@Override
	public String toString() {
		return "Consulta xxxxx\n" + "Paciente: " + paciente.getNomePaciente() + "\nProfissional Responsável: " + profissional.nome + "\nResultado:" + verificaExame();
	}
	
	
	
	
}
