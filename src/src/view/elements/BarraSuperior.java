package view.elements;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import view.Interface;
import view.util.DefaultOptions;
import view.util.MotionPanel;

public class BarraSuperior extends MotionPanel implements DefaultOptions {


	private static final long serialVersionUID = 3712589741683820517L;

	JFrame parent;
	ActionListener actionListener;
	int topInset;
	
	public BarraSuperior(JFrame parent, boolean enableMotionPanel, Rectangle position) {
		super(parent, enableMotionPanel);
		this.parent = parent;
		this.actionListener = (ActionListener)parent;
		this.setBounds(position);
		setLayout(null);
		init();
	}
	
	public JButton toggleMenu;
	public JButton minimizeButton;
	public JButton closeButton;
	
	JLabel lblUsername;
	JLabel lblDateTime;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
	LocalDateTime now = LocalDateTime.now();
	public void init() {
		configureScreen();
		addElements();
		enableTimer();
	}
	public void configureScreen() {
		setOpaque(true);
		setBackground(COLOR[1]);
	}
	public void addElements() {
		toggleMenu = addButton("Menu", new Rectangle(0, 0, ((Interface)parent).barraLateral.getWidth(), getHeight()));
		closeButton = addButton("\u00D7", new Rectangle((int) (getWidth()-getHeight()*1.5), 0, (int)(getHeight()*1.5), getHeight()));
		minimizeButton = addButton("\u2212", new Rectangle((int) (getWidth()-getHeight()*1.5*2), 0, (int)(getHeight()*1.5), getHeight()));
		
		lblUsername = addJLabel("Farm", new Rectangle(0, 0, getWidth(), getHeight()), JLabel.CENTER);
		lblDateTime = addJLabel("", new Rectangle(closeButton.getX()-200, 0, 200, getHeight()), JLabel.LEFT);
	}
	
	JLabel addJLabel(String title, Rectangle bounds, int alignment) {
		JLabel label = new JLabel(title, alignment);
		label.setForeground(COLOR[3]);
		label.setFont(PLAIN_FONT[1]);
		label.setBounds(bounds);
		add(label);
		return label;
	}
	
	JButton addButton(String title, Rectangle bounds){
		JButton button = new JButton(title);
		button.setBounds(bounds);
		button.setBackground(COLOR[0]);
		button.setFont(PLAIN_FONT[1]);
		button.setForeground(COLOR[3]);
		button.setBorder(null);
		button.setFocusable(false);
		button.addActionListener(actionListener);
		add(button);
		return button;
	}
	public void enableTimer() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		    @Override
		    public void run() {
		    	now = LocalDateTime.now();
				lblDateTime.setText(dtf.format(now));
		    }
		}, 0, 1000);
	}
	
}
