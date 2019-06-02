package view;


import contract.IController;
import contract.IMap;

import contract.IView;

public final class View implements IView{
	private ViewFrame viewframe;
	
	private IController controller;

	public View() {
		this.viewframe = new ViewFrame();
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

	public void moveValue(int value) {}
	/*{
		switch(value)
		{
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
			
		default:
			return 0;
		}
	}*/

	public void AddKeyListener()
	{
		this.viewframe.addKeyListener(new KeyEvent(this.controller));
	}
}
