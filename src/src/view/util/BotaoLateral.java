package view.util;

import java.awt.event.ActionListener;

public class BotaoLateral extends ButtonImage {

	private static final long serialVersionUID = -4222986057890172345L;
	
	public int code;
	
	public BotaoLateral(int code, String label, String image) {
		super(image);
		this.code = code;
		setToolTipText(label);
		setOpaque(true);
		setFocused(false);
	}
	public BotaoLateral(int code, String label, String image, ActionListener actionListener) {
		this(code, label, image);
		addActionListener(actionListener);
	}
	public void setFocused(boolean focus) {
		if(focus) {
			setBackground(DefaultOptions.COLOR[2]);
		} else {
			setBackground(DefaultOptions.COLOR[0]);
		}
		
	}
}
