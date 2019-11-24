package view.util;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HorizontalPanel extends FormPanel {

	private static final long serialVersionUID = 2294818447940132583L;

	public HorizontalPanel(Insets padding) {
		super(padding);
		setLayout(new GridLayout(1, 1, 8, 8));
	}
	public HorizontalPanel() {
		this(null);
	}
	
	public VerticalPanel formatVerticalPanel(VerticalPanel verticalPanel) {
		return verticalPanel;
	}
	
	public JTextField addTextField(String label, Font font) {
		return formatVerticalPanel(addVerticalPanel()).addTextField(label, font);
	}
	public JPasswordField addPasswordField(String label, Font font) {
		return formatVerticalPanel(addVerticalPanel()).addPasswordField();
	}
}
