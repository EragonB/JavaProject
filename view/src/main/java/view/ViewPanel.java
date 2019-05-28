package view;

import java.awt.Graphics;

import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import FactoryPicture.MotherTradFactory;
import contract.IMap;

class ViewPanel extends JPanel implements Observer{

	

	private static final long serialVersionUID = -3886802783058179085L;

IMap map;

	ViewFrame gframe;
	Image image;
	int Pixel = 32;
	MotherTradFactory Photo = new MotherTradFactory();
	

	public ViewPanel(ViewFrame frame) {
		this.gframe = frame;
		
	}
	
	public void paintComponent(Graphics g) {
				
		BoardRead(g);
	}
	
	public void BoardRead(Graphics g) {
			
		
		for (int y = 0; y < this.map.getHeight(); y++) {
			for (int x = 0; x < this.map.getWidth(); x++) {
				
			paintElement(g, x, y, this.map.getOnTheMapXY(x, y).getSprite());
			
			}
		
		}
	}
	
	
	public void paintElement(Graphics g, int x, int y, char Caractere) {
		Image a = Photo.getPhoto(Caractere);
		g.drawImage(a , x * Pixel, y * Pixel, this);
	}
	
	
	
public void loadmap(IMap map)
{
	this.map=map;
}

@Override
public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	this.repaint();
}
}
