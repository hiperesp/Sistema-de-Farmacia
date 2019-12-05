package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
	public static String[][] select() {
		String[][] resposta = new String[][] {};
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `idCliente`, `nomeCliente`, `cpfCliente`, `rgCliente`, `logradouroCliente`, `numCliente`, `complCliente`, `bairroCliente`, `cidadeCliente`, `cepCliente`, `ufCliente` FROM `tbcliente`");
			ResultSet resultSet = ps.executeQuery();
			resultSet.last();
			resposta = new String[resultSet.getRow()][];
			if(resposta.length>0) {
				do {
					resposta[resultSet.getRow()-1] = new String[] {
							resultSet.getString("idCliente"),
							resultSet.getString("nomeCliente"),
							resultSet.getString("cpfCliente"),
							resultSet.getString("rgCliente"),
							resultSet.getString("logradouroCliente"),
							resultSet.getString("numCliente"),
							resultSet.getString("complCliente"),
							resultSet.getString("bairroCliente"),
							resultSet.getString("cidadeCliente"),
							resultSet.getString("cepCliente"),
							resultSet.getString("ufCliente"),
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
	public static String getClienteNome(int id) {
		String resposta = null;
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `nomeCliente` FROM `tbcliente` WHERE `idCliente`=?");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				resposta = resultSet.getString("nomeCliente");
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resposta;
	}
	public static boolean insert(String nomeCliente, String cpfCliente, String rgCliente, String logradouroCliente, String numCliente, String complCliente, String bairroCliente, String cidadeCliente, String cepCliente, String ufCliente) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `tbcliente` (`idCliente`, `nomeCliente`, `cpfCliente`, `rgCliente`, `logradouroCliente`, `numCliente`, `complCliente`, `bairroCliente`, `cidadeCliente`, `cepCliente`, `ufCliente`)"
					+ " VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, nomeCliente);
			ps.setString(2, cpfCliente);
			ps.setString(3, rgCliente);
			ps.setString(4, logradouroCliente);
			ps.setString(5, numCliente);
			ps.setString(6, complCliente);
			ps.setString(7, bairroCliente);
			ps.setString(8, cidadeCliente);
			ps.setString(9, cepCliente);
			ps.setString(10, ufCliente);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public static boolean delete(int codCliente) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `tbcliente` WHERE `idCliente` = ?");
			ps.setInt(1, codCliente);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public static boolean update(int codCliente, String nomeCliente, String cpfCliente, String rgCliente, String logradouroCliente, String numCliente, String complCliente, String bairroCliente, String cidadeCliente, String cepCliente, String ufCliente) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE `tbcliente` SET `nomeCliente`=?, `cpfCliente`=?, `rgCliente`=?, `logradouroCliente`=?, `numCliente`=?, `complCliente`=?, `bairroCliente`=?, `cidadeCliente`=?, `cepCliente`=?, `ufCliente`=? WHERE `idCliente` = ?");
			ps.setString(1, nomeCliente);
			ps.setString(2, cpfCliente);
			ps.setString(3, rgCliente);
			ps.setString(4, logradouroCliente);
			ps.setString(5, numCliente);
			ps.setString(6, complCliente);
			ps.setString(7, bairroCliente);
			ps.setString(8, cidadeCliente);
			ps.setString(9, cepCliente);
			ps.setString(10, ufCliente);
			ps.setInt(11, codCliente);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}
