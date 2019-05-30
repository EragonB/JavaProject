package view;


import contract.IController;
import contract.IMap;

import contract.IView;

public final class View implements IView{
	private ViewFrame viewframe;
	
	private IController controller;

	public View() {
		this.viewframe = new ViewFrame(3);
	}
	
	public void setFrame(int id_map)
	{
		this.viewframe = new ViewFrame(id_map);
	}
	
	public ViewFrame getViewframe() {
		return this.viewframe;
	}

	public void ReadBoard(IMap tableau)
	  {
	  this.getPanel().loadmap(tableau);      
	  }
	  
	  public ViewPanel getPanel()
	  {
		  return this.viewframe.getViewpanel();
	  }


	public void setController(IController controller) {
		// TODO Auto-generated method stub
		this.controller=controller;
		this.viewframe.addObserver(this.controller.getModel());
	}


	public void AddKeyListener()
	{
		this.viewframe.addKeyListener(new KeyEvent(this.controller));
	}
}
