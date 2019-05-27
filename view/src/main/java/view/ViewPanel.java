package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import FactoryPicture.MotherTradFactory;

class ViewPanel extends JPanel{
	
	ViewFrame gframe;
	Image image;
	int Pixel = 32;
	MotherTradFactory Photo = new MotherTradFactory();
	char Tableau[][] = {
			{'4','5','1'},
			{'8','7','9'}};
	

	public ViewPanel(ViewFrame frame) {
		this.gframe = frame;
	}
	
	public void paintComponent(Graphics g) {
		generateBackground(g);
		
		for (int x = 0; x<gframe.getLargeur()/Pixel; x++) {
			paintElement(g, x, 1, 'A');
			paintElement(g, x, 2, ' ');
			paintElement(g, x, 3, 'T');
			paintElement(g, x, 4, 'X');
			paintElement(g, x, 5, 'E');
			paintElement(g, x, 6, 'D');
			paintElement(g, x, 7, 'O');
			paintElement(g, x, 8, 'L');
			paintElement(g, x, 9, 'K');
			paintElement(g, x, 10, 'M');
			paintElement(g, x, 11,'P');
		}
	}
	
	
	public void paintElement(Graphics g, int x, int y, char Caractere) {
		g.drawImage(Photo.getPhoto(Caractere), x * Pixel, y * Pixel, this);
	}
	
	public void generateBackground(Graphics g) {
		for (int y = 0; y < gframe.getLargeur()/Pixel+1; y++) {
			for (int x = 0; x < gframe.getLongueur()/Pixel+1; x++) {
			paintElement(g, x, y, ' ');
			}
			
	}
	}
}
