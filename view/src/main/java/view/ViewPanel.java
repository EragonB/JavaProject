package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ViewPanel extends JPanel{
	
	ViewFrame frame;
	int sizePicture = 32;
	
	char Tableau[][] = {
			{'4','5','1'},
			{'8','7','9'}};
	
	char Contenu = 'C';
	
	
	public ViewPanel(ViewFrame frame) 
	{
		this.frame = frame;
	}
	
	public void paintComponent(Graphics g) {
		
		//g.drawString("iofdjvdkjssiodesoezkdszios"/*String.valueOf(Affiche())*/, 40, 80);
		//Affiche(Tableau);
		//g.drawImage(GetImageTest(), 50, 50, this);

		//System.out.println(frame.getLargeur()/32);
		//System.out.println(frame.getLongeur()/32);
		generatedBackGround(g);
		
	}
	
	public void generatedBackGround(Graphics g)
	{
		try {
			Image PictureDirt = ImageIO.read(new File("../picture/BackgroundRock.png"));
			
			
			for(int x = 0; x< (frame.getLongeur()/32 + 1); x++) {
				
				for(int y = 0; y< (frame.getLargeur()/32 + 1) ; y++) {
					g.drawImage(PictureDirt, x *sizePicture, y* sizePicture, this);
				}
			}
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void Affiche(char[][] tableau) {
		for(int x = 0; x<2; x++) {
			for(int y = 0; y<3; y++) {
				System.out.print(tableau[x][y]);
			}
			System.out.println();
		}
	}

	public Image GetImageTest()
	{
		try {
			Image PictureDirt = ImageIO.read(new File("C:\\Users\\maire\\git\\JavaProject\\picture\\BackgroundRock.png"));
			return PictureDirt;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
