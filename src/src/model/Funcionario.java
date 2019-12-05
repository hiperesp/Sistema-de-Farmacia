package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Funcionario {
	private int idFuncionario;
	private String nomeFuncionario;
	private String cpfFuncionario;
	private String loginFuncionario;
	private String senhaFuncionario;
	private String rgFuncionario;
	private String contaBancoFuncionario;
	private String agenciaFuncionario;
	private String nomeBancoFuncionario;
	private String logradouroFuncionario;
	private int numFuncionario;
	private String complFuncionario;
	private String bairroFuncionario;
	private String cidadeFuncionario;
	private String cepFuncionario;
	private String ufFuncionario;
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public String getCpfFuncionario() {
		return cpfFuncionario;
	}
	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}
	public String getRgFuncionario() {
		return rgFuncionario;
	}
	public void setRgFuncionario(String rgFuncionario) {
		this.rgFuncionario = rgFuncionario;
	}
	public String getContaBancoFuncionario() {
		return contaBancoFuncionario;
	}
	public void setContaBancoFuncionario(String contaBancoFuncionario) {
		this.contaBancoFuncionario = contaBancoFuncionario;
	}
	public String getAgenciaFuncionario() {
		return agenciaFuncionario;
	}
	public void setAgenciaFuncionario(String agenciaFuncionario) {
		this.agenciaFuncionario = agenciaFuncionario;
	}
	public String getNomeBancoFuncionario() {
		return nomeBancoFuncionario;
	}
	public void setNomeBancoFuncionario(String nomeBancoFuncionario) {
		this.nomeBancoFuncionario = nomeBancoFuncionario;
	}
	public String getLogradouroFuncionario() {
		return logradouroFuncionario;
	}
	public void setLogradouroFuncionario(String logradouroFuncionario) {
		this.logradouroFuncionario = logradouroFuncionario;
	}
	public int getNumFuncionario() {
		return numFuncionario;
	}
	public void setNumFuncionario(int numFuncionario) {
		this.numFuncionario = numFuncionario;
	}
	public String getComplFuncionario() {
		return complFuncionario;
	}
	public void setComplFuncionario(String complFuncionario) {
		this.complFuncionario = complFuncionario;
	}
	public String getBairroFuncionario() {
		return bairroFuncionario;
	}
	public void setBairroFuncionario(String bairroFuncionario) {
		this.bairroFuncionario = bairroFuncionario;
	}
	public String getCidadeFuncionario() {
		return cidadeFuncionario;
	}
	public void setCidadeFuncionario(String cidadeFuncionario) {
		this.cidadeFuncionario = cidadeFuncionario;
	}
	public String getCepFuncionario() {
		return cepFuncionario;
	}
	public void setCepFuncionario(String cepFuncionario) {
		this.cepFuncionario = cepFuncionario;
	}
	public String getUfFuncionario() {
		return ufFuncionario;
	}
	public void setUfFuncionario(String ufFuncionario) {
		this.ufFuncionario = ufFuncionario;
	}
	public void setLoginFuncionario(String loginFuncionario) {
		this.loginFuncionario = loginFuncionario;
	}
	public String getLoginFuncionario() {
		return this.loginFuncionario;
	}
	public void setSenhaFuncionario(String senhaFuncionario) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
	        m.update(senhaFuncionario.getBytes(),0,senhaFuncionario.length());
	        String novaSenha = new BigInteger(1,m.digest()).toString(16);
			this.senhaFuncionario = novaSenha;
		} catch (NoSuchAlgorithmException e) {
			this.senhaFuncionario = "hiperesp123";
			e.printStackTrace();
		}
	}
	public String getSenhaFuncionario() {
		return this.senhaFuncionario;
	}
}
