package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import PictureFactory.TradFactory;

class ViewPanel extends JPanel{
	
	ViewFrame frame;
	int sizePicture = 32;
	TradFactory FactoryPicture = new TradFactory();
	
	char Tableau[][] = {
			{'4','5','1'},
			{'8','7','9'}};

	
	public ViewPanel(ViewFrame frame) 
	{
		this.frame = frame;
	}
	
	public void paintComponent(Graphics g) {

		generatedBackGround(g);
		
		for (int a=0; a< frame.getLongeur(); a++)
		{
			paintElement(g, a, 1, 'T');
			paintElement(g, a, 9, 'T');
			
			paintElement(g, a, 8, 'E');
			
			paintElement(g, a, 2, 'P');
			paintElement(g, a, 5, 'D');	
			
			paintElement(g, a, 0, 'X');
			paintElement(g, a, 10, 'X');	
			
			paintElement(g, a, 3, 'O');
			paintElement(g, a, 4, 'L');
			
			paintElement(g, a, 6, 'K');
			paintElement(g, a, 7, 'M');	
		}
	}
	
	public void paintElement(Graphics g, int x, int y, char Valeur)
	{
		g.drawImage(FactoryPicture.getPicture(Valeur), x *sizePicture, y* sizePicture, this);
	}

	
	public void generatedBackGround(Graphics g)
	{

		for(int x = 0; x< (frame.getLongeur()/32 + 1); x++) {
			
			for(int y = 0; y< (frame.getLargeur()/32 + 1) ; y++) {
				
				g.drawImage(FactoryPicture.getPicture(' '), x *sizePicture, y* sizePicture, this);
			}
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
}
