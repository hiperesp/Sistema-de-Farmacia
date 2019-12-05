package view.telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Produto;
import model.Venda;
import view.util.FormElements;
import view.util.TableListener;
import view.util.Tela;
import view.util.VerticalPanel;

public class TelaVendas extends Tela implements FormElements, TableListener {
	private static final long serialVersionUID = -6432091958862873077L;

	private static GridLayout layoutManager = new GridLayout(1,2);
	
	public TelaVendas() {
		super(layoutManager);
		switchWidth();
	}
	
	JTextField formCliente, formProduto, formQuantidade, formValorUnitario, formValorTotal, formClienteNome, formProdutoNome;
	JButton formCadastrar;
	
	VerticalPanel form, list;
	
	String[] tableHeader;
	String[][] tableData;
	String[][] originalTableData;
	
	public void addElements() {
		tableData = controller.VendaController.select();
		originalTableData = controller.VendaController.select();
		add(createList());
		add(createForm());
		configure();
	}
	
	public VerticalPanel createList() {
		tableHeader = new String[] { "Código", "Cliente", "Produto", "Quantidade", "Valor" };

		list = new VerticalPanel(
				createLabel("Vendas Realizadas", BOLD_FONT[8]),
				
				createSeparator(20),
				
				createTable(
						this,
						tableHeader,
						tableData
				),

				createSeparator(20)
		);
		return list;
	}

	public VerticalPanel createForm() {
		return form = new VerticalPanel(
			
			createLabel("Cadastrar Venda", BOLD_FONT[8]),
			
			createVerticalPanel(
				createLabel("Código do Cliente", PLAIN_FONT[4]),
				formCliente = createTextField(ONLY_INTEGER, 11),
				createLabel("Nome Cliente", PLAIN_FONT[4]),
				formClienteNome = createTextField()
			),
					
			createVerticalPanel(
				createLabel("Código do Produto", PLAIN_FONT[4]),
				formProduto = createTextField(ONLY_INTEGER, 11),
				createLabel("Nome do Produto", PLAIN_FONT[4]),
				formProdutoNome = createTextField(),
				createLabel("Valor unitário do Produto", PLAIN_FONT[4]),
				formValorUnitario = createTextField()
			),
			
			createVerticalPanel(
				createLabel("Quantidade", PLAIN_FONT[4]),
				formQuantidade = createTextField(ONLY_INTEGER, 11),
				createLabel("Valor Total", PLAIN_FONT[4]),
				formValorTotal = createTextField()
			),
			
			createSeparator(20),
			
			formCadastrar = createButton("Cadastrar")
		);
	}
	public void configure() {
		formCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Venda venda = new Venda();
				venda.setCliente(Integer.parseInt(formCliente.getText()));
				venda.setProduto(Integer.parseInt(formProduto.getText()));
				venda.setQuantidade(Integer.parseInt(formQuantidade.getText()));
				venda.setValorTotal(Float.parseFloat(formValorTotal.getText().replaceAll(",", ".")));
				if(controller.VendaController.insert(venda)) {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					reloadScreen();
				} else {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar. Verifique as informações preenchidas (e caso dê erro, veja o console)");
				}
			}
		});
		formCliente.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				String nomeCliente = null;
				try {
					nomeCliente = controller.VendaController.getCliente(Integer.parseInt(formCliente.getText()));
				} catch(NumberFormatException exception) {}
				if(nomeCliente==null) nomeCliente = "";
				formClienteNome.setText(nomeCliente);
				recalculateTotal();
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		formProduto.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				int pid;
				String nomeProduto = null;
				float valorProduto = 0;
				try {
					pid = Integer.parseInt(formProduto.getText());
					nomeProduto = controller.VendaController.getProduto(pid);
					valorProduto = controller.VendaController.getValorProduto(pid);
				} catch(NumberFormatException exception) {}
				if(nomeProduto==null) nomeProduto = "";
				formProdutoNome.setText(nomeProduto);
				formValorUnitario.setText(""+valorProduto);
				formQuantidade.setText("1");
				recalculateTotal();
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		formQuantidade.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) {
				recalculateTotal();
			}
			@Override
			public void keyPressed(KeyEvent e) { }
		});
		formClienteNome.setEditable(false);
		formProdutoNome.setEditable(false);
		formValorUnitario.setEditable(false);
		formValorTotal.setEditable(false);
		formValorTotal.setText("0.0");
		formCadastrar.setEnabled(false);
	}
	
	public void recalculateTotal() {
		int quantidade = Integer.parseInt(formQuantidade.getText());
		float valorUnitario = Float.parseFloat(formValorUnitario.getText().replaceAll(",", "."));
		float valorTotal = quantidade*valorUnitario;
		String nomeCliente = formClienteNome.getText();
		formValorTotal.setText(""+valorTotal);
		if(valorTotal<=0||nomeCliente.equals("")) {
			formCadastrar.setEnabled(false);
		} else {
			formCadastrar.setEnabled(true);
		}
	}
	
	public void reloadScreen() {
		removeAll();
		addElements();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		JTable source = ((JTable)evt.getSource());
		int line = source.getEditingRow();
		if(line>-1) {
			reloadScreen();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyTyped(KeyEvent e) { }
	
	boolean isDefaultWidth = true;
	@Override
	public void switchWidth() {
		isDefaultWidth = !isDefaultWidth;
		if(isDefaultWidth) {
			layoutManager.setHgap(32);
			setDimension(new Dimension(getWidth()*2, getHeight()));
		} else {
			layoutManager.setHgap(8);
			setDimension(new Dimension(getWidth()/2, getHeight()));
		}
	}
}
