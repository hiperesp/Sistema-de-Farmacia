package view.util;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class Tela extends JPanel implements DefaultOptions {
	
	private static final long serialVersionUID = -4352280787426799809L;
	
	public Tela(LayoutManager layoutManager, Insets padding) {
		super();
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
	public Tela(LayoutManager layoutManager) {
		this(layoutManager, null);
	}
	public Tela(Insets padding) {
		this(null, padding);
	}
	public Tela() {
		this(null, null);
	}	
	
	private void init() {
		setOpaque(true);
		setBackground(COLOR[2]);
		addElements();
		updateHeight();
	}
	
	public void setDimension(Dimension dimension) {
		setPreferredSize(dimension);
		setSize(dimension);
	}

	public abstract void addElements();
	
	public void updateHeight() {
		Component[] components = getComponents();
		int width = 0;
		int height = 0;
		for(Component component: components) {
			int componentWidth = (int)component.getPreferredSize().getWidth();
			int componentHeight = (int)component.getPreferredSize().getHeight();
			if(componentWidth>width) width = componentWidth;
			if(componentHeight>height) height = componentHeight;
		}
		width+= getInsets().left+getInsets().right;
		height+= getInsets().top+getInsets().bottom;
		
		setDimension(new Dimension(width, height));
	}
}
