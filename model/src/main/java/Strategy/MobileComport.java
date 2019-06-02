package Strategy;

import contract.IMobile;
import contract.IMovement;


public abstract class MobileComport implements IMovement{
	
	private IMobile mobile;
	public MobileComport(IMobile mobile)
	{
		this.mobile=mobile;
	}
	
	public void moveChoice(int value)
	{
		switch(value)
		{
		case 1:
			moveUp();
			break;
			
		case 2:
			moveDown();
			break;
			
		case 3:
			moveLeft();
		break;

		case 4:
			moveRight();
			break;
		}
	}
	
	@Override
	public void moveLeft() {
	}
	
	@Override
	public void moveRight() {
	}
	
	@Override
	public void moveUp() {
	}
	
	@Override
	public abstract void moveDown();
	
	public void coordonneesX(int i)
	{

		this.mobile.setXY(this.mobile.getX()+(1*i), this.mobile.getY());
		
	}
	
	public void coordonneesY(int i)
	{
		this.mobile.setXY(this.mobile.getX(),this.mobile.getY()+(1*i));
	}
	
}
