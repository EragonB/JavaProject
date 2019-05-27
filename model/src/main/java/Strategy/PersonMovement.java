package Strategy;

import Mobile.Mobile;

public class PersonMovement extends MobileComport{

	
	public PersonMovement(Mobile mobile) {
		super(mobile);
		
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		System.out.println("Je suis une personne");
		this.coordonneesX(-1);
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		this.coordonneesX(1);
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		this.coordonneesY(1);
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		this.coordonneesY(-1);
	}

}
