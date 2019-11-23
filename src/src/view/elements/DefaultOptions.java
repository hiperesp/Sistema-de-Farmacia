package view.elements;

import java.awt.Color;
import java.awt.Font;

public final class DefaultOptions {

	public static Font[] font = new Font[] {
			new Font("Roboto", Font.PLAIN, 14),
			new Font("Roboto", Font.PLAIN, 16),
			new Font("Roboto", Font.PLAIN, 20),
			new Font("Roboto", Font.PLAIN, 24),
			new Font("Roboto", Font.PLAIN, 28),
			new Font("Roboto", Font.BOLD, 32),
			new Font("Roboto", Font.BOLD, 40),
	};
	public static Color[] color = new Color[] {
			new Color(0x8000ff),
			new Color(0x400080),
			new Color(0x200040),
			null,
			null,
			new Color(0xffffff)
	};
	
	public static void init() {
		
	}
}
