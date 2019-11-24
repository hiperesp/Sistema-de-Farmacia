package view.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Tela extends JPanel implements DefaultOptions {
	
	private static final long serialVersionUID = -4352280787426799809L;
	
	private static final boolean DEBUG = false;
	
	public Tela(Dimension dimension) {
		setLayout(null);
		setPreferredSize(dimension);
		setSize(dimension);
		init();
	}
	
	private void init() {
		setOpaque(true);
		setBackground(COLOR[2]);
		addElements();
	}
	
	public JLabel addLabel(String labelText, Rectangle bounds, Font font, JComponent parent) {
		JLabel lblText = new JLabel(labelText);
		if(bounds!=null) lblText.setBounds(bounds);
		lblText.setFont(font);
		lblText.setForeground(COLOR[3]);
		if(DEBUG) {
			lblText.setOpaque(true);
			lblText.setBackground(new Color(0xff0000));
		}
		parent.add(lblText);
		return lblText;
	}
	public JLabel addLabel(String defaultText, Dimension dimension, Font font, JComponent parent) {
		JLabel label = addLabel(defaultText, font, parent);
		if(dimension!=null) label.setSize(dimension);
		return label;
	}
	public JTextField addTextField(String defaultText, Rectangle bounds, Font font, JComponent parent) {
		JTextField textField = new JTextField(defaultText);
		if(bounds!=null) textField.setBounds(bounds);
		textField.setFont(font);
		textField.setForeground(COLOR[3]);
		parent.add(textField);
		return textField;
	}
	public JTextField addTextField(String defaultText, Dimension dimension, Font font, JComponent parent) {
		JTextField textField = addTextField(defaultText, font, parent);
		if(dimension!=null) textField.setSize(dimension);
		return textField;
	}
	public JTextField addTextField(String defaultText, Rectangle bounds, Font font) {
		return addTextField(defaultText, bounds, font, this);
	}
	public JTextField addTextField(String defaultText, Dimension dimension, Font font) {
		return addTextField(defaultText, dimension, font, this);
	}
	public JTextField addTextField(String defaultText, Font font, JComponent parent) {
		return addTextField(defaultText, (Rectangle)null, font, parent);
	}
	public JTextField addTextField(String defaultText, Font font) {
		return addTextField(defaultText, (Rectangle)null, font, this);
	}
	public JLabel addLabel(String labelText, Font font, JComponent parent) {
		return addLabel(labelText, (Rectangle)null, font, parent);
	}
	public JLabel addLabel(String labelText, Dimension dimension, Font font) {
		return addLabel(labelText, dimension, font, this);
	}
	public JLabel addLabel(String labelText, Rectangle bounds, Font font) {
		return addLabel(labelText, bounds, font, this);
	}
	public JLabel addLabel(String labelText, Font font) {
		return addLabel(labelText, (Rectangle)null, font, this);
	}
	
	public abstract void addElements();
}
