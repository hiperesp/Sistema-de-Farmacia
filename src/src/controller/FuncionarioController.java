package controller;

import model.Funcionario;

public class FuncionarioController {
	public static boolean insert(Funcionario funcionario) {
		return dao.FuncionarioDao.insert(funcionario.getNomeFuncionario(), funcionario.getCpfFuncionario(), funcionario.getRgFuncionario(), funcionario.getContaBancoFuncionario(), funcionario.getAgenciaFuncionario(), funcionario.getNomeBancoFuncionario(), funcionario.getSenhaFuncionario()/*funcionario.getLogradouroFuncionario(), funcionario.getNumFuncionario(), funcionario.getComplFuncionario(), funcionario.getBairroFuncionario(), funcionario.getCidadeFuncionario(), funcionario.getCepFuncionario(), funcionario.getUfFuncionario()*/);
	}
	public static String[][] select() {
		return dao.FuncionarioDao.select();
	}
	public static boolean delete(Funcionario funcionario) {
		return dao.FuncionarioDao.delete(funcionario.getIdFuncionario());
	}
	public static boolean update(Funcionario funcionario) {
		return dao.FuncionarioDao.update(funcionario.getIdFuncionario(), funcionario.getNomeFuncionario(), funcionario.getCpfFuncionario(), funcionario.getRgFuncionario(), funcionario.getContaBancoFuncionario(), funcionario.getAgenciaFuncionario(), funcionario.getNomeBancoFuncionario(), funcionario.getSenhaFuncionario()/*funcionario.getLogradouroFuncionario(), funcionario.getNumFuncionario(), funcionario.getComplFuncionario(), funcionario.getBairroFuncionario(), funcionario.getCidadeFuncionario(), funcionario.getCepFuncionario(), funcionario.getUfFuncionario()*/);
	}
	public static boolean login(Funcionario funcionario) {
		return dao.FuncionarioDao.login(funcionario.getIdFuncionario(), funcionario.getSenhaFuncionario());
	}
}
