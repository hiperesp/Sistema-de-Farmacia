package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDao {
	public static String[][] select() {
		String[][] resposta = new String[][] {};
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT `codigoVenda`, `nomeCliente`, `nomeProdutos`, `quantidadeVenda`, `valorTotalVenda` FROM `tbvenda` INNER JOIN `tbcliente` ON `clienteVenda`=`idCliente` INNER JOIN `tbprodutos` ON `produtoVenda`=`idProdutos`");
			ResultSet resultSet = ps.executeQuery();
			resultSet.last();
			resposta = new String[resultSet.getRow()][];
			if(resposta.length>0) {
				do {
					resposta[resultSet.getRow()-1] = new String[] {
							resultSet.getString("codigoVenda"),
							resultSet.getString("nomeCliente"),
							resultSet.getString("nomeProdutos"),
							resultSet.getString("quantidadeVenda"),
							resultSet.getString("valorTotalVenda"),
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
	public static boolean insert(int cliente, int produto, int quantidade, float valorProduto) {
		try {
			Connection connection = dao.Connection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `tbvenda` (`codigoVenda`, `clienteVenda`, `produtoVenda`, `quantidadeVenda`, `valorTotalVenda`)"
					+ "VALUES (NULL, ?, ?, ?, ?)");
			ps.setInt(1, cliente);
			ps.setInt(2, produto);
			ps.setInt(3, quantidade);
			ps.setFloat(4, valorProduto);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}
