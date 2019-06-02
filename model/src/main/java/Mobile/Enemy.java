package Mobile;

import Strategy.EntityMovement;
import contract.Permeability;


public class Enemy extends Mobile{

	public Enemy(int x, int y) {
		super(Permeability.Enemy, 'E');
		this.x = x;
		this.y = y;
		this.setMovement( new EntityMovement(this));
		}
}
