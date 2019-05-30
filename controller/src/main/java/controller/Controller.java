package controller;

import contract.IController;
import contract.IModel;
import contract.IView;

public final class Controller implements IController {

	private IView	view; 

	private IModel	model;
	
	private char c;


	public Controller(final IView view, final IModel model, int id_map) {
		
		this.setView(view);
		this.setModel(model);
		//setIdMap(id_map);
		
		
		this.view.ReadBoard(this.model.getMap());
		this.view.setController(this);
		this.view.AddKeyListener();
	}
	
	public void setIdMap(int id_map)
	{
		this.model.setIdMap(id_map);
		this.view.setFrame(id_map);
		
		this.model.start();
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
	
	break;
case 2:
	this.getModel().getMap().getMobile().getMovement().moveDown();
	this.c='L';
	
	break;
case 3:
	this.getModel().getMap().getMobile().getMovement().moveLeft();
	this.c='K';
	
	break;
case 4:
	this.getModel().getMap().getMobile().getMovement().moveRight();
	this.c='M';
	
	break;	
	
}
this.getModel().getMap().getMobile().GugusForm(c);
this.model.play();
	}

}
