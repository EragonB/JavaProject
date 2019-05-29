package Mobile;

import Strategy.ElementMovement;
import contract.Permeability;

public class Diamond2 extends Mobile{
	
	public Diamond2(int x, int y)
	{
		super(Permeability.Push, 'D');
		this.x	=	x;
		this.y	=	y;
		this.setMovement(new ElementMovement(this));
	}

}
