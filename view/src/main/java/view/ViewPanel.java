package view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class ViewPanel extends JPanel{

	
	public void paintComponent(Graphics g) {
	
		int y = 10;
		for (int ii = 0; ii < 2; ii++) {
			int x  = 10;
			for (int i = 0; i < 3; i++) {
				g.drawString(String.valueOf(Tableau[ii][i]), x, y);
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
