package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

public class Stone extends Mobile{

	public Stone(int x, int y) {
		super(Permeability.Push, 'P');
		this.x = x;
		this.y = y;
		this.setMovement(new ElementMovement(this));
	}

}
