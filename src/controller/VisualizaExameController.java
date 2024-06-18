package controller;

import java.sql.ResultSet;

import modelo.dao.VisualizaExameDao;

public class VisualizaExameController {

	public ResultSet selectExames(String tipoExame) {
		VisualizaExameDao  exameDao = new VisualizaExameDao ();
		ResultSet rs = null;
		if(tipoExame.equals("Ecocardiograma")) {
			rs = exameDao.selectExameEco(tipoExame);
		} else if(tipoExame.equals("Eletrocardiograma")) {
			rs = exameDao.selectExameEletro(tipoExame);
		} else if(tipoExame.equals("Ergometrico")) {
			rs = exameDao.selectExameErgo(tipoExame);
		} else if(tipoExame.equals("Holter 24")) {
			rs = exameDao.selectExameHolter(tipoExame);
		}

		return rs;
	}
	
	
	
}
