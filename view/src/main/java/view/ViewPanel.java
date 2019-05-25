package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ViewPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		g.drawString("iofdjvdkjssiodesoezkdszios"/*String.valueOf(Affiche())*/, 40, 80);
		Affiche(Tableau);
		g.drawImage(GetImageTest(), 50, 50, this);
		GetImageTest();

	}
	
	char Tableau[][] = {
			{'4','5','1'},
			{'8','7','9'}};
	
	char Contenu = 'C';
	
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
			Image PictureDirt = ImageIO.read(new File("C:\\Users\\maire\\git\\JavaProject\\picture\\Stone.png"));
			return PictureDirt;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
