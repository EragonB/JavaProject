package Mobile;

import Element.Permeability;
import Strategy.EntityMovement;


public class Enemy extends Mobile{

	public Enemy() {
		super(Permeability.Blocking, 'E');
		this.setMovement( new EntityMovement(this));
		}
}
