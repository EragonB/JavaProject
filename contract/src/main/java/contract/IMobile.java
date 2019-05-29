package contract;



public interface IMobile extends IElement{

	State alive();

	void die();

	int getX();

	void setXY(int x, int y);

	int getY();

	

	int getLastPositionX();

	void setLastPositionX(int lastPositionX, int lastPositionY);

	int getLastPositionY();



	State getState();

	public void GugusForm(char c);
	
	public void moveLeft();

	IMovement getMovement();

	void setMovement(IMovement movement);

}