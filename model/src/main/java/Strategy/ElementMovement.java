package Strategy;

import contract.IMobile;

// TODO: Auto-generated Javadoc
/**
 * The Class ElementMovement.
 */
public class ElementMovement extends MobileComport{


	/**
	 * Instantiates a new element movement.
	 *
	 * @param mobile the mobile
	 */
	public ElementMovement(IMobile mobile) {
		super(mobile);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Move down.
	 */
	@Override
	public void moveDown() {
		this.coordonneesY(-2);
		
	}
}
