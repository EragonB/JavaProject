package view;


import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import contract.*;


/**
 * The Class View.
 */
public final class View implements IView{
	
	/** The viewframe. */
	private ViewFrame viewframe;

	/**
	 * Instantiates a new view.
	 */
	public View() {
		this.viewframe = new ViewFrame(3);
	}
	
	/**
	 * Gets the viewframe.
	 *
	 * @return the viewframe
	 */
	public JFrame getViewframe() {
		return this.viewframe;
	}
	
	public Observer getObserver()
	{
		return viewframe.getViewpanel().getObserverViewPanel();
	}

	/**
	 * Read board.
	 *
	 * @param tableau the tableau
	 */
	public void ReadBoard(IMap table)
	  {
		this.viewframe.getViewpanel().loadmap(table);
		    
	  }
	  
	  /**
  	 * Gets the panel.
  	 *
  	 * @return the panel
  	 */
  	public JPanel getPanel()
	  {
		  return this.viewframe.getViewpanel();
	  }
  	
  	public void frame(int value)
  	{
  		this.viewframe.FrameDie(value);
  	}

  	public void frame(int value)
  	{
  		this.viewframe.FrameDie(value);
  	}
}
