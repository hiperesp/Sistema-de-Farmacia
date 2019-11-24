package view.util;

import java.awt.Color;
import javax.swing.JSeparator;

public class FormSeparator extends JSeparator {

	private static final long serialVersionUID = -8671395299959936856L;

	public FormSeparator(Color color) {
		setBackground(color);
		setForeground(color);
	}
	public FormSeparator() {
		this(DefaultOptions.COLOR[2]);
	}
}
