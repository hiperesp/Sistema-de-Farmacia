package view.util;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FormPanel extends JPanel implements FormItemConstants, DefaultOptions {

	private static final long serialVersionUID = 2294818447940132583L;

	public FormPanel(Insets padding, Component...components) {
		super();
		if(padding!=null) {
			setBorder(new EmptyBorder(padding));
		}
		setOpaque(false);
		with(components);
	}
	public FormPanel(Component...components) {
		this(null, components);
	}
	public FormPanel with(Component...components) {
		for (int i = 0; i < components.length; i++) {
			Component component = (Component)components[i];
			if(component!=this) {
				add(component);
			}
		}
		return this;
	}
}
