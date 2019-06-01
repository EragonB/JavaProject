package Strategy;

import contract.IMobile;
import contract.IMovement;


// TODO: Auto-generated Javadoc
/**
 * The Class MobileComport.
 */
public abstract class MobileComport implements IMovement{
	
	/** The mobile. */
	private IMobile mobile;
	
	/**
	 * Instantiates a new mobile comport.
	 *
	 * @param mobile the mobile
	 */
	public MobileComport(IMobile mobile)
	{
		this.mobile=mobile;
	}
	
	/**
	 * Move choice.
	 *
	 * @param value the value
	 */
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
	
	/**
	 * Move left.
	 */
	@Override
	public void moveLeft() {
	}
	
	/**
	 * Move right.
	 */
	@Override
	public void moveRight() {
	}
	
	/**
	 * Move up.
	 */
	@Override
	public void moveUp() {
	}
	
	/**
	 * Move down.
	 */
	@Override
	public abstract void moveDown();
	
	/**
	 * Coordonnees X.
	 *
	 * @param i the i
	 */
	public void coordonneesX(int i)
	{

		this.mobile.setXY(this.mobile.getX()+(1*i), this.mobile.getY());
		
	}
	
	/**
	 * Coordonnees Y.
	 *
	 * @param i the i
	 */
	public void coordonneesY(int i)
	{
		this.mobile.setXY(this.mobile.getX(),this.mobile.getY()+(1*i));
	}
	
}
