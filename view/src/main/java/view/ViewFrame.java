package view;

import javax.swing.JFrame;

class ViewFrame extends JFrame {

	int Longueur = 800;
	int Largeur = 400;

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
	
	public int getLongueur()
	{
		return this.Longueur;
	}
	
	public int getLargeur()
	{
		return this.Largeur;
	}
	
	
}
