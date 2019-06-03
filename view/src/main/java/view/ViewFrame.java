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
	public  void FrameDie(int value) {
        this.setVisible(false);

        MotherTradFactory fact = new MotherTradFactory();
        
        if(value==0)
        {
            JFrame jframedie = new JFrame();
            jframedie.setTitle("BoulderDie");
            jframedie.setSize(512, 512);
            jframedie.setLocationRelativeTo(null);
            
            jframedie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
            JPanel panel = new JPanel()
            {

                public void paint(Graphics a)
                {
                    
                    Font font = new Font("Consola", Font.PLAIN, 50);
                      a.setColor(Color.RED);
                   a.setFont(font);
                   a.drawImage( fact.getPhoto('9'), 0, 0 , jframedie);
                  a.drawString("YOU DIED !!!", 512/4, 512/2);
                }
            };
          

      
            jframedie.setContentPane(panel);
            jframedie.setVisible(true);
                    }
        else {
            JFrame jframewin = new JFrame();
            jframewin.setTitle("BoulderWin");
            jframewin.setSize(512, 512);
            jframewin.setLocationRelativeTo(null);
            
            jframewin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
            JPanel panel = new JPanel()
            {

                public void paint(Graphics a)
                {
                    
                    Font font = new Font("Comic Sans MS", Font.BOLD, 50);
                      a.setColor(Color.MAGENTA);
                   a.setFont(font);
                   a.drawImage( fact.getPhoto('5'), 0, 0 , jframewin);
                  a.drawString("YOU WIN !!!", 512/4, 512/2);
                }
            };
          

      
            jframewin.setContentPane(panel);
            jframewin.setVisible(true);
        }

        
        
        
        
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
