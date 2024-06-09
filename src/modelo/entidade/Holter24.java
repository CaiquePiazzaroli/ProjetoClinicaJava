package modelo.entidade;

import javax.swing.JOptionPane;

public class Holter24 {
	//teste hoter 24
	
	private String freqMin, freqMed, freqMax, totBat, varRR, extraVentr, extraVentrPar, tacVentri, extraSupra, tacSupra;
		
	public Holter24(String freqMin, String freqMed, String freqMax, String totBat, String varRR, String extraVentr, String extraVentrPar, String tacVentri, String extraSupra, String tacSupra){
		this.freqMin = freqMin;
		this.freqMed = freqMed;
		this.freqMax = freqMax;
		this.totBat = totBat;
		this.varRR = varRR;
		this.extraVentr = extraVentrPar;
		this.tacVentri = tacVentri;
		this.extraSupra = extraSupra;
		this.tacSupra = tacSupra;
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
	
}
