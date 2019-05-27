package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ViewPanel extends JPanel{
	
	ViewFrame gframe;
	Image image;
	int Pixel = 32;

	public ViewPanel(ViewFrame frame) {
		this.gframe = frame;
	}
	
	public void paintComponent(Graphics g) {
		
		try {
			image = ImageIO.read(new File("../picture/BackgroundRock.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		int y = 10;
		for (int ii = 0; ii < gframe.getLargeur()/Pixel; ii++) {
			int x  = 10;
			for (int i = 0; i < gframe.getLongueur()/Pixel; i++) {
				//g.drawString(String.valueOf(Tableau[ii][i]), x, y);
				g.drawImage(image, i * Pixel , ii * Pixel, this);
				x = x + 10;
			}
			y = y + 10;
		}
	}
	
	char Tableau[][] = {
			{'4','5','1'},
			{'8','7','9'}};
	
	char Contenu = 'C';
	
	public char Affiche() {
		/*for(int x = 0; x<2; x++) {
			for(int y = 0; y<3; y++) {
				return Tableau[x][y];
			}
		}*/
		 
		return Contenu;
	}

}
