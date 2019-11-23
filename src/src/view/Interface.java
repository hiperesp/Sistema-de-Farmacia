package view;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.elements.BarraLateral;
import view.elements.BarraSuperior;
import view.elements.DefaultOptions;
import view.elements.Tela;
import view.util.BotaoLateral;
import view.util.InterfacePadraoConstants;

public class Interface extends JFrame implements InterfacePadraoConstants, ActionListener {
	
	private static final long serialVersionUID = 6135689381761687013L;
	
	private static final int TELA_INICIAL = TELA_CLIENTES;

	private static final boolean FULLSCREEN_MODE = false;
	
	public Interface() {
		DefaultOptions.init();
		try {
			//javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {}
		setTitle("Farm");
		if(FULLSCREEN_MODE) {
		    setSize(Toolkit.getDefaultToolkit().getScreenSize());
			setExtendedState(MAXIMIZED_BOTH); 
		} else {
			setSize(new Dimension(1024, 600));
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
	
	BarraLateral barraLateral;
	BarraSuperior barraSuperior;
	Tela tela;
	private void initBarraLateral(){
		barraLateral = new BarraLateral(this, getHeight());
		add(barraLateral);
	}
	private void initBarraSuperior(){
		barraSuperior = new BarraSuperior(this, !FULLSCREEN_MODE, new Rectangle(barraLateral.getWidth(), 0, getWidth()-barraLateral.getWidth(), 32));
		add(barraSuperior);
	}
	
	public void initTela(){
		barraLateral.setFocusButton(TELA_INICIAL);
		tela = new Tela(TELA_INICIAL);
		tela.setBounds(barraLateral.getWidth(), barraSuperior.getHeight(), getWidth()-barraLateral.getWidth(), getHeight()-barraSuperior.getHeight());
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
			barraLateral.setFocusButton(telaCode);
			setTela(telaCode);
		}
	}
}
