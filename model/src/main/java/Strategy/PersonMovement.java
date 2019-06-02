package Strategy;

import contract.IMobile;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonMovement.
 */
public class PersonMovement extends MobileComport{

	
	/**
	 * Instantiates a new person movement.
	 *
	 * @param mobile the mobile
	 */
	public PersonMovement(IMobile mobile) {
		super(mobile);
		
	}

	/**
	 * Move left.
	 */
	public void moveLeft() {
		// TODO Auto-generated method stub
		
		this.coordonneesX(-1);
	}

	/**
	 * Move right.
	 */
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		this.coordonneesX(1);
	}

	/**
	 * Move up.
	 */
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		this.coordonneesY(-1);
	}

	/**
	 * Move down.
	 */
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		this.coordonneesY(1);
	}
	

}
