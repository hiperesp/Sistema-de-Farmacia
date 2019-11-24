package view.telas;

import java.awt.Dimension;
import java.awt.Rectangle;

import view.util.Tela;

public class TelaFornecedores extends Tela {

	private static final long serialVersionUID = -6432091958862873077L;
	
	public TelaFornecedores(int width, int height) {
		super(new Dimension(width, height));
	}
	public void addElements() {
		Dimension dimension = getPreferredSize();
		addLabel("Cadastrar Fornecedor", new Rectangle(64, 32, dimension.width, 64), BOLD_FONT[5]);
	}
}
