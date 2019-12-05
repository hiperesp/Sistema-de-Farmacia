package controller;

import model.Produto;

public class ProdutoController {
	public static boolean insert(Produto produto) {
		return dao.ProdutoDao.insert(produto.getNome(), produto.getDescricao(), produto.getValor());
	}
	public static String[][] select() {
		return dao.ProdutoDao.select();
	}
	public static boolean delete(Produto produto) {
		return dao.ProdutoDao.delete(produto.getId());
	}
	public static boolean update(Produto produto) {
		return dao.ProdutoDao.update(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor());
	}
}
