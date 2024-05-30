package modelo.dao;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;

public class ProfissionalDao {
	//Instanciando o módulo de conexao com o banco
	Conexao moduloConexao = new Conexao();
		
	//Recebendo a conexao com banco
	Connection conexao = moduloConexao.conector();
		
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	
	
	public ResultSet selectProfissionais(JTextField campoPesquisa) {
		//Query que será executada no banco de dados
		String sql= "select * from profissionais where nomeProfissional like ?";
		try {
			pst = conexao.prepareStatement(sql);
			
			pst.setString(1, campoPesquisa.getText() + "%");
			rs = pst.executeQuery();
			
			//Retornando o RS
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	
	public ResultSet selectEspecialidades(JTextField campoId) {
		//Query que será executada no banco de dados
		String sql= "select nomeEspecialidade as Especialidade from especialidadeProfissional where idProfissional = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, campoId.getText());
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	
	public void createProfissional(String nomeProfissional) {
		String sql = "insert into profissionais (nomeProfissional) values (?)";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeProfissional);
			if(nomeProfissional.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Insira os campos obrigatórios!");
			} else {
				int	adicionado = pst.executeUpdate();
				if(adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Profissional cadastrado com sucesso!");
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void updateProfissional(String idProfissional, String nomeProf) {
		String sql= "update profissionais set nomeProfissional = ? where idProfissional = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, nomeProf);
			pst.setString(2, idProfissional);
			int alterado = pst.executeUpdate();
			if(alterado > 0) {
				JOptionPane.showMessageDialog(null, "Profissional alterado com sucesso!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void deleteProfissional(String idProf) {
		String sql= "delete from profissionais where idProfissional = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, idProf);
			int alterado = pst.executeUpdate();
			if(alterado > 0) {
				JOptionPane.showMessageDialog(null, "Profissional excluido com sucesso!");
			}
		} catch (Exception e) {
			int confirma = JOptionPane.showConfirmDialog(null,"Existem especialidades vinculadas a este profissional, você deseja excluí-las?", "Atenção", JOptionPane.YES_NO_OPTION);
			if(confirma==JOptionPane.YES_OPTION) {
				String sqlDelEspec = "delete from especialidadeProfissional where idProfissional = ?";
				String sqlDelhora = "delete from horarioProfissional where idProfissional = ?";
				try {
					PreparedStatement pst2;
					PreparedStatement pst3;
					pst2 = conexao.prepareStatement(sqlDelEspec);
					pst2.setString(1, idProf);
					
					pst3 = conexao.prepareStatement(sqlDelhora);
					pst3.setString(1, idProf);
					int alteradoEspec = pst2.executeUpdate();
					int alteradoHora = pst3.executeUpdate();
					if(alteradoEspec < 0 && alteradoHora > 0) {
						JOptionPane.showMessageDialog(null, "Não foi possivel excluir!");
					} else {
						int alterado = pst.executeUpdate();
						if(alterado > 0) {
							JOptionPane.showMessageDialog(null, "Profissional excluido com sucesso!");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		}
	}
	
	
	public void createEspecialidade(String idprof, String espec) {
		String sql= "insert into especialidadeProfissional(idProfissional,nomeEspecialidade) values(?,?)";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, idprof);
			pst.setString(2, espec);
			pst.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Um profissional não pode conter duas especialidade iguais!");
		}
	}
	
	public void deleteEspecialidade(String idProf,String espec) {
		String sql= "delete from especialidadeProfissional where idprofissional = ? and nomeEspecialidade = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, idProf);
			pst.setString(2, espec);
			pst.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	
	public ResultSet createHorario(String idProf) {
		String sql= "select diaSemana as 'Dia da Semana', horaInicio as 'Início', horaFim as 'Fim' from horarioProfissional where idProfissional = ?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1, idProf);
			rs = pst.executeQuery();
			return rs;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	
}
