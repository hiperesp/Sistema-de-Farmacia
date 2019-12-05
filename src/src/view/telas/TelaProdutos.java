package view.telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Produto;
import view.util.FormElements;
import view.util.TableListener;
import view.util.Tela;
import view.util.VerticalPanel;

public class TelaProdutos extends Tela implements FormElements, TableListener {
	private static final long serialVersionUID = -6432091958862873077L;

	private static GridLayout layoutManager = new GridLayout(1,2);
	
	public TelaProdutos() {
		super(layoutManager);
		switchWidth();
	}
	
	JTextField formNome, formDescricao, formValor;
	JButton formCadastrar;
	
	VerticalPanel form, list;
	
	String[] tableHeader;
	String[][] tableData;
	String[][] originalTableData;
	
	public void addElements() {
		tableData = controller.ProdutoController.select();
		originalTableData = controller.ProdutoController.select();
		add(createList());
		add(createForm());
		configure();
	}
	
	public VerticalPanel createList() {
		tableHeader = new String[] { "Código", "Nome", "Descrição", "Valor" };

		list = new VerticalPanel(
				createLabel("Produtos Cadastrados", BOLD_FONT[8]),
				
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
			
			createLabel("Cadastrar Produto", BOLD_FONT[8]),
			
			createVerticalPanel(
				createLabel("Nome do Produto", PLAIN_FONT[4]),
				formNome = createTextField(ALLOW_ALL, 255)
			),
			
			createVerticalPanel(
				createLabel("Descrição do Produto", PLAIN_FONT[4]),
				formDescricao = createTextField(ALLOW_ALL, 100)
			),
			
			createVerticalPanel(
				createLabel("Valor do Produto", PLAIN_FONT[4]),
				formValor = createTextField(ONLY_FLOAT, 11)
			),
			
			createSeparator(20),
			
			formCadastrar = createButton("Cadastrar")
		);
	}
	public void configure() {
		formCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Produto produto = new Produto();
					produto.setNome(formNome.getText());
					produto.setDescricao(formDescricao.getText());
					produto.setValor(Float.parseFloat(formValor.getText().replaceAll(",", ".")));
					if(controller.ProdutoController.insert(produto)) {
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
						reloadScreen();
					} else {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar. Verifique as informações preenchidas (e caso dê erro, veja o console)");
					}
				} catch(NumberFormatException exception) {}
			}
		});
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
			try {
				Produto produto = new Produto();
				produto.setId(Integer.parseInt(originalTableData[line][0]));
				produto.setNome(tableData[line][1]);
				produto.setDescricao(tableData[line][2]);
				produto.setValor(Float.parseFloat(tableData[line][3].replaceAll(",", ".")));
				controller.ProdutoController.update(produto);
			} catch(NumberFormatException exception) {}
			reloadScreen();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_DELETE) {
			JTable table = (JTable)e.getSource();
			int[] rowsToDelete = table.getSelectedRows();
			if(rowsToDelete.length>0) {
				if(JOptionPane.showConfirmDialog(null, "Você quer remover "+rowsToDelete.length+" dados?")==JOptionPane.OK_OPTION) {
					int ok = 0;
					for(int i=0; i<rowsToDelete.length; i++) {
						//((DefaultTableModel)((JTable)e.getSource()).getModel()).removeRow(rowsToDelete[i]);
						Produto dataToDelete = new Produto();
						dataToDelete.setId(Integer.parseInt(originalTableData[rowsToDelete[i]][0]));
						if(controller.ProdutoController.delete(dataToDelete)) {
							ok++;
						}
					}
					JOptionPane.showMessageDialog(null, ok+" produtos removidos com sucesso\nA remoção de "+(rowsToDelete.length-ok)+" produtos falharam.");
					reloadScreen();
				}
			}
		}
	}
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
