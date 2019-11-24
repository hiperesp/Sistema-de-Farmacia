package view.util;

import java.awt.Insets;
import javax.swing.BoxLayout;

public class VerticalPanel extends FormPanel {

	private static final long serialVersionUID = 2294818447940132583L;
	
	public VerticalPanel(Insets padding) {
		super(padding);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	public VerticalPanel() {
		this(null);
	}
}
