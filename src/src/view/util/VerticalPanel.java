package view.util;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.BoxLayout;

public class VerticalPanel extends FormPanel {

	private static final long serialVersionUID = 2294818447940132583L;
	
	public VerticalPanel(Insets padding, Component...components) {
		super(padding);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		with(components);
	}
	public VerticalPanel(Component...components) {
		this(null, components);
	}
	public VerticalPanel with(Component...components) {
		return (VerticalPanel)super.with(components);
	}
}
