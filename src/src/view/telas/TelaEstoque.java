package view.telas;

import java.awt.Color;

import javax.swing.JPanel;

public class TelaEstoque extends JPanel {

	private static final long serialVersionUID = -6432091958862873077L;
	
	public TelaEstoque(int width) {
		super();
		init();
	}
	
	
	
	private void init() {
		setOpaque(true);
		setBackground(new Color(0x200040));
	}
}
