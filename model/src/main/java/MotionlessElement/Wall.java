package MotionlessElement;

import contract.Permeability;

public class Wall extends MotionlessElement{
	
	public Wall()
	{
		super(Permeability.Blocking, 'X');
	}

}
