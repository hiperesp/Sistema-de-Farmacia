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
import model.Funcionario;
import view.util.FormElements;
import view.util.TableListener;
import view.util.Tela;
import view.util.VerticalPanel;

public class TelaFuncionarios extends Tela implements FormElements, TableListener {
	private static final long serialVersionUID = -6432091958862873077L;

	private static GridLayout layoutManager = new GridLayout(1,2);
	
	public TelaFuncionarios() {
		super(layoutManager);
		switchWidth();
	}
	
	JTextField formNome, formRG, formCPF, formContaBanco, formAgenciaBanco, formNomeBanco, formSenha, formCEP, formLogradouro, formNumero
			 , formComplemento, formBairro, formMunicipio, formEstado;
	JButton formCadastrar;
	
	VerticalPanel form, list;
	
	String[] tableHeader;
	String[][] tableData;
	String[][] originalTableData;
	
	public void addElements() {
		tableData = controller.FuncionarioController.select();
		originalTableData = controller.FuncionarioController.select();
		add(createList());
		add(createForm());
		configure();
	}
	
	public VerticalPanel createList() {
		tableHeader = new String[] { "Código", "Nome", "Senha", "CPF", "RG", "Conta", "Agência", "Banco"/*, "Logradouro", "Número", "Complemento", "Município", "Bairro", "CEP", "Estado"*/ };

		list = new VerticalPanel(
				createLabel("Funcionários Cadastrados", BOLD_FONT[8]),
				
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
			
			createLabel("Cadastrar Funcionário", BOLD_FONT[8]),
			
			createVerticalPanel(
				createLabel("Nome completo", PLAIN_FONT[4]),
				formNome = createTextField(ALLOW_ALL, 255)
			),
			
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("Senha", PLAIN_FONT[4]),
					formSenha = createPasswordField()
				)
			),
			
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("RG", PLAIN_FONT[4]),
					formRG = createTextField(ONLY_INTEGER, 11)
				),
				createVerticalPanel(
					createLabel("CPF", PLAIN_FONT[4]),
					formCPF = createTextField(ONLY_INTEGER, 11)
				)
			),
			
			createSeparator(20),

			createLabel("Dados bancários", PLAIN_FONT[5]),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("Conta", PLAIN_FONT[4]),
					formContaBanco = createTextField(ONLY_INTEGER, 8)
				),
				createVerticalPanel(
					createLabel("Agência", PLAIN_FONT[4]),
					formAgenciaBanco = createTextField(ONLY_INTEGER, 6)
				)
			),
			createHorizontalPanel(
				createVerticalPanel(
					createLabel("Banco", PLAIN_FONT[4]),
					formNomeBanco = createTextField(ALLOW_ALL, 20)
				)
			),
/*			
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
			),*/
			
			createSeparator(20),
			
			formCadastrar = createButton("Cadastrar")
		);
	}
	public void configure() {
		formCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario funcionario = new Funcionario();
					funcionario.setNomeFuncionario(formNome.getText());
					funcionario.setSenhaFuncionario(formSenha.getText());
					funcionario.setRgFuncionario(formRG.getText());
					funcionario.setCpfFuncionario(formCPF.getText());
					/*funcionario.setCepFuncionario(formCEP.getText());
					funcionario.setLogradouroFuncionario(formLogradouro.getText());
					funcionario.setNumFuncionario(Integer.parseInt(formNumero.getText()));
					funcionario.setComplFuncionario(formComplemento.getText());
					funcionario.setBairroFuncionario(formBairro.getText());
					funcionario.setCidadeFuncionario(formMunicipio.getText());
					funcionario.setUfFuncionario(formEstado.getText());*/
					funcionario.setContaBancoFuncionario(formContaBanco.getText());
					funcionario.setAgenciaFuncionario(formAgenciaBanco.getText());
					funcionario.setNomeBancoFuncionario(formNomeBanco.getText());
					if(controller.FuncionarioController.insert(funcionario)) {
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
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(Integer.parseInt(originalTableData[line][0]));
				funcionario.setNomeFuncionario(tableData[line][1]);
				funcionario.setSenhaFuncionario(tableData[line][2]);
				funcionario.setCpfFuncionario(tableData[line][3]);
				funcionario.setRgFuncionario(tableData[line][4]);
				funcionario.setContaBancoFuncionario(tableData[line][5]);
				funcionario.setAgenciaFuncionario(tableData[line][6]);
				funcionario.setNomeBancoFuncionario(tableData[line][7]);/*
				funcionario.setLogradouroFuncionario(tableData[line][9]);
				funcionario.setNumFuncionario(Integer.parseInt(tableData[line][10]));
				funcionario.setComplFuncionario(tableData[line][11]);
				funcionario.setBairroFuncionario(tableData[line][12]);
				funcionario.setCidadeFuncionario(tableData[line][13]);
				funcionario.setCepFuncionario(tableData[line][14]);
				funcionario.setUfFuncionario(tableData[line][15]);*/
				controller.FuncionarioController.update(funcionario);
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
						Funcionario dataToDelete = new Funcionario();
						dataToDelete.setIdFuncionario(Integer.parseInt(originalTableData[rowsToDelete[i]][0]));
						if(controller.FuncionarioController.delete(dataToDelete)) {
							ok++;
						}
					}
					JOptionPane.showMessageDialog(null, ok+" funcionários removidos com sucesso\nA remoção de "+(rowsToDelete.length-ok)+" funcionários falharam.");
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
