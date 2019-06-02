package Strategy;

import contract.IMobile;

// TODO: Auto-generated Javadoc
/**
 * The Class EntityMovement.
 */
public class EntityMovement extends MobileComport{

	/**
	 * Instantiates a new entity movement.
	 *
	 * @param mobile the mobile
	 */
	public EntityMovement(IMobile mobile) {
		super(mobile);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Move left.
	 */
	@Override
	public void moveLeft() {
		System.out.println("Je suis une entit�");
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
		this.coordonneesY(1);
	}

	/**
	 * Move down.
	 */
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		this.coordonneesY(-1);
	}

}
