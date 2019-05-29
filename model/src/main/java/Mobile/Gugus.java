package Mobile;

import Strategy.PersonMovement;
import contract.Permeability;

public class Gugus extends Mobile{

	public Gugus() {
		super(Permeability.Passable, 'M');
		this.setMovement( new PersonMovement(this));
		}
	
	public void GugusForm(int value)
	{
		
		switch(value)
		{
		case 1:
			this.setSprite('O');
			break;
			
		case 2:
			this.setSprite('L');
			break;
			
		case 3:
			this.setSprite('K');
			break;
			
		case 4:
			this.setSprite('M');
			break;
		}
		
	}

}
