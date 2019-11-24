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
		//setLayout(null);
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
		int scrollBarSize = ((Integer)javax.swing.UIManager.get("ScrollBar.width")).intValue();
		int width = getWidth()-scrollBarSize;
		int height = getHeight()-scrollBarSize;
		switch(tela) {
			case TELA_CLIENTES:		return new TelaClientes(width, height);
			case TELA_ESTOQUE:		return new TelaEstoque(width, height);
			case TELA_FORNECEDORES: return new TelaFornecedores(width, height);
			case TELA_FUNCIONARIOS: return new TelaFuncionarios(width, height);
			case TELA_PRODUTOS:		return new TelaProdutos(width, height);
			case TELA_VENDAS:		return new TelaVendas(width, height);
		}
		return null;
	}
}
