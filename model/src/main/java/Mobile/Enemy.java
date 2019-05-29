package Mobile;

import Strategy.EntityMovement;
import contract.Permeability;


public class Enemy extends Mobile{

	public Enemy() {
		super(Permeability.Enemy, 'E');
		this.setMovement( new EntityMovement(this));
		}
}
