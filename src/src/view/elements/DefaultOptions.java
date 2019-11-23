package view.elements;

import java.awt.Color;
import java.awt.Font;

public final class DefaultOptions {

	public static Font[] plainFont;
	public static Font[] boldFont;
	public static Color[] color = new Color[] {
			new Color(0x8000ff),
			new Color(0x400080),
			new Color(0x200040),
			new Color(0xffffff)
	};
	
	public static void init() {
		int[] fontSizes = new int[] {14, 16, 20, 24, 28, 32, 36, 40, 42, 46, 48, 52, 56, 60, 64, 68, 72};
		String fontName = "Roboto";
		{
			plainFont = new Font[fontSizes.length];
			boldFont = new Font[fontSizes.length];
			for(int i=0; i<fontSizes.length; i++) {
				plainFont[i] = new Font(fontName, Font.PLAIN, fontSizes[i]);
				boldFont[i] = new Font(fontName, Font.BOLD, fontSizes[i]);
			}
		}
	}
}
