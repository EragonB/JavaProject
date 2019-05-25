package view;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

class ViewFrame extends JFrame {
	int Longueur = 1920;
	int Largeur = 1280;
	String Java = "Java fenêtre";
	
	
	public ViewFrame() {
	
		JFrame jframe = new JFrame();
		ViewPanel viewpanel = new ViewPanel(this);
		jframe.setSize(Longueur, Largeur);
		jframe.setLocationRelativeTo(null);
		jframe.setTitle(Java);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setContentPane(viewpanel);
		jframe.setVisible(true);
		
	}
	
	public int getLongeur()
	{
		return this.Longueur;
	}
	
	public int getLargeur()
	{
		return this.Largeur;
	}
	
	
}
