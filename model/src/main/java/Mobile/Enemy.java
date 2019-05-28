package Mobile;

import Strategy.EntityMovement;
import contract.Permeability;


public class Enemy extends Mobile{

	public Enemy() {
		super(Permeability.Blocking, 'E');
		this.setMovement( new EntityMovement(this));
		}
}
