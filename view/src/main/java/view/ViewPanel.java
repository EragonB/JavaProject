package view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class ViewPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		g.drawString("iofdjvdkjssiodesoezkdszios"/*String.valueOf(Affiche())*/, 40, 80);
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
