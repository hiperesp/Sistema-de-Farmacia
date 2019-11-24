package view.util;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HorizontalPanel extends FormPanel {

	private static final long serialVersionUID = 2294818447940132583L;

	public HorizontalPanel(int columns, Insets padding) {
		super(padding);
		setLayout(new GridLayout(1, columns, 8, 8));
	}
	public HorizontalPanel(int columns) {
		this(columns, null);
	}
	
	public JTextField addTextField(String label, Font font) {
		VerticalPanel verticalPanel = addVerticalPanel();
		return verticalPanel.addTextField(label, font);
	}
	public JPasswordField addPasswordField(String label, Font font) {
		VerticalPanel verticalPanel = addVerticalPanel();
		return verticalPanel.addPasswordField();
	}
}
