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
	public Stone(int x, int y) {
		super(Permeability.Push, 'P');
		this.x = x;
		this.y = y;
		this.setMovement(new ElementMovement(this));
	}

}
