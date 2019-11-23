package view.elements;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import view.telas.TelaClientes;
import view.telas.TelaEstoque;
import view.telas.TelaFornecedores;
import view.telas.TelaFuncionarios;
import view.telas.TelaProdutos;
import view.telas.TelaVendas;
import view.util.InterfacePadraoConstants;

public class Tela extends JScrollPane implements InterfacePadraoConstants {

	private static final long serialVersionUID = -6779992825345317604L;
	
	public Tela() {
		super();
		//setLayout(new GridLayout());
		setBorder(BorderFactory.createEmptyBorder());
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	public Tela(int tela) {
		this();
		setTela(tela);
	}
	
	public void setTela(int tela) {
		getViewport().removeAll();
		JPanel newTela = getTela(tela);
		getViewport().add(newTela);
		//SwingUtilities.updateComponentTreeUI(this);
	}
	public JPanel getTela(int tela) {
		int width = getWidth();
		switch(tela) {
			case TELA_CLIENTES: return new TelaClientes(width);
			case TELA_ESTOQUE: return new TelaEstoque(width);
			case TELA_FORNECEDORES: return new TelaFornecedores(width);
			case TELA_FUNCIONARIOS: return new TelaFuncionarios(width);
			case TELA_PRODUTOS: return new TelaProdutos(width);
			case TELA_VENDAS: return new TelaVendas(width);
		}
		return null;
	}
}
