package view.elements;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarraSuperior extends JPanel {


	private static final long serialVersionUID = 3712589741683820517L;

	ActionListener actionListener;
	int topInset;
	
	public BarraSuperior(ActionListener actionListener, Rectangle position) {
		this.actionListener = actionListener;
		this.setBounds(position);
		setLayout(new GridLayout(1, 2));
		init("Gabriel Lopes Ferreira Ramos");
	}
	JLabel lblUsername = new JLabel("");
	JLabel lblDateTime = new JLabel("", JLabel.RIGHT);
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
	LocalDateTime now = LocalDateTime.now();
	public void init(String username) {
		setOpaque(true);
		setBackground(DefaultOptions.color[1]);
		String indent = "    ";
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		    @Override
		    public void run() {
		    	now = LocalDateTime.now();
				lblDateTime.setText(dtf.format(now)+indent);
		    }
		}, 0, 1000);
		lblUsername.setForeground(DefaultOptions.color[5]);
		lblUsername.setText(indent+username);
		lblUsername.setFont(DefaultOptions.font[0]);
		add(lblUsername);
		lblDateTime.setForeground(DefaultOptions.color[5]);
		lblDateTime.setText(dtf.format(now)+indent);
		lblDateTime.setFont(DefaultOptions.font[0]);
		add(lblDateTime);
	}
	
}
