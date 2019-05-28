package contract;



public interface IMobile extends IElement{

	State alive();

	void die();

	int getX();

	void setX(int x);

	int getY();

	void setY(int y);

	int getLastPositionX();

	void setLastPositionX(int lastPositionX);

	int getLastPositionY();

	void setLastPositionY(int lastPositionY);

	State getState();

	void setState(State state);
	
	public void moveLeft();

	/*IMovement getMovement();

	void setMovement(IMovement movement);*/

}