package FactoryPicture;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManRight.
 */
public class ManRight extends MotherTrad {
	
	/**
	 * Instantiates a new man right.
	 */
	public ManRight() {
		getPicture();
	}
	
	/**
	 * Gets the picture.
	 *
	 * @return the picture
	 */
	public Image getPicture() {
		Image image;
		try {
			image = ImageIO.read(new File("../picture/ManRight.png"));
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
