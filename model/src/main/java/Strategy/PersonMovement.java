package Strategy;

import contract.IMobile;

public class PersonMovement extends MobileComport{

	
	public PersonMovement(IMobile mobile) {
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
