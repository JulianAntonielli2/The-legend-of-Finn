package theLegendOfFinn.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

//Cambiar toda la clase basicamente...
public class MenuRenderer implements Renderer {
	private BufferedImage backGroundImage;

	public MenuRenderer() {
		try {
			backGroundImage = ImageIO.read(new File("./Assets/pixelmenu.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public enum Option {
		NUEVO, CARGAR;
	}

	private Option option = Option.NUEVO;

	public void render(Graphics g) {
		g.drawImage(backGroundImage, 0, 0, MasterRenderer.WIDTH, MasterRenderer.HEIGHT, null);
		g.setColor(Color.RED);
		if (option.equals(Option.NUEVO)) {
			g.drawRect(34, 314, 164, 60);
		} else {
			g.drawRect(456, 314, 164, 60);
		}
	}

	public void changeOption() {
		if (this.option.equals(Option.NUEVO))
			this.option = Option.CARGAR;
		else
			this.option = Option.NUEVO;
	}

	public Option getOption() {
		return option;
	}
}
