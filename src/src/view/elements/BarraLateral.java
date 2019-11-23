package view.elements;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.util.BotaoLateral;
import view.util.InterfacePadraoConstants;

public class BarraLateral extends JPanel implements InterfacePadraoConstants {
	
	private static final long serialVersionUID = -7084727490763907158L;
	
	BotaoLateral[] botoesLaterais;
	
	private int buttonHeight, height;
	
	public BarraLateral(ActionListener actionListener, int height) {
		super();
		this.height = height;
		setupBotoesLateral(actionListener);
		addBotoesLateral();
		setupBarraLateral();
	}
	public void setupBarraLateral() {
		setBackground(DefaultOptions.color[0]);
		setLayout(new GridLayout(botoesLaterais.length, 0));
		setBounds(new Rectangle(0, 0, buttonHeight, height));
	}
	public void setupBotoesLateral(ActionListener actionListener) {
		botoesLaterais = new BotaoLateral[] {
				new BotaoLateral(TELA_CLIENTES, "Clientes", "assets/icon-cliente.png", actionListener),
				new BotaoLateral(TELA_VENDAS, "Vendas", "assets/icon-vendas.png", actionListener),
				new BotaoLateral(TELA_ESTOQUE, "Estoque", "assets/icon-estoque.png", actionListener),
				new BotaoLateral(TELA_FUNCIONARIOS, "Funcionários", "assets/icon-funcionario.png", actionListener),
				new BotaoLateral(TELA_FORNECEDORES, "Fornecedores", "assets/icon-fornecedor.png", actionListener),
				new BotaoLateral(TELA_PRODUTOS, "Produtos", "assets/icon-produto.png", actionListener),
		};
	}
	public void addBotoesLateral() {
		buttonHeight = height/botoesLaterais.length;
		for (BotaoLateral botaoLateral : botoesLaterais) {
			botaoLateral.setSize(buttonHeight, buttonHeight);
			add(botaoLateral);
		}
	}
	public void setFocusButton(BotaoLateral button) {
		for (BotaoLateral botaoLateral : botoesLaterais) {
			if(botaoLateral==button) {
				botaoLateral.setFocused(true);
			} else {
				botaoLateral.setFocused(false);
			}
			add(botaoLateral);
		}
	}
	public void setFocusButton(int button) {
		for (BotaoLateral botaoLateral : botoesLaterais) {
			if(botaoLateral.code==button) {
				botaoLateral.setFocused(true);
			} else {
				botaoLateral.setFocused(false);
			}
			add(botaoLateral);
		}
	}
}
