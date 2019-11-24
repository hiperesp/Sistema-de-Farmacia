package view.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface FormElements extends FormItemConstants, DefaultOptions {
	static JLabel formatLabel(JLabel label, Font font) {
		label.setFont(font);
		label.setForeground(COLOR[3]);
		label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		return label;
	}
	static JComponent formatField(JComponent formElement) {
		formElement.setFont(PLAIN_FONT[3]);
		formElement.setBackground(COLOR[3]);
		formElement.setForeground(COLOR[4]);
		formElement.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 0));
		formElement.setMaximumSize(new Dimension(MAX_WIDTH, FIELD_BEST_HEIGHT));
		formElement.setAlignmentX(Component.LEFT_ALIGNMENT);
		return formElement;
	}
	static JButton formatButton(JButton button) {
		button.setFont(PLAIN_FONT[3]);
		button.setBackground(COLOR[3]);
		button.setForeground(COLOR[4]);
		button.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 0));
		button.setMaximumSize(new Dimension(MAX_WIDTH, FIELD_BEST_HEIGHT));
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		return button;
	}
	static JLabel formatSeparator(JLabel separator, int height) {
		separator.setBorder(BorderFactory.createEmptyBorder(height, 0, 0, 0));
		return separator;
	}
	static HorizontalPanel formatHorizontalPanel(HorizontalPanel horizontalPanel) {
		horizontalPanel.setMaximumSize(new Dimension(MAX_WIDTH, LABEL_BEST_HEIGHT+FIELD_BEST_HEIGHT));
		horizontalPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		return horizontalPanel;
	}
	static VerticalPanel formatVerticalPanel(VerticalPanel verticalPanel) {
		return verticalPanel;
	}
	

	default JLabel createLabel(String labelText, Font font) {
		return (JLabel) formatLabel(new JLabel(labelText), font);
	}
	default JTextField createTextField() {
		return (JTextField) formatField(new JTextField());
	}
	default JPasswordField createPasswordField() {
		return (JPasswordField) formatField(new JPasswordField());
	}
	default JButton createButton(String text) {
		return (JButton) formatButton(new JButton(text));
	}
	default JLabel createSeparator(int height) {
		return (JLabel) formatSeparator(new JLabel(), height);
	}
	default JLabel createSeparator() {
		return createSeparator(10);
	}
	default HorizontalPanel createHorizontalPanel() {
		return (HorizontalPanel) formatHorizontalPanel(new HorizontalPanel());
	}
	default VerticalPanel createVerticalPanel() {
		return (VerticalPanel) formatVerticalPanel(new VerticalPanel());
	}
	default HorizontalPanel createHorizontalPanel(Component...components) {
		return (HorizontalPanel) formatHorizontalPanel(new HorizontalPanel()).with(components);
	}
	default VerticalPanel createVerticalPanel(Component...components) {
		return (VerticalPanel) formatVerticalPanel(new VerticalPanel()).with(components);
	}
}
