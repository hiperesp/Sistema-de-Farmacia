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
import model.Cliente;
import view.util.FormElements;
import view.util.TableListener;
import view.util.Tela;
import view.util.VerticalPanel;

public class TelaClientes extends Tela implements FormElements, TableListener {
	private static final long serialVersionUID = -6432091958862873077L;

	private static GridLayout layoutManager = new GridLayout(1,2);
	
	public TelaClientes() {
		super(layoutManager);
		switchWidth();
	}
	
	JTextField formNome, formRG, formCPF, formCEP, formLogradouro, formNumero
			 , formComplemento, formBairro, formMunicipio, formEstado;
	JButton formCadastrar;
	
	VerticalPanel form, list;
	
	String[] tableHeader;
	String[][] tableData;
	String[][] originalTableData;
	
	public void addElements() {
		tableData = controller.ClienteController.select();
		originalTableData = controller.ClienteController.select();
		add(createList());
		add(createForm());
		configure();
	}
	
	public VerticalPanel createList() {
		tableHeader = new String[] { "Código", "Nome", "CPF", "RG", "Logradouro", "Número", "Complemento", "Município", "Bairro", "CEP", "Estado" };

		list = new VerticalPanel(
				createLabel("Clientes Cadastrados", BOLD_FONT[8]),
				
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
			
			createLabel("Cadastrar Cliente", BOLD_FONT[8]),
			
			createVerticalPanel(
				createLabel("Nome completo", PLAIN_FONT[4]),
				formNome = createTextField(ALLOW_ALL, 255)
			),
			
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("RG", PLAIN_FONT[4]),
					formRG = createTextField(ONLY_INTEGER, 15)
				),
				createVerticalPanel(
					createLabel("CPF", PLAIN_FONT[4]),
					formCPF = createTextField(ONLY_INTEGER, 11)
				)
			),
			
			createSeparator(20),
			
			createLabel("Endereço", PLAIN_FONT[5]),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("CEP", PLAIN_FONT[4]),
					formCEP = createTextField(ONLY_INTEGER, 8)
				),
				createVerticalPanel(
					createLabel("Logradouro", PLAIN_FONT[4]),
					formLogradouro = createTextField(ALLOW_ALL, 255)
				)
			),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("Número", PLAIN_FONT[4]),
					formNumero = createTextField(ONLY_INTEGER, 11)
				),
				createVerticalPanel(
					createLabel("Complemento", PLAIN_FONT[4]),
					formComplemento = createTextField(ALLOW_ALL, 32)
				),
				createVerticalPanel(
					createLabel("Bairro", PLAIN_FONT[4]),
					formBairro = createTextField(ALLOW_ALL, 64)
				)
			),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("Município", PLAIN_FONT[4]),
					formMunicipio = createTextField(ALLOW_ALL, 128)
				),
				createVerticalPanel(
					createLabel("Estado", PLAIN_FONT[4]),
					formEstado = createTextField(ALLOW_ALL, 2)
				)
			),
			
			createSeparator(20),
			
			formCadastrar = createButton("Cadastrar")
		);
	}
	public void configure() {
		formCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNome(formNome.getText());
				cliente.setRg(formRG.getText());
				cliente.setCpf(formCPF.getText());
				cliente.setCep(formCEP.getText());
				cliente.setLogradouro(formLogradouro.getText());
				cliente.setNumero(formNumero.getText());
				cliente.setComplemento(formComplemento.getText());
				cliente.setBairro(formBairro.getText());
				cliente.setMunicipio(formMunicipio.getText());
				cliente.setEstado(formEstado.getText());
				if(controller.ClienteController.insert(cliente)) {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					reloadScreen();
				} else {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar. Verifique as informações preenchidas (e caso dê erro, veja o console)");
				}
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
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(originalTableData[line][0]));
			cliente.setNome(tableData[line][1]);
			cliente.setCpf(tableData[line][2]);
			cliente.setRg(tableData[line][3]);
			cliente.setLogradouro(tableData[line][4]);
			cliente.setNumero(tableData[line][5]);
			cliente.setComplemento(tableData[line][6]);
			cliente.setBairro(tableData[line][7]);
			cliente.setMunicipio(tableData[line][8]);
			cliente.setCep(tableData[line][9]);
			cliente.setEstado(tableData[line][10]);
			controller.ClienteController.update(cliente);
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
						Cliente dataToDelete = new Cliente();
						dataToDelete.setId(Integer.parseInt(originalTableData[rowsToDelete[i]][0]));
						if(controller.ClienteController.delete(dataToDelete)) {
							ok++;
						}
					}
					JOptionPane.showMessageDialog(null, ok+" clientes removidos com sucesso\nA remoção de "+(rowsToDelete.length-ok)+" clientes falharam.");
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
