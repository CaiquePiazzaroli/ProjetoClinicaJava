package modelo.entidade;

public class Paciente {
	
	String nome, cpf, rg, numeroTelefone, dataNascimento;

	
	Paciente(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
