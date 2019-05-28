package Mobile;

import Element.Permeability;
import Strategy.ElementMovement;

public class Diamond extends Mobile{
	
	public Diamond()
	{
		super(Permeability.Push, 'D');
		this.setMovement(new ElementMovement(this));
	}

}
