package Mobile;

import Strategy.PersonMovement;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class Gugus.
 */
public class Gugus extends Mobile{

	/**
	 * Instantiates a new gugus.
	 */
	public Gugus() {
		super(Permeability.Passable, 'M');
		this.setMovement( new PersonMovement(this));
		}
	
	

}
