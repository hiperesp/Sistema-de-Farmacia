package view.telas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import view.util.FormElements;
import view.util.Tela;
import view.util.VerticalPanel;

public class TelaClientes extends Tela implements FormElements {
	private static final long serialVersionUID = -6432091958862873077L;

	public TelaClientes() {
		super(new GridLayout(1, 2));
	}
	
	JTextField formNome, formRG, formCPF, formCEP, formLogradouro, formNumero
			 , formComplemento, formBairro, formMunicipio, formEstado;
	JButton formCadastrar;
	
	VerticalPanel form;
	
	public void addElements() {
		add(createSeparator());
		add(createForm());
	}

	public VerticalPanel createForm() {
		return form = new VerticalPanel(
			
			createLabel("Cadastrar Cliente", BOLD_FONT[8]),
			
			createVerticalPanel(
				createLabel("Nome completo", PLAIN_FONT[4]),
				formNome = createTextField()
			),
			
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("RG", PLAIN_FONT[4]),
					formRG = createTextField()
				),
				createVerticalPanel(
					createLabel("CPF", PLAIN_FONT[4]),
					formCPF = createTextField()
				)
			),
			
			createSeparator(20),
			
			createLabel("Endereço", PLAIN_FONT[5]),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("CEP", PLAIN_FONT[4]),
					formCEP = createTextField()
				),
				createVerticalPanel(
					createLabel("Logradouro", PLAIN_FONT[4]),
					formLogradouro = createTextField()
				)
			),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("Número", PLAIN_FONT[4]),
					formNumero = createTextField()
				),
				createVerticalPanel(
					createLabel("Complemento", PLAIN_FONT[4]),
					formComplemento = createTextField()
				),
				createVerticalPanel(
					createLabel("Bairro", PLAIN_FONT[4]),
					formBairro = createTextField()
				)
			),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("Município", PLAIN_FONT[4]),
					formMunicipio = createTextField()
				),
				createVerticalPanel(
					createLabel("Estado", PLAIN_FONT[4]),
					formEstado = createTextField()
				)
			),
			
			createSeparator(20),
			
			formCadastrar = createButton("Cadastrar")
		);
	}
}
