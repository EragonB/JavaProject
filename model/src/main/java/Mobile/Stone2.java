package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

public class Stone2 extends Mobile{

	public Stone2(int x, int y) {
		
		super(Permeability.Push, 'P');
		this.x = x;
		this.y = y;
		this.setMovement(new ElementMovement(this));
	}
	
}
