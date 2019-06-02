package Mobile;

import Strategy.EntityMovement;
import contract.Permeability;


// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
 */
public class Enemy extends Mobile{

	/**
	 * Instantiates a new enemy.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Enemy(int x, int y) {
		super(Permeability.Enemy, 'E');
		this.x = x;
		this.y = y;
		this.setMovement( new EntityMovement(this));
		}
}
