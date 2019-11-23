package view.telas;

import java.awt.Color;

import javax.swing.JPanel;

public class TelaFuncionarios extends JPanel {

	private static final long serialVersionUID = -6432091958862873077L;
	
	public TelaFuncionarios(int width) {
		super();
		init();
	}
	
	
	
	private void init() {
		setOpaque(true);
		setBackground(new Color(0x200040));
	}
}
