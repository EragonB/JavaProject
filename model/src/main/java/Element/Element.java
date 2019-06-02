/**
 * 
 */
package Element;

import contract.IElement;
import contract.Permeability;

// TODO: Auto-generated Javadoc
/**
 * The Class Element.
 *
 * @author Bryan
 */
public abstract class Element implements IElement {
	
	/** The permeability. */
	private Permeability permeability;
	
	/** The sprite. */
	private char sprite;
	
	
	/**
	 * Instantiates a new element.
	 *
	 * @param permeability the permeability
	 * @param sprite the sprite
	 */
	public Element(Permeability permeability, char sprite)
	{
		this.permeability=permeability;
		this.sprite=sprite;
	}
	
	
	/**
	 * Gets the permeability.
	 *
	 * @return the permeability
	 */
	public Permeability getPermeability() {
		return this.permeability;
	}
	
	/**
	 * Sets the permeability.
	 *
	 * @param permeability the new permeability
	 */
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	
	/**
	 * Gets the sprite.
	 *
	 * @return the sprite
	 */
	public char getSprite() {
		return this.sprite;
	}
	
	/**
	 * Sets the sprite.
	 *
	 * @param sprite the new sprite
	 */
	public void setSprite(char sprite) {
		this.sprite = sprite;
	}
	
	

}
