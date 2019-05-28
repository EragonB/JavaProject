package Mobile;

import Element.Element;
import Strategy.IMovement;
import contract.IMobile;
import contract.Permeability;
import contract.State;

public abstract class Mobile extends Element implements IMobile{
	
	protected int x;
	protected int y;
	protected int LastPositionX;
	protected int LastPositionY;
	protected State state;
	protected IMovement movement;
	//protected ISpeed speed;
	
	
	public Mobile(Permeability permeability, char sprite/*, IMovement movement, ISpeed speed*/) {
		super(permeability, sprite);
		this.state=this.alive();
		//this.movement=movement;
		
	}
	
	@Override
	public State alive()
	{
		return State.Life;
	}
	
	@Override
	public void die()
	{
		this.state=State.Dead;
	}
	
	@Override
	public int getX() {
		return this.x;
	}


	@Override
	public void setX(int x) {
		this.x = x;
	}


	@Override
	public int getY() {
		return this.y;
	}


	@Override
	public void setY(int y) {
		this.y = y;
	}


	@Override
	public int getLastPositionX() {
		return this.LastPositionX;
	}


	@Override
	public void setLastPositionX(int lastPositionX) {
		this.LastPositionX = lastPositionX;
	}


	@Override
	public int getLastPositionY() {
		return this.LastPositionY;
	}


	@Override
	public void setLastPositionY(int lastPositionY) {
		this.LastPositionY = lastPositionY;
	}


	@Override
	public State getState() {
		return this.state;
	}


	@Override
	public void setState(State state) {
		this.state = state;
	}



	public IMovement getMovement() {
		return this.movement;
	}



	public void setMovement(IMovement movement) {
		this.movement = movement;
	}

	public void moveLeft()
	{
		this.setX(getX()+1);
	}

	/*public ISpeed getSpeed() {
		return this.speed;
	}


	public void setSpeed(ISpeed speed) {
		this.speed = speed;
	}*/

}
