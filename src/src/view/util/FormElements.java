package view.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface FormElements extends FormItemConstants, DefaultOptions {
	static JLabel formatLabel(JLabel label, Font font) {
		label.setFont(font);
		label.setForeground(COLOR[3]);
		label.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		return label;
	}
	static JComponent formatField(JComponent formElement, int allowedChars, int maxChars) {
		formElement.setFont(PLAIN_FONT[3]);
		formElement.setBackground(COLOR[3]);
		formElement.setForeground(COLOR[4]);
		formElement.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 0));
		formElement.setMaximumSize(new Dimension(MAX_WIDTH, FIELD_BEST_HEIGHT));
		formElement.setAlignmentX(Component.LEFT_ALIGNMENT);
		formElement.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				boolean failed;
				do {
					String text = ((JTextField)formElement).getText();
					failed = false;
					try {
						if(allowedChars==ONLY_INTEGER) Long.parseLong(text);
						else if(allowedChars==ONLY_FLOAT) Double.parseDouble(text);
					} catch(NumberFormatException exception) {
						if(!text.equals("")) {
							failed = true;
							text = text.substring(0, text.length()-1);
						}
					}
					if(maxChars>-1&&text.length()>maxChars) {
						text = text.substring(0, maxChars);
					}
					if(!((JTextField)formElement).getText().equals(text)) {
						((JTextField)formElement).setText(text);
					}
				} while(failed);
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
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
	static JScrollPane formatTable(JTable table, TableListener tableListener) {
		table.addPropertyChangeListener(tableListener);
		table.addKeyListener(tableListener);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		return scrollPane;
	}
	
	
	default JScrollPane createTable(TableListener tableListener, Object[] title, Object[]...data) {
		return formatTable(new JTable(data, title), tableListener);
	}
	default JLabel createLabel(String labelText, Font font) {
		return (JLabel) formatLabel(new JLabel(labelText), font);
	}
	default JTextField createTextField(int allowedChars, int maxChars) {
		return (JTextField) formatField(new JTextField(), allowedChars, maxChars);
	}
	default JTextField createTextField() {
		return (JTextField) formatField(new JTextField(), ALLOW_ALL, -1);
	}
	default JPasswordField createPasswordField() {
		return (JPasswordField) formatField(new JPasswordField(), ALLOW_ALL, -1);
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
