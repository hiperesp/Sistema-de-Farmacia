package view.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormPanel extends JPanel implements FormItemConstants, DefaultOptions {

	private static final long serialVersionUID = 2294818447940132583L;

	public FormPanel(Insets padding) {
		super();
		if(padding!=null) {
			setBorder(new EmptyBorder(padding));
		}
		setOpaque(false);
	}
	public FormPanel() {
		this(null);
	}
	
	public JLabel addLabel(String labelText, Font font) {
		return (JLabel) add(formatLabel(new JLabel(labelText), font));
	}
	public JSeparator addSeparator(int height) {
		return (JSeparator) add(formatSeparator(new FormSeparator(), height));
	}
	public JSeparator addSeparator() {
		return addSeparator(10);
	}
	private JSeparator formatSeparator(JSeparator separator, int height) {
		separator.setMaximumSize(new Dimension(MAX_WIDTH, height));
		return separator;
	}
	private JLabel formatLabel(JLabel label, Font font) {
		label.setFont(font);
		label.setForeground(COLOR[3]);
		label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		return label;
	}
	private JComponent formatField(JComponent formElement) {
		formElement.setFont(PLAIN_FONT[3]);
		formElement.setBackground(COLOR[3]);
		formElement.setForeground(COLOR[4]);
		formElement.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 0));
		formElement.setMaximumSize(new Dimension(MAX_WIDTH, FIELD_BEST_HEIGHT));
		formElement.setAlignmentX(Component.LEFT_ALIGNMENT);
		return formElement;
	}
	private HorizontalPanel formatHorizontalPanel(HorizontalPanel horizontalPanel) {
		horizontalPanel.setMaximumSize(new Dimension(MAX_WIDTH, LABEL_BEST_HEIGHT+FIELD_BEST_HEIGHT));
		horizontalPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		return horizontalPanel;
	}
	private VerticalPanel formatVerticalPanel(VerticalPanel verticalPanel) {
		return verticalPanel;
	}
	public JTextField addTextField() {
		return (JTextField) add(formatField(new JTextField()));
	}
	public JPasswordField addPasswordField() {
		return (JPasswordField) add(formatField(new JPasswordField()));
	}
	public JTextField addTextField(String label, Font font) {
		addLabel(label, font);
		return addTextField();
	}
	public JPasswordField addPasswordField(String label, Font font) {
		addLabel(label, font);
		return addPasswordField();
	}
	public HorizontalPanel addHorizontalPanel(int cols) {
		return (HorizontalPanel) add(formatHorizontalPanel(new HorizontalPanel(cols)));
	}
	public VerticalPanel addVerticalPanel() {
		return (VerticalPanel) add(formatVerticalPanel(new VerticalPanel()));
	}
}
