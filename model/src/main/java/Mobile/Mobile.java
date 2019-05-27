package Mobile;

import Element.Element;
import Element.Permeability;
import Strategy.IMovement;

public abstract class Mobile extends Element{
	
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
	
	public State alive()
	{
		return State.Life;
	}
	
	public void die()
	{
		this.state=State.Dead;
	}
	
	public int getX() {
		return this.x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return this.y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getLastPositionX() {
		return this.LastPositionX;
	}


	public void setLastPositionX(int lastPositionX) {
		this.LastPositionX = lastPositionX;
	}


	public int getLastPositionY() {
		return this.LastPositionY;
	}


	public void setLastPositionY(int lastPositionY) {
		this.LastPositionY = lastPositionY;
	}


	public State getState() {
		return this.state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public IMovement getMovement() {
		return this.movement;
	}


	public void setMovement(IMovement movement) {
		this.movement = movement;
	}


	/*public ISpeed getSpeed() {
		return this.speed;
	}


	public void setSpeed(ISpeed speed) {
		this.speed = speed;
	}*/

}
