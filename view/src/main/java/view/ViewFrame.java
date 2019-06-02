package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import FactoryPicture.MotherTradFactory;
import contract.IModel;

public class ViewFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private int Longueur = 800;
	private int Largeur = 800;

	private String Java = "BoulderDash";
	private ViewPanel viewpanel;
	
	
	public ViewFrame() {
	
		this.setViewpanel(new ViewPanel(this));
		this.setSize(Longueur, Largeur);
		this.setLocationRelativeTo(null);
		this.setTitle(Java);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getViewpanel());
		this.setVisible(true);
		//FrameDie();
	}
	
	public static void FrameDie() {
        
        JFrame jframedie = new JFrame();
        MotherTradFactory fact = new MotherTradFactory();
        JPanel panel = new JPanel()
                {
            
            public void paint(Graphics g)
            {
                Font font = new Font("Consola", Font.PLAIN, 50);
                  g.setColor(Color.RED);
               g.setFont(font);
               g.drawImage( fact.getPhoto('9'), 0, 0 , null);
              g.drawString("YOU DIED !!!", 512/2, 512/2);
            }
              
                };
      

        jframedie.setSize(512, 512);
        jframedie.setLocationRelativeTo(null);
        jframedie.setTitle("Boby l'escagt");
        jframedie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframedie.setContentPane(panel);
        jframedie.setVisible(true);
        
        
        
        
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
