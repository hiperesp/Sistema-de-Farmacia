package view.util;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;

public class HorizontalPanel extends FormPanel {

	private static final long serialVersionUID = 2294818447940132583L;

	public HorizontalPanel(Insets padding, Component... components) {
		super(padding);
		setLayout(new GridLayout(1, 1, 8, 8));
		with(components);
	}
	public HorizontalPanel(Component...components) {
		this(null, components);
	}
	public HorizontalPanel with(Component...components) {
		return (HorizontalPanel)super.with(components);
	}
}
