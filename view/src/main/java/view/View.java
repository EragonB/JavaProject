package view;


import contract.IController;
import contract.IMap;

import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public final class View implements IView{
	
	/** The viewframe. */
	private ViewFrame viewframe;
	
	/** The controller. */
	private IController controller;

	/**
	 * Instantiates a new view.
	 */
	public View() {
		this.viewframe = new ViewFrame(3);
	}
	
	/**
	 * Sets the frame.
	 *
	 * @param id_map the new frame
	 */
	public void setFrame(int id_map)
	{
		this.viewframe = new ViewFrame(id_map);
	}
	
	/**
	 * Gets the viewframe.
	 *
	 * @return the viewframe
	 */
	public ViewFrame getViewframe() {
		return this.viewframe;
	}

	/**
	 * Read board.
	 *
	 * @param tableau the tableau
	 */
	public void ReadBoard(IMap tableau)
	  {
	  this.getPanel().loadmap(tableau);      
	  }
	  
	  /**
  	 * Gets the panel.
  	 *
  	 * @return the panel
  	 */
  	public ViewPanel getPanel()
	  {
		  return this.viewframe.getViewpanel();
	  }


	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	public void setController(IController controller) {
		// TODO Auto-generated method stub
		this.controller=controller;
		this.viewframe.addObserver(this.controller.getModel());
	}


	/**
	 * Adds the key listener.
	 */
	public void AddKeyListener()
	{
		this.viewframe.addKeyListener(new KeyEvent(this.controller));
	}
}
