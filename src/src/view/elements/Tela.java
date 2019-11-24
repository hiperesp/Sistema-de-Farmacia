package view.elements;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import view.telas.TelaClientes;
import view.telas.TelaEstoque;
import view.telas.TelaFornecedores;
import view.telas.TelaFuncionarios;
import view.telas.TelaProdutos;
import view.telas.TelaVendas;
import view.util.InterfaceConstants;

public class Tela extends JScrollPane implements InterfaceConstants {

	private static final long serialVersionUID = -6779992825345317604L;
	
	public Tela() {
		super();
		setBorder(BorderFactory.createEmptyBorder());
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	public Tela(int tela, Rectangle bounds) {
		this();
		setBounds(bounds);
		setTela(tela);
	}
	
	public void setTela(int tela) {
		getViewport().removeAll();
		JPanel newTela = getTela(tela);
		getViewport().add(newTela);
		//SwingUtilities.updateComponentTreeUI(this);
	}
	public JPanel getTela(int tela) {
		switch(tela) {
			case TELA_CLIENTES:		return new TelaClientes();
			case TELA_ESTOQUE:		return new TelaEstoque();
			case TELA_FORNECEDORES: return new TelaFornecedores();
			case TELA_FUNCIONARIOS: return new TelaFuncionarios();
			case TELA_PRODUTOS:		return new TelaProdutos();
			case TELA_VENDAS:		return new TelaVendas();
		}
		return null;
	}
}
