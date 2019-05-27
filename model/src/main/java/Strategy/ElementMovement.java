package Strategy;

import Mobile.Mobile;

public class ElementMovement extends MobileComport{


	public ElementMovement(Mobile mobile) {
		super(mobile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveDown() {
		this.coordonneesY(-2);
		
	}
}
