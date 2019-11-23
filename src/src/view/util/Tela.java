package view.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.elements.DefaultOptions;

public abstract class Tela extends JPanel {
	
	private static final long serialVersionUID = -4352280787426799809L;
	
	private static final boolean DEBUG = true;
	
	int width;
	
	public Tela(int width) {
		setLayout(null);
		this.width = width;
		setPreferredSize(new Dimension(width, 1280));
		init();
	}
	
	private void init() {
		setOpaque(true);
		setBackground(DefaultOptions.color[2]);
		addAnonymousElements();
	}
	
	public JLabel addLabel(String labelText, int x, int y, int width, int height, Font font) {
		JLabel lblText = new JLabel(labelText);
		lblText.setBounds(new Rectangle(x, y, width, height));
		lblText.setFont(font);
		lblText.setForeground(DefaultOptions.color[5]);
		if(DEBUG) {lblText.setOpaque(true);lblText.setBackground(new Color(0xff0000));}
		add(lblText);
		return lblText;
	}
	
	public JLabel addTitle(String text, int x, int y, int width) {
		return addLabel(text, x, y, width, 32, DefaultOptions.font[6]);
	}
	
	public JLabel addLabel(String text, int x, int y, int width) {
		return addLabel(text, x, y, width, 14, DefaultOptions.font[2]);
	}
	
	public abstract void addAnonymousElements();
}