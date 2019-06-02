package Mobile;

import Strategy.PersonMovement;
import contract.Permeability;

public class Gugus extends Mobile{

	public Gugus() {
		super(Permeability.Passable, 'M');
		this.setMovement( new PersonMovement(this));
		}
	
	

}
