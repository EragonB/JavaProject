package contract;



// TODO: Auto-generated Javadoc
/**
 * The Interface IMobile.
 */
public interface IMobile extends IElement{

	/**
	 * Alive.
	 *
	 * @return the state
	 */
	State alive();

	/**
	 * Finish.
	 */
	void finish();
	
	/**
	 * Die.
	 */
	void die();

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	int getX();

	/**
	 * Sets the XY.
	 *
	 * @param x the x
	 * @param y the y
	 */
	void setXY(int x, int y);

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	int getY();

	

	/**
	 * Gets the last position X.
	 *
	 * @return the last position X
	 */
	int getLastPositionX();

	/**
	 * Sets the last position X.
	 *
	 * @param lastPositionX the last position X
	 * @param lastPositionY the last position Y
	 */
	void setLastPositionX(int lastPositionX, int lastPositionY);

	/**
	 * Gets the last position Y.
	 *
	 * @return the last position Y
	 */
	int getLastPositionY();



	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	State getState();

	/**
	 * Gugus form.
	 *
	 * @param c the c
	 */
	public void GugusForm(char c);
	
	/**
	 * Gets the movement.
	 *
	 * @return the movement
	 */
	IMovement getMovement();

	/**
	 * Sets the movement.
	 *
	 * @param movement the new movement
	 */
	void setMovement(IMovement movement);

}