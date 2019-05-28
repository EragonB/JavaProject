package view;

import javax.swing.JFrame;

public class ViewFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private int Longueur = 800;
	private int Largeur = 800;

	private String Java = "BoulderDash";
	private ViewPanel viewpanel;
	
	public ViewFrame() {
	
		JFrame jframe = new JFrame();
		this.setViewpanel(new ViewPanel(this));
		jframe.setSize(Longueur, Largeur);
		jframe.setLocationRelativeTo(null);
		jframe.setTitle(Java);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setContentPane(getViewpanel());
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

	/**
	 * @return the viewpanel
	 */
	public ViewPanel getViewpanel() {
		return this.viewpanel;
	}

	/**
	 * @param viewpanel the viewpanel to set
	 */
	public void setViewpanel(ViewPanel viewpanel) {
		this.viewpanel = viewpanel;
	}
	
	
}
