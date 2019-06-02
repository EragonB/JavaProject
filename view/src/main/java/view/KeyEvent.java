package view;

import java.awt.event.KeyListener;

import contract.IController;


// TODO: Auto-generated Javadoc
/**
 * The Class KeyEvent.
 */
public class KeyEvent implements KeyListener {

/** The control. */
private IController control;
	
	/**
	 * Instantiates a new key event.
	 *
	 * @param controller the controller
	 */
	public KeyEvent(IController controller) {
		this.control=controller;
	}

	/**
	 * Key pressed.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void keyPressed(java.awt.event.KeyEvent arg0) {}

	/**
	 * Key released.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void keyReleased(java.awt.event.KeyEvent arg0) {}

	/**
	 * Key typed.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Try without control
		char caracterInput=arg0.getKeyChar();
		
		switch(caracterInput)
		{
		case 'z':
			this.control.move(1);
			break;
			
		case 's':
			this.control.move(2);
			break;
			
		case 'q':
			this.control.move(3);
		break;
		
		case 'd':
			this.control.move(4);
			break;
		}
	}
}
