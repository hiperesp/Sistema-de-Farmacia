package view.telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JTextField;
import view.util.VerticalPanel;
import view.util.FormSeparator;
import view.util.HorizontalPanel;
import view.util.Tela;

public class TelaClientes extends Tela {

	private static final long serialVersionUID = -6432091958862873077L;
	
	public TelaClientes(int maxWidth, int maxHeight) {
		super(new Dimension(maxWidth, maxHeight), new GridLayout(1, 2));
	}
	JTextField formNome, formRG, formCPF;
	public void addElements() {
		@SuppressWarnings("unused")
		Dimension size = getPreferredSize();
		//lista
		add(new FormSeparator());

		//formulario
		Insets padding = new Insets(0, 8, 0, 8);
		VerticalPanel verticalPanel = new VerticalPanel(padding);
		addFormElements(verticalPanel);
		add(verticalPanel);
	}
	public void addFormElements(VerticalPanel f) {
		f.addSeparator(40);
		f.addLabel("Clientes", BOLD_FONT[8]);
		f.addSeparator();
		formNome = f.addTextField("Nome", PLAIN_FONT[4]);
		HorizontalPanel l1 = f.addHorizontalPanel(3);
		formRG = l1.addTextField("RG", PLAIN_FONT[4]);
		formCPF = l1.addTextField("CPF", PLAIN_FONT[4]);
	}
}
