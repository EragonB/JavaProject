package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import FactoryPicture.MotherTradFactory;
import contract.IModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewFrame.
 */
public class ViewFrame extends JFrame {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Longueur. */
	private int Longueur = 800;
	
	/** The Largeur. */
	private int Largeur = 800;

	/** The Java. */
	private String Java = "BoulderDash";
	
	/** The viewpanel. */
	private ViewPanel viewpanel;
	
	
	/**
	 * Instantiates a new view frame.
	 *
	 * @param id_map the id map
	 */
	public ViewFrame(int id_map) {
		//setMapTaille(id_map);
		VuePrincipal();
		
	}
	
	
	/**
	 * Sets the map taille.
	 *
	 * @param id the new map taille
	 */
	public void setMapTaille(int id)
	{
		switch(id)
		{
		case 1:
			this.Longueur = 7*32 -16;
			this.Largeur  = 7*32 +16;
			break;
		case 2:
			this.Longueur = 7*32 -16;
			this.Largeur  = 7*32 +8;
			break;
		case 3:
			this.Longueur = 12*32 -16;
			this.Largeur  = 12*32 +16;
			break;
		case 4:
			this.Longueur = 22*32 -16;
			this.Largeur  = 23*32 +16;
			break;
		case 5:
			this.Longueur = 21*32 -16;
			this.Largeur  = 21*32 +16;
			break;
		}
	}
	
	/**
	 * Vue principal.
	 */
	public void VuePrincipal()
	{
		//JFrame Alfred = new JFrame();
		this.setViewpanel(new ViewPanel(this));
		this.setSize(Longueur, Largeur);
		this.setLocationRelativeTo(null);
		this.setTitle(Java);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getViewpanel());
		this.setVisible(true);
		
	}
	
	/**
	 * Frame die.
	 */
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
               g.drawImage( fact.getPhoto('9'), 0, 0 , this);
              g.drawString("YOU DIED !!!", 512/4, 512/2);
            }
        };
      

        jframedie.setSize(512, 512);
        jframedie.setLocationRelativeTo(null);
        jframedie.setTitle("Boby l'escagt");
        jframedie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframedie.setContentPane(panel);
        jframedie.setVisible(true);
        
        
        
        
    }
	
	/**
	 * Gets the longueur.
	 *
	 * @return the longueur
	 */
	public int getLongueur()
	{
		return this.Longueur;
	}
	
	/**
	 * Gets the largeur.
	 *
	 * @return the largeur
	 */
	public int getLargeur()
	{
		return this.Largeur;
	}

	/**
	 * Gets the viewpanel.
	 *
	 * @return the viewpanel
	 */
	public ViewPanel getViewpanel() {
		return this.viewpanel;
	}

	/**
	 * Sets the viewpanel.
	 *
	 * @param viewpanel the viewpanel to set
	 */
	public void setViewpanel(ViewPanel viewpanel) {
		this.viewpanel = viewpanel;
	}
	
	/**
	 * Adds the observer.
	 *
	 * @param model the model
	 */
	public void addObserver(IModel model)
	{
		model.getObservable().addObserver(getViewpanel());
	}
	
	
	
	
}
