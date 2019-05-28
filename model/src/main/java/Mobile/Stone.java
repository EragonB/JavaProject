package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

public class Stone extends Mobile{

	public Stone() {
		super(Permeability.Push, 'P');
		this.setMovement(new ElementMovement(this));
	}

}
