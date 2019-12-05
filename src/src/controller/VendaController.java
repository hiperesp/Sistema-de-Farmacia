package controller;

import model.Venda;

public class VendaController {
	public static boolean insert(Venda venda) {
		return dao.VendaDao.insert(venda.getCliente(), venda.getProduto(), venda.getQuantidade(), venda.getValorTotal());
	}
	public static String[][] select() {
		return dao.VendaDao.select();
	}
	public static String getCliente(int id) {
		return dao.ClienteDao.getClienteNome(id);
	}
	public static String getProduto(int id) {
		return dao.ProdutoDao.getProdutoNome(id);
	}
	public static float getValorProduto(int id) {
		return dao.ProdutoDao.getValorProduto(id);
	}
}
