package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

public class Diamond extends Mobile{
	
	public Diamond()
	{
		super(Permeability.Push, 'D');
		this.setMovement(new ElementMovement(this));
	}

}
