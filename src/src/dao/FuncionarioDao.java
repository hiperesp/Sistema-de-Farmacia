package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDao {
	public static String senhaOculta = "Senha Oculta";
	public static String[][] select() {
		String[][] resposta = new String[][] {};
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `idFuncionario`, `nomeFuncionario`, `senha`, `cpfFuncionario`, `rgFuncionario`, `contaBancoFuncionario`, `agenciaFuncionario`, `nomeBancoFuncionario`"
//					+ ", `logradouroFuncionario`, `numFuncionario`, `complFuncionario`, `bairroFuncionario`, `cidadeFuncionario`, `cepFuncionario`, `ufFuncionario`"
					+ " FROM `tbfuncionario`");
			ResultSet resultSet = ps.executeQuery();
			resultSet.last();
			resposta = new String[resultSet.getRow()][];
			if(resposta.length>0) {
				do {
					resposta[resultSet.getRow()-1] = new String[] {
							resultSet.getString("idFuncionario"),
							resultSet.getString("nomeFuncionario"),
							new String(senhaOculta),
							resultSet.getString("cpfFuncionario"),
							resultSet.getString("rgFuncionario"),
							resultSet.getString("contaBancoFuncionario"),
							resultSet.getString("agenciaFuncionario"),
							resultSet.getString("nomeBancoFuncionario"),
							/*resultSet.getString("logradouroFuncionario"),
							resultSet.getString("numFuncionario"),
							resultSet.getString("complFuncionario"),
							resultSet.getString("bairroFuncionario"),
							resultSet.getString("cidadeFuncionario"),
							resultSet.getString("cepFuncionario"),
							resultSet.getString("ufFuncionario")*/
					};
				} while(resultSet.previous());
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resposta;
	}
	public static boolean login(int id, String senha) {
		boolean resposta = false;
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `idFuncionario` FROM `tbfuncionario` WHERE `idFuncionario`=? AND `senha`=?");
			ps.setInt(1, id);
			ps.setString(2, senha);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				resposta = true;
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resposta;

	}
	public static boolean insert(String nome, String cpf, String rg, String contaBanco, String agenciaBanco, String nomeBanco, String senha/*, String logradouro, int numero, String complemento, String bairro, String cidade, String cep, String uf*/) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `tbfuncionario` (`idFuncionario`, `nomeFuncionario`, `cpfFuncionario`, `rgFuncionario`, `contaBancoFuncionario`, `agenciaFuncionario`, `nomeBancoFuncionario`, `senha`"
					//+ ", `logradouroFuncionario`, `numFuncionario`, `complFuncionario`, `bairroFuncionario`, `cidadeFuncionario`, `cepFuncionario`, `ufFuncionario`"
					+ ") VALUES (NULL, ?, ?, ?, ?, ?, ?, ?"
					//+ ", ?, ?, ?, ?, ?, ?, ?"
					+ ")");
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setString(3, rg);
			ps.setString(4, contaBanco);
			ps.setString(5, agenciaBanco);
			ps.setString(6, nomeBanco);
			ps.setString(7, senha);
			/*ps.setString(7, logradouro);
			ps.setInt(8, numero);
			ps.setString(9, complemento);
			ps.setString(10, bairro);
			ps.setString(11, cidade);
			ps.setString(12, cep);
			ps.setString(13, uf);*/
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public static boolean delete(int cod) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `tbfuncionario` WHERE `idFuncionario` = ?");
			ps.setInt(1, cod);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public static boolean update(int codFuncionario, String nome, String cpf, String rg, String contaBanco, String agenciaBanco, String nomeBanco, String senha/*, String logradouro, int numero, String complemento, String bairro, String cidade, String cep, String uf*/) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE `tbfuncionario` SET `nomeFuncionario` = ?, `cpfFuncionario` = ?, "
					+ "`rgFuncionario` = ?, `contaBancoFuncionario` = ?, `agenciaFuncionario` = ?, `nomeBancoFuncionario` = ? "
					//+ ", `logradouroFuncionario` = ?, `numFuncionario` = ?, `complFuncionario` = ?, `bairroFuncionario` = ?, "
					//+ "`cidadeFuncionario` = ?, `cepFuncionario` = ?, `ufFuncionario` = ?"
					+ "WHERE `idFuncionario` = ?");
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setString(3, rg);
			ps.setString(4, contaBanco);
			ps.setString(5, agenciaBanco);
			ps.setString(6, nomeBanco);
			/*ps.setString(7, logradouro);
			ps.setInt(8, numero);
			ps.setString(9, complemento);
			ps.setString(10, bairro);
			ps.setString(11, cidade);
			ps.setString(12, cep);
			ps.setString(13, uf);*/
			ps.setInt(7, codFuncionario);
			ps.execute();
			if(!senha.equals(senhaOcultaMd5()) ) {
				PreparedStatement ps2 = connection.prepareStatement("UPDATE `tbfuncionario` SET `senha` = ? WHERE `idFuncionario` = ?");
				ps2.setString(1, senha);
				ps2.setInt(2, codFuncionario);
				ps2.execute();
			}
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public static String senhaOcultaMd5() {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
	        m.update(senhaOculta.getBytes(),0,senhaOculta.length());
	        return new BigInteger(1,m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return senhaOculta;
		}
	}
}
