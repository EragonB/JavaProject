package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

public class Diamond extends Mobile{
	
	public Diamond(int x, int y)
	{
		super(Permeability.Recover, 'D');
		this.x = x;
		this.y = y;
		this.setMovement(new ElementMovement(this));
	}

}
