package controller;

import contract.IController;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {

	private IView	view; 

	private IModel	model;
	
	private char c;


	public Controller(final IView view, final IModel model) {
		
		this.setView(view);
		this.setModel(model);
		
		this.view.ReadBoard(this.model.getMap());
		this.view.setController(this);
		this.view.AddKeyListener();
		//this.model.play();
	}

	private void setView(final IView pview) {
		this.view = pview;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public IModel getModel()
	{
		return this.model;
	}
	
	public void move(int value)
	{
		this.getModel().getMap().getMobile().setLastPositionX(this.model.getMap().getMobile().getX(), this.model.getMap().getMobile().getY());
switch(value)
{
case 1:
	this.getModel().getMap().getMobile().getMovement().moveUp();
	this.c='O';
	System.out.println("UP");
	break;
case 2:
	this.getModel().getMap().getMobile().getMovement().moveDown();
	this.c='L';
	System.out.println("Down");
	break;
case 3:
	this.getModel().getMap().getMobile().getMovement().moveLeft();
	this.c='K';
	System.out.println("left");
	break;
case 4:
	this.getModel().getMap().getMobile().getMovement().moveRight();
	this.c='M';
	System.out.println("right");
	break;	
	
}
this.getModel().getMap().getMobile().GugusForm(c);
this.model.play();
	}

}
