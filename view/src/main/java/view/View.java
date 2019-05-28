package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import contract.IMap;
import contract.IView;

public final class View implements IView{
	private ViewFrame viewframe;

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
	
}
