package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class Stone.
 */
public class Stone extends Mobile{

	/**
	 * Instantiates a new stone.
	 *
	 * @param x the x
	 * @param y the y
	 */
	private int Strengh = 0;
	
	public Stone(int x, int y) {
		super(Permeability.Push, 'P');
		this.x = x;
		this.y = y;
		this.setMovement(new ElementMovement(this));
	}


	public int getStrengh()
	{
		return this.Strengh;
	}
	
	public void setStrengh(int value)
	{
		this.Strengh = value;
	}
}
