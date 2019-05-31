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
	private int Longueur = 960;
	private int Largeur = 640;

	private String Java = "BoulderDash";
	private ViewPanel viewpanel = new ViewPanel(this);
	private PanelA panA = new PanelA();
	
	
	public ViewFrame(int id_map) {
		//setMapTaille(id_map);
		VuePrincipal();
		
	}
	
	
	
	public void VuePrincipal()
	{
		this.setViewpanel(viewpanel);
		
		
		this.setSize(Longueur, Largeur);
		this.setLocationRelativeTo(null);
		this.setTitle(Java);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(viewpanel);
		this.setVisible(true);
		/*
		try
		{
		    Thread.sleep(2000);
		    this.getContentPane().removeAll();
		    this.getContentPane().add(viewpanel);
		
		    this.resize(800, 800);
		    this.setLocationRelativeTo(null);
		    this.revalidate();
		    this.repaint();
		 	
		 	while(true)
		 	{
		 		Thread.sleep(500);
			 	 
			 	 System.out.print(panA.getMap());
		 	}
		 	 
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
			
		*/
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
