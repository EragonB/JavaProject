package FactoryPicture;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DeathHead extends MotherTrad {
	public DeathHead() {
		getPicture();
	}
	
	public Image getPicture() {
		Image image;
		try {
			image = ImageIO.read(new File("../picture/Death.png"));
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
