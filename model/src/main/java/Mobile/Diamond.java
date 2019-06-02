package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class Diamond.
 */
public class Diamond extends Mobile{
	
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

}
