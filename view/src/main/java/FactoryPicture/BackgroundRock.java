package FactoryPicture;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class BackgroundRock.
 */
public class BackgroundRock extends MotherTrad {
	
	/**
	 * Instantiates a new background rock.
	 */
	public BackgroundRock() {
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
			image = ImageIO.read(new File("../picture/BackgroundRock.png"));
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
