package manu.java.misc;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


/*
 * 
 * https://www.baeldung.com/ascii-art-in-java
 * https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java/src/main/java/com/baeldung/asciiart/AsciiArt.java
 * 
 */
public class AsciiArt {

	int size = 40;
	String str = "a b c d e f g h i j k l m n ñ o p q r s t u v w x y z";
	String str2 = "A B C D E F G H I J K L M N Ñ O P Q R S T U V W X Y Z";
	String font0 = "";
	String font1 = "Ink Free";
	String font2 = "Courier New";
	String font3 = "Segoe Print";
	String font4 = "Segoe Script";

	public AsciiArt() {
		run();
	}

	public void run() {
		Font fo22 = new Font(font4, 0, size);
		Settings set22 = new Settings(fo22, size * str.length() * 2 / 3, size * 3 / 2);

		drawString(str, "#", set22);
//		drawString(str2, "#", set22);
	}

	public static void main(String[] args) {
		AsciiArt kk22 = new AsciiArt();
	}

	public void drawString(String text, String artChar, Settings settings) {
		BufferedImage image = getImageIntegerMode(settings.width, settings.height);

		Graphics2D graphics2D = getGraphics2D(image.getGraphics(), settings);
		graphics2D.drawString(text, 6, ((int) (settings.height * 0.67)));

		for (int y = 0; y < settings.height; y++) {
			StringBuilder stringBuilder = new StringBuilder();

			for (int x = 0; x < settings.width; x++) {
				stringBuilder.append(image.getRGB(x, y) == -16777216 ? " " : artChar);
			}

			if (stringBuilder.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(stringBuilder);
		}

	}

	private BufferedImage getImageIntegerMode(int width, int height) {
		return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}

	private Graphics2D getGraphics2D(Graphics graphics, Settings settings) {
		graphics.setFont(settings.font);

		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		return graphics2D;
	}

	public class Settings {
		public Font font;
		public int width;
		public int height;

		public Settings(Font font, int width, int height) {
			this.font = font;
			this.width = width;
			this.height = height;
		}
	}
}