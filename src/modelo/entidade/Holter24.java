package modelo.entidade;

import javax.swing.JOptionPane;

public class Holter24 {
	//teste hoter 24
	
	private String paciente, idade, profissional, horarioExame, dataExame, idAgendamento,
	freqMin, freqMed, freqMax, totBat, varRR, extraVentr, extraVentrPar, tacVentri, extraSupra, tacSupra, obsExame;
		
	public Holter24(String paciente, String idade, String profissional, String horarioExame, String dataExame, String idAgendamento,
			String freqMin, String freqMed, String freqMax, String totBat, String varRR, String extraVentr, 
			String extraVentrPar, String tacVentri, String extraSupra, String tacSupra, String obsExame){
		this.paciente = paciente;
		this.idade = idade;
		this.profissional = profissional;
		this.horarioExame = horarioExame;
		this.dataExame = dataExame;
		this.freqMin = freqMin;
		this.freqMed = freqMed;
		this.freqMax = freqMax;
		this.totBat = totBat;
		this.varRR = varRR;
		this.extraVentr = extraVentr;
		this.extraVentrPar =extraVentrPar;
		this.tacVentri = tacVentri;
		this.extraSupra = extraSupra;
		this.tacSupra = tacSupra;
		this.obsExame = obsExame;
		this.idAgendamento = idAgendamento;
	}

	

	public String getPaciente() {
		return paciente;
	}



	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}



	public String getIdade() {
		return idade;
	}



	public void setIdade(String idade) {
		this.idade = idade;
	}



	public String getProfissional() {
		return profissional;
	}



	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}



	public String getHorarioExame() {
		return horarioExame;
	}



	public void setHorarioExame(String horarioExame) {
		this.horarioExame = horarioExame;
	}



	public String getDataExame() {
		return dataExame;
	}



	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}



	public String getIdAgendamento() {
		return idAgendamento;
	}



	public void setIdAgendamento(String idAgendamento) {
		this.idAgendamento = idAgendamento;
	}



	public String getFreqMin() {
		return freqMin;
	}



	public void setFreqMin(String freqMin) {
		this.freqMin = freqMin;
	}



	public String getFreqMed() {
		return freqMed;
	}



	public void setFreqMed(String freqMed) {
		this.freqMed = freqMed;
	}



	public String getFreqMax() {
		return freqMax;
	}



	public void setFreqMax(String freqMax) {
		this.freqMax = freqMax;
	}



	public String getTotBat() {
		return totBat;
	}



	public void setTotBat(String totBat) {
		this.totBat = totBat;
	}



	public String getVarRR() {
		return varRR;
	}



	public void setVarRR(String varRR) {
		this.varRR = varRR;
	}



	public String getExtraVentr() {
		return extraVentr;
	}



	public void setExtraVentr(String extraVentr) {
		this.extraVentr = extraVentr;
	}



	public String getExtraVentrPar() {
		return extraVentrPar;
	}



	public void setExtraVentrPar(String extraVentrPar) {
		this.extraVentrPar = extraVentrPar;
	}



	public String getTacVentri() {
		return tacVentri;
	}



	public void setTacVentri(String tacVentri) {
		this.tacVentri = tacVentri;
	}



	public String getExtraSupra() {
		return extraSupra;
	}



	public void setExtraSupra(String extraSupra) {
		this.extraSupra = extraSupra;
	}



	public String getTacSupra() {
		return tacSupra;
	}



	public void setTacSupra(String tacSupra) {
		this.tacSupra = tacSupra;
	}



	public String getObsExame() {
		return obsExame;
	}



	public void setObsExame(String obsExame) {
		this.obsExame = obsExame;
	}



	@Override
	public String toString() {
		return "Holter24 [paciente=" + paciente + ", idade=" + idade + ", profissional=" + profissional
				+ ", horarioExame=" + horarioExame + ", dataExame=" + dataExame + ", idAgendamento=" + idAgendamento
				+ ", freqMin=" + freqMin + ", freqMed=" + freqMed + ", freqMax=" + freqMax + ", totBat=" + totBat
				+ ", varRR=" + varRR + ", extraVentr=" + extraVentr + ", extraVentrPar=" + extraVentrPar
				+ ", tacVentri=" + tacVentri + ", extraSupra=" + extraSupra + ", tacSupra=" + tacSupra + ", obsExame="
				+ obsExame + "]";
	}
	
	
	
	
}
