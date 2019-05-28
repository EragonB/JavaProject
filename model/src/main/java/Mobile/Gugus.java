package Mobile;

import Strategy.PersonMovement;
import contract.Permeability;

public class Gugus extends Mobile{

	public Gugus() {
		super(Permeability.Passable, 'M');
		this.setMovement( new PersonMovement(this));
		}
	
	public void GugusUp()
	{
		this.setSprite('O');
	}

	public void GugusDown()
	{
		this.setSprite('L');
	}
	
	public void GugusLeft()
	{
		this.setSprite('K');
	}
	
	public void GugusRight()
	{
		this.setSprite('M');
	}
}
