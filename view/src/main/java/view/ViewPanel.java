package view;

import java.awt.Graphics;

import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import FactoryPicture.MotherTradFactory;
import contract.IMap;

/**
 * The Class ViewPanel.
 */
class ViewPanel extends JPanel implements Observer{

	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3886802783058179085L;

	/** The map. */
	IMap map;

	/** The gframe. */
	ViewFrame gframe;
	
	/** The image. */
	Image image;
	
	/** The Pixel. */
	int Pixel = 32;
	
	/** The Photo. */
	MotherTradFactory Photo = new MotherTradFactory();
	

	public Observer getObserverViewPanel()
	{
		return this;
	}
	
	/**
	 * Instantiates a new view panel.
	 *
	 * @param frame the frame
	 */
	public ViewPanel(ViewFrame frame) {
		this.gframe = frame;
		
	}
	
	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	public void paintComponent(Graphics g) {
				
		BoardRead(g);
	}
	
	/**
	 * Board read.
	 *
	 * @param g the g
	 */
	public void BoardRead(Graphics g) {
			
		
		for (int y = 0; y < this.map.getHeight(); y++) {
			for (int x = 0; x < this.map.getWidth(); x++) {
				
			paintElement(g, x, y, this.map.getOnTheMapXY(x, y).getSprite());
			
			}
		
		}
	}
	
	
	/**
	 * Paint element.
	 *
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 * @param Caractere the caractere
	 */
	public void paintElement(Graphics g, int x, int y, char Caractere) {
		Image a = Photo.getPhoto(Caractere);
		g.drawImage(a , x * Pixel, y * Pixel, this);
	}
	
	public JPanel getPanel()
	{
		return this;
	}
	
		
	/**
	 * Loadmap.
	 *
	 * @param map the map
	 */
	public void loadmap(IMap map)
	{
		this.map=map;
	}
	
	/**
	 * Update.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}
}
