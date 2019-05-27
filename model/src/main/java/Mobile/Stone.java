package Mobile;

import Element.Permeability;
import Strategy.ElementMovement;

public class Stone extends Mobile{

	public Stone() {
		super(Permeability.Push, 'P');
		this.setMovement(new ElementMovement(this));
	}

}
