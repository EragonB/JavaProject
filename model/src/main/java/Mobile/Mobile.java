package Mobile;

import Element.Element;
import contract.IMobile;
import contract.IMovement;
import contract.Permeability;
import contract.State;

// TODO: Auto-generated Javadoc
/**
 * The Class Mobile.
 */
public abstract class Mobile extends Element implements IMobile{
	
	/** The x. */
	protected int x;
	
	/** The y. */
	protected int y;
	
	/** The Last position X. */
	protected int LastPositionX;
	
	/** The Last position Y. */
	protected int LastPositionY;
	
	/** The state. */
	protected State state;
	
	/** The movement. */
	protected IMovement movement;
	
	
	/**
	 * Instantiates a new mobile.
	 *
	 * @param permeability the permeability
	 * @param sprite the sprite
	 */
	public Mobile(Permeability permeability, char sprite) {
		super(permeability, sprite);
		this.state=this.alive();
		
	}
	
	/**
	 * Finish.
	 */
	public void finish()
	{
		this.state=State.Finish;
	}
	
	/**
	 * Alive.
	 *
	 * @return the state
	 */
	@Override
	public State alive()
	{
		return State.Life;
	}
	
	/**
	 * Die.
	 */
	@Override
	public void die()
	{
		this.state=State.Dead;
		
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	@Override

	public int getX() {
		return this.x;
	}

	/**
	 * Sets the XY.
	 *
	 * @param x the x
	 * @param y the y
	 */
	@Override
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	@Override
	public int getY() {
		return this.y;
	}

	/**
	 * Gets the last position X.
	 *
	 * @return the last position X
	 */
	@Override
	public int getLastPositionX() {
		return this.LastPositionX;
	}

	/**
	 * Sets the last position X.
	 *
	 * @param lastPositionX the last position X
	 * @param lastPositionY the last position Y
	 */
	@Override
	public void setLastPositionX(int lastPositionX, int lastPositionY) {
		this.LastPositionX = lastPositionX;
		this.LastPositionY = lastPositionY;
	}

	/**
	 * Gets the last position Y.
	 *
	 * @return the last position Y
	 */
	@Override
	public int getLastPositionY() {
		return this.LastPositionY;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	@Override
	public State getState() {
		return this.state;
	}

	/**
	 * Gets the movement.
	 *
	 * @return the movement
	 */
	public IMovement getMovement() {
		return this.movement;
	}

	/**
	 * Sets the movement.
	 *
	 * @param movement the new movement
	 */
	public void setMovement(IMovement movement) {
		this.movement = movement;
	}
	
	/**
	 * Gugus form.
	 *
	 * @param value the value
	 */
	public void GugusForm(char value)
	{
	this.setSprite(value);
		
	}

}
