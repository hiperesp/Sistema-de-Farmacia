package controller;

import model.Cliente;

public class ClienteController {
	public static boolean insert(Cliente cliente) {
		return dao.ClienteDao.insert(cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getLogradouro(), cliente.getNumero(), cliente.getComplemento(), cliente.getBairro(), cliente.getMunicipio(), cliente.getCep(), cliente.getEstado());
	}
	public static String[][] select() {
		return dao.ClienteDao.select();
	}
	public static boolean delete(Cliente cliente) {
		return dao.ClienteDao.delete(cliente.getId());
	}
	public static boolean update(Cliente cliente) {
		return dao.ClienteDao.update(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getLogradouro(), cliente.getNumero(), cliente.getComplemento(), cliente.getBairro(), cliente.getMunicipio(), cliente.getCep(), cliente.getEstado());
	}
}
