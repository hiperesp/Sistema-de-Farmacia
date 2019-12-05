package view.telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Funcionario;
import view.Interface;
import view.util.FormElements;
import view.util.TableListener;
import view.util.Tela;
import view.util.VerticalPanel;

public class TelaLogin extends Tela implements FormElements, TableListener {
	private static final long serialVersionUID = -6432091958862873077L;

	private static GridLayout layoutManager = new GridLayout(1,3);
	
	private Interface pInterface;
	
	public TelaLogin(Interface pInterface) {
		super(layoutManager);
		this.pInterface = pInterface;
		switchWidth();
	}
	
	JTextField formLogin, formSenha;
	JButton formCadastrar;
	
	VerticalPanel form;
	
	String[] tableHeader;
	String[][] tableData;
	String[][] originalTableData;
	
	public void addElements() {
		add(createSeparator());
		add(createForm());
		add(createSeparator());
		configure();
	}
	
	public VerticalPanel createForm() {
		return form = new VerticalPanel(
			
			createLabel("Efetuar Login", BOLD_FONT[8]),
			
			createVerticalPanel(
				createLabel("Código", PLAIN_FONT[4]),
				formLogin = createTextField(ONLY_INTEGER, 11)
			),
			
			createVerticalPanel(
				createLabel("Senha", PLAIN_FONT[4]),
				formSenha = createPasswordField()
			),
			
			createSeparator(20),
			
			formCadastrar = createButton("Login")
		);
	}
	public void configure() {
		formCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario funcionario = new Funcionario();
					funcionario.setIdFuncionario(Integer.parseInt(formLogin.getText()));
					funcionario.setSenhaFuncionario(formSenha.getText());
					if(controller.FuncionarioController.login(funcionario)) {
						JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
						pInterface.loginOk();
					} else {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazer o login. Verifique as informações preenchidas (e caso dê erro, veja o console)");
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
	public void propertyChange(PropertyChangeEvent evt) {  }

	@Override
	public void keyPressed(KeyEvent e) { }
	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyTyped(KeyEvent e) { }
	
	boolean isDefaultWidth = true;
	@Override
	public void switchWidth() { }
}
