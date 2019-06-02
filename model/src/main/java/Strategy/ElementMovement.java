package Strategy;

import contract.IMobile;

public class ElementMovement extends MobileComport{


	public ElementMovement(IMobile mobile) {
		super(mobile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveDown() {
		this.coordonneesY(-2);
		
	}
}
