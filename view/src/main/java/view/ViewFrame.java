package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import FactoryPicture.MotherTradFactory;

/**
 * The Class ViewFrame.
 */
public class ViewFrame extends JFrame{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Longueur. */
	private int height = 800;
	
	/** The Largeur. */
	private int width = 800;

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
		mainView();
	}
	
	
	public JFrame getFrame()
	{
		return this;
	}
	
	
	public void mainView()
	{
		this.setViewpanel(new ViewPanel(this));
		this.setSize(height, width);
		this.setLocationRelativeTo(null);
		this.setTitle(Java);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getViewpanel().getPanel());
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
	
	
	@Override
	public int getHeight()
	{
		return this.height;
	}
	
	@Override
	public int getWidth()
	{
		return this.width;
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

	
	
}
