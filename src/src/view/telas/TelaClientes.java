package view.telas;

import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import view.util.VerticalPanel;
import view.util.HorizontalPanel;
import view.util.Tela;

public class TelaClientes extends Tela {

	private static final long serialVersionUID = -6432091958862873077L;
	
	public TelaClientes() {
		super(new GridLayout(1, 2));
	}
	
	JTextField formNome, formRG, formCPF,
			formCEP, formLogradouro, formNumero,
			formComplemento, formBairro,
			formMunicipio, formEstado;
	
	public void addElements() {
		//lista
		add(new JLabel(""));

		//formulario
		Insets padding = new Insets(16, 8, 64, 8);
		VerticalPanel verticalPanel = new VerticalPanel(padding);
		addFormElements(verticalPanel);
		add(verticalPanel);
	}
	public void addFormElements(VerticalPanel f) {
		
		f.addLabel("Cadastrar Cliente", BOLD_FONT[8]);

		formNome = f.addTextField("Nome completo", PLAIN_FONT[4]);
		HorizontalPanel l1 = f.addHorizontalPanel();
			formRG = l1.addTextField("RG", PLAIN_FONT[4]);
			formCPF = l1.addTextField("CPF", PLAIN_FONT[4]);
		f.addSeparator(20);
		f.addLabel("Endereço", PLAIN_FONT[5]);
		HorizontalPanel l2 = f.addHorizontalPanel();
			formCEP = l2.addTextField("CEP", PLAIN_FONT[4]);
			formLogradouro = l2.addTextField("Logradouro", PLAIN_FONT[4]);
		HorizontalPanel l3 = f.addHorizontalPanel();
			formNumero = l3.addTextField("Número", PLAIN_FONT[4]);
			formComplemento = l3.addTextField("Complemento", PLAIN_FONT[4]);
			formBairro = l3.addTextField("Bairro", PLAIN_FONT[4]);
		HorizontalPanel l4 = f.addHorizontalPanel();
			formMunicipio = l4.addTextField("Município", PLAIN_FONT[4]);
			formEstado = l4.addTextField("Estado", PLAIN_FONT[4]);
	}
}
