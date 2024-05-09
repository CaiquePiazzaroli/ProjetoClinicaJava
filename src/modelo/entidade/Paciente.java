package modelo.entidade;
import java.util.Date;

import modelo.entidade.*;

import java.time.*;

public class Paciente {
	
	private String nomePaciente, rg, numeroTelefone, sexo, cel, peso, altura, convenio, dataNascimento;
	
	public Paciente(String nomePaciente, String rg, String numeroTelefone, String cel, String dataNascimento, String sexo, String peso, String altura, String convenio) {
		this.nomePaciente = nomePaciente;
		this.rg = rg;
		this.numeroTelefone = numeroTelefone;
		this.cel = cel;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		this.convenio = convenio;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	
}
