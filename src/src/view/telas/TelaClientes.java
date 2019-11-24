package view.telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import view.util.VerticalPanel;
import view.util.HorizontalPanel;
import view.util.Tela;

public class TelaClientes extends Tela {

	private static final long serialVersionUID = -6432091958862873077L;
	
	public TelaClientes() {
		super(new GridLayout(1, 2));
	}
	JTextField formNome, formRG, formCPF;
	public void addElements() {
		//lista
		add(new JLabel());

		//formulario
		Insets padding = new Insets(16, 8, 64, 8);
		VerticalPanel verticalPanel = new VerticalPanel(padding);
		addFormElements(verticalPanel);
		add(verticalPanel);
	}
	public void addFormElements(VerticalPanel f) {
		
		f.addLabel("Clientes", BOLD_FONT[8]);

		formNome = f.addTextField("Nome", PLAIN_FONT[4]);
		HorizontalPanel l1 = f.addHorizontalPanel();
			formRG = l1.addTextField("RG", PLAIN_FONT[4]);
			formCPF = l1.addTextField("CPF", PLAIN_FONT[4]);
		f.addSeparator(20);
		f.addLabel("Endereço", PLAIN_FONT[5]);
		HorizontalPanel l2 = f.addHorizontalPanel();
			formRG = l2.addTextField("RG", PLAIN_FONT[4]);
			formCPF = l2.addTextField("CPF", PLAIN_FONT[4]);
	}
}
