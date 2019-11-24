package view.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class Tela extends JPanel implements DefaultOptions {
	
	private static final long serialVersionUID = -4352280787426799809L;
	
	public Tela(Dimension dimension, LayoutManager layoutManager, Insets padding) {
		super();
		if(dimension!=null) {
			setPreferredSize(dimension);
			setSize(dimension);
		}
		if(padding==null) {
			padding = new Insets(32, 64, 32, 64);
		}
		setBorder(BorderFactory.createEmptyBorder(padding.top, padding.left, padding.bottom, padding.right));
		if(layoutManager==null) {
			layoutManager = new BorderLayout();
		}
		setLayout(layoutManager);
		init();
	}
	public Tela(LayoutManager layoutManager, Insets padding) {
		this(null, layoutManager, padding);
	}
	public Tela(Dimension dimension, Insets padding) {
		this(dimension, null, padding);
	}
	public Tela(Dimension dimension, LayoutManager layoutManager) {
		this(dimension, layoutManager, null);
	}
	public Tela(Dimension dimension) {
		this(dimension, null, null);
	}
	public Tela(LayoutManager layoutManager) {
		this(null, layoutManager, null);
	}
	public Tela(Insets padding) {
		this(null, null, padding);
	}
	public Tela() {
		this(null, null, null);
	}	
	
	private void init() {
		setOpaque(true);
		setBackground(COLOR[2]);
		addElements();
	}
	
	public abstract void addElements();
}
