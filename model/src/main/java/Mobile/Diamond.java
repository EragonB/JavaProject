package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class Diamond.
 */
public class Diamond extends Mobile{
	
	private int Strengh = 0;
	/**
	 * Instantiates a new diamond.
	 *
	 * @param x the x
	 * @param y the y
	 */
	
	public Diamond(int x, int y)
	{
		super(Permeability.Recover, 'D');
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
