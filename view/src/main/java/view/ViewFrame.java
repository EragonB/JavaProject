package view;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

class ViewFrame extends JFrame {
	int Longueur = 400;
	int Largeur = 800;
	String Java = "Java fenêtre";
	
	
	public ViewFrame() {
	
		JFrame jframe = new JFrame();
		ViewPanel viewpanel = new ViewPanel();
		jframe.setSize(Longueur, Largeur);
		jframe.setLocationRelativeTo(null);
		jframe.setTitle(Java);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setContentPane(viewpanel);
		jframe.setVisible(true);
		
	}
	
	
}
