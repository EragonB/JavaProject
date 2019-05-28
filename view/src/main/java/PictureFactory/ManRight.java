package PictureFactory;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ManRight extends MotherTrad {

	
	public ManRight()
	{
		getPicture();
	}
	
	public Image getPicture()
	{
		Image Val;
		try {
			Val = ImageIO.read(new File("../picture/ManRight.png"));
			return Val;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
	}
}
