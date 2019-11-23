package view.telas;

import java.awt.Rectangle;

import view.elements.DefaultOptions;
import view.util.Tela;

public class TelaClientes extends Tela {

	private static final long serialVersionUID = -6432091958862873077L;
	
	int width;
	
	public TelaClientes(int width) {
		super(width);
	}
	public void addAnonymousElements() {
		addLabel("Clientes", new Rectangle(32, 40, 240, 80), DefaultOptions.plainFont[0]);
		
	}
}
