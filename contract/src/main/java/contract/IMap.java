/*
 * @Author: Jougleux Bryan
 */
package contract;



// TODO: Auto-generated Javadoc
/**
 * The Interface IMap.
 */
public interface IMap extends Runnable{

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	int getHeight();

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	void setHeight(int height);

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	int getWidth();

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	void setWidth(int width);

	/**
	 * Gets the on the map XY.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the on the map XY
	 */
	IElement getOnTheMapXY(int x, int y);

	/**
	 * Sets the on the map XY.
	 *
	 * @param element the element
	 * @param x the x
	 * @param y the y
	 */
	void setOnTheMapXY(IElement element, int x, int y);
	
	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	IMobile getMobile();
	
	/**
	 * Update rocher.
	 */
	public void updateRocher();
	
	/**
	 * Update diamonds.
	 */
	public void updateDiamonds();
	
	/**
	 * Sets the diam player.
	 *
	 * @param value the new diam player
	 */
	public void setDiamPlayer(int value);
	
	/**
	 * Gets the diam player.
	 *
	 * @return the diam player
	 */
	public int getDiamPlayer();
	
	/**
	 * Gets the XY door.
	 *
	 * @param value the value
	 * @return the XY door
	 */
	public int getXYDoor(int value);
	
	/**
	 * Gets the compte diamant.
	 *
	 * @return the compte diamant
	 */
	public int getCompteDiamant();

	
	/**
	 * Delet diamond.
	 */
	public void DeletDiamond();
	
	/**
	 * Update object.
	 */
	public void updateObject();

	/**
	 * Sets the tab.
	 *
	 * @param X the x
	 * @param Y the y
	 * @param Pos the pos
	 */
	public void setTab(int X, int Y, int Pos);
}