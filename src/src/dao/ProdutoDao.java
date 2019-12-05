package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDao {
	public static String[][] select() {
		String[][] resposta = new String[][] {};
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `idProdutos`, `nomeProdutos`, `descricaoProdutos`, `valorProduto` FROM `tbprodutos`");
			ResultSet resultSet = ps.executeQuery();
			resultSet.last();
			resposta = new String[resultSet.getRow()][];
			if(resposta.length>0) {
				do {
					resposta[resultSet.getRow()-1] = new String[] {
							resultSet.getString("idProdutos"),
							resultSet.getString("nomeProdutos"),
							resultSet.getString("descricaoProdutos"),
							resultSet.getString("valorProduto"),
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
	public static String getProdutoNome(int id) {
		String resposta = null;
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `nomeProdutos` FROM `tbprodutos` WHERE `idProdutos`=?");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				resposta = resultSet.getString("nomeProdutos");
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resposta;
	}
	public static float getValorProduto(int id) {
		float resposta = 0;
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `valorProduto` FROM `tbprodutos` WHERE `idProdutos`=?");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				resposta = resultSet.getFloat("valorProduto");
			}
			resultSet.close();
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return resposta;
	}
	public static boolean insert(String nomeProduto, String descricaoProduto, float valorProduto) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `tbprodutos` (`idProdutos`, `nomeProdutos`, `descricaoProdutos`, `valorProduto`)"
					+ " VALUES (NULL, ?, ?, ?)");
			ps.setString(1, nomeProduto);
			ps.setString(2, descricaoProduto);
			ps.setFloat(3, valorProduto);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public static boolean delete(int codProduto) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `tbprodutos` WHERE `idProdutos` = ?");
			ps.setInt(1, codProduto);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	public static boolean update(int codProduto, String nomeProduto, String descricaoProduto, float valorProduto) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE `tbprodutos` SET `nomeProdutos`=?, `descricaoProdutos`=?, `valorProduto`=? WHERE `idProdutos` = ?");
			ps.setString(1, nomeProduto);
			ps.setString(2, descricaoProduto);
			ps.setFloat(3, valorProduto);
			ps.setInt(4, codProduto);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}
