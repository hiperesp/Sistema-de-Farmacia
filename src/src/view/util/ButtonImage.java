package view.util;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonImage extends JButton {

	private static final long serialVersionUID = 5159530966367161010L;

	Image image;
	int width = 100, height = 100;
	
	public ButtonImage(String image) {
		super();
		setImage(image);
		setBorder(null);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
	private void updateIcon() {
		setIcon(new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
	}
	public void setWidth(int width) {
		this.width = width;
		updateIcon();
	}
	public void setHeight(int height) {
		this.height = height;
		updateIcon();
	}
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		updateIcon();
	}
	public void setImage(String image) {
		try {
			this.image = ImageIO.read(new File(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateIcon();
	}
}
