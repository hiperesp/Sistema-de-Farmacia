package view;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.elements.BarraLateral;
import view.elements.BarraSuperior;
import view.elements.Tela;
import view.util.BotaoLateral;
import view.util.InterfaceConstants;

public class Interface extends JFrame implements InterfaceConstants, ActionListener {

	private static final boolean FULLSCREEN_MODE = true;
	
	private static final int TELA_INICIAL = TELA_VENDAS;
	
	public boolean logged = false;

	private static final long serialVersionUID = 6135689381761687013L;
	
	public Interface() {
		try {
			/*int themeIndex = -1;
			if(themeIndex==-1) InterfaceConstants.setTheme(javax.swing.UIManager.getSystemLookAndFeelClassName());
			else InterfaceConstants.setTheme(InterfaceConstants.getThemes()[themeIndex].getClassName());*/
		} catch(Exception e) {}
		setTitle("Farm");
		if(FULLSCREEN_MODE) {
		    setSize(Toolkit.getDefaultToolkit().getScreenSize());
			setExtendedState(MAXIMIZED_BOTH); 
		} else {
			//setSize(new Dimension(640, 480));
			//setSize(new Dimension(720, 480));
			//setSize(new Dimension(800, 480));
			//setSize(new Dimension(800, 600));
			//setSize(new Dimension(1024, 600));
			//setSize(new Dimension(1024, 768));
			setSize(new Dimension(1280, 720));
			//setSize(new Dimension(1366, 768));
			//setSize(new Dimension(1920, 1080));
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLayout(null);
		init();
		setVisible(true);
	}
	
	private void init() {
		initBarraLateral();
		initBarraSuperior();
		initTela();
	}
	
	public BarraLateral barraLateral;
	public BarraSuperior barraSuperior;
	Tela tela;
	
	private void initBarraLateral(){
		barraLateral = new BarraLateral(this, 32, getHeight()-32);
		add(barraLateral);
	}
	private void initBarraSuperior(){
		barraSuperior = new BarraSuperior(this, !FULLSCREEN_MODE, new Rectangle(0, 0, getWidth(), 32));
		add(barraSuperior);
	}
	
	public void initTela(){
		tela = new Tela(TELA_LOGIN, new Rectangle(barraLateral.getWidth(), barraSuperior.getHeight(), getWidth()-barraLateral.getWidth(), getHeight()-barraSuperior.getHeight()), this);
		add(tela);
	}
	
	public void setTela(int tela) {
		this.tela.setTela(tela);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if(BotaoLateral.class.isInstance(source)) {
			int telaCode = ((BotaoLateral)source).code;
			if(telaCode>FEATURES) {
				switch(telaCode) {
				case AUMENTAR_TELA: tela.getTelaAtual().switchWidth(); break;
				case LOGOUT: logout(); break;
				}
			} else if(telaCode>TELA) {
				if(logged) {
					barraLateral.setFocusButton(telaCode);
					setTela(telaCode);
				} else {
					JOptionPane.showMessageDialog(this, "Faça o login antes de fazer isso.");
				}
			}
		} else if(source==barraSuperior.toggleMenu) {
			Rectangle telaBounds = tela.getBounds();
			if(barraLateral.isVisible()) {
				barraLateral.setVisible(false);
				telaBounds.x = 0;
				telaBounds.width = getWidth();
			} else {
				barraLateral.setVisible(true);
				telaBounds.x = barraLateral.getWidth();
				telaBounds.width = getWidth()-barraLateral.getWidth();
			}
			tela.setBounds(telaBounds);
		} else if(source==barraSuperior.closeButton) {
			System.exit(0);
		} else if(source==barraSuperior.minimizeButton) {
			setState(ICONIFIED);
		}
	}
	public void loginOk() {
		logged = true;
		barraLateral.setFocusButton(TELA_INICIAL);
		setTela(TELA_INICIAL);
	}
	public void logout() {
		logged = false;
		barraLateral.setFocusButton(null);
		setTela(TELA_LOGIN);
	}
}
