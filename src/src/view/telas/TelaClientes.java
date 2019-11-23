package view.telas;

import view.util.Tela;

public class TelaClientes extends Tela {

	private static final long serialVersionUID = -6432091958862873077L;
	
	int width;
	
	public TelaClientes(int width) {
		super(width);
	}
	public void addAnonymousElements() {
		int x = 32;
		int y = 0;
		addTitle("Clientes", x, y+=40, 240);
		addLabel("Nome", x, y+=48, 240);
		addLabel("CPF", x, y+=24, 240);
		addLabel("RG", x, y+=24, 240);
		addLabel("CEP", x, y+=24, 240);
		addLabel("Logradouro", x, y+=24, 240);
		addLabel("Número", x, y+=24, 240);
		addLabel("Complemento", x, y+=24, 240);
		addLabel("Bairro", x, y+=24, 240);
		addLabel("Cidade", x, y+=24, 240);
		addLabel("UF", x, y+=24, 240);
	}
}
