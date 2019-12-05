package model;

public class Venda {
	private int cliente;
	private int produto;
	private int quantidade;
	private float valorTotal;
	
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valor) {
		this.valorTotal = valor;
	}
}
