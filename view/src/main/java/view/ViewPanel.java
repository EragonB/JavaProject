package view;

import java.awt.Graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import PictureFactory.TradFactory;

import FactoryPicture.MotherTradFactory;

class ViewPanel extends JPanel{
	

	ViewFrame gframe;
	Image image;
	int Pixel = 32;
	MotherTradFactory Photo = new MotherTradFactory();
	char Tableau[][] = {
			{'T',' ','D'},
			{'X','P','A'}};
	

	public ViewPanel(ViewFrame frame) {
		this.gframe = frame;
	}
	
	public void paintComponent(Graphics g) {
		generateBackground(g);	
		BoardRead(g);
	
	}
	
	public void BoardRead(Graphics g) {
		
		int Width;
		
		if (Tableau.length == 0)
			Width = 0;
		else
			Width = Tableau[0].length;
		for (int y = 0; y < Tableau.length; y++) {
			for (int x = 0; x < Width; x++) {
			paintElement(g, x, y, Tableau[y][x]);
			}
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
