package view;

import javax.swing.JFrame;

import contract.IModel;

public class ViewFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private int Longueur = 800;
	private int Largeur = 800;

	private String Java = "BoulderDash";
	private ViewPanel viewpanel;
	
	public ViewFrame() {
	
		//JFrame jframe = new JFrame();
		this.setViewpanel(new ViewPanel(this));
		this.setSize(Longueur, Largeur);
		this.setLocationRelativeTo(null);
		this.setTitle(Java);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getViewpanel());
		this.setVisible(true);
		//jframe.addKeyListener(new KeyEvent());
		
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
	
	public void addObserver(IModel model)
	{
		model.getObservable().addObserver(getViewpanel());
	}
	
	
	
	
}
